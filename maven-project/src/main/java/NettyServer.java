import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.*;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;

import java.net.InetSocketAddress;
import java.util.concurrent.*;

/**
 * @author : zhixian.song
 * @description : TODO
 * @time : 2022.1.11 上午 11:08
 */
public class NettyServer {
    final static int PORT = 8080;

    public static void main(String[] args) {
        Server server = new Server();
        server.config(PORT);
        server.start();
    }
}

class Server {
    ServerBootstrap bootstrap;
    Channel parentChannel;
    InetSocketAddress localAddress;
    MyChannelHandler channelHandler = new MyChannelHandler();

    //获取系统处理器个数，作为线程池数量
    int nThreads = Runtime.getRuntime().availableProcessors();
    ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
            .setNameFormat("demo-pool-%d").build();

    //Common Thread Pool
    ExecutorService pool = new ThreadPoolExecutor(nThreads
            , 200
            , 0L, TimeUnit.MILLISECONDS
            , new LinkedBlockingQueue<Runnable>(1024)
            , namedThreadFactory
            , new ThreadPoolExecutor.AbortPolicy());
    //Thread Pool2
    ExecutorService pool2 = new ThreadPoolExecutor(5, 200,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

    Server() {
        bootstrap = new ServerBootstrap(new NioServerSocketChannelFactory(
                Executors.newCachedThreadPool(), pool));
        bootstrap.setOption("reuseAddress", true);
        bootstrap.setOption("child.tcpNoDelay", true);
        bootstrap.setOption("child.soLinger", 2);
        bootstrap.getPipeline().addLast("servercnfactory", channelHandler);
    }

    void config(int port) {
        this.localAddress = new InetSocketAddress(port);
    }

    void start() {
        parentChannel = bootstrap.bind(localAddress);
    }

    static class MyChannelHandler extends SimpleChannelHandler {

        @Override
        public void channelClosed(ChannelHandlerContext ctx, ChannelStateEvent e)
                throws Exception {
            System.out.println("Channel closed关闭::::::::: " + e);
        }

        @Override
        public void channelConnected(ChannelHandlerContext ctx,
                                     ChannelStateEvent e) throws Exception {
            System.out.println("Channel connected连接::::::::: " + e);
        }

        @Override
        public void messageReceived(ChannelHandlerContext ctx, MessageEvent e)
                throws Exception {
            try {
                System.out.println("新消息::::::::: " + e.toString() + " 消息来自::::::::: "
                        + ctx.getChannel());
                processMessage(e);
            } catch (Exception ex) {
                ex.printStackTrace();
                throw ex;
            }
        }

        private void processMessage(MessageEvent e) {
            Channel ch = e.getChannel();
            ch.write(e.getMessage());
        }
    }
}
