package com.song.springboot.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @author : zhixian.song
 * @description : TODO
 * @time : 2021/7/7 18:07
 */
public class Jdbc {
}

class TestMysql {
    //链接地址
    private static String URL = "jdbc:mysql://localhost:3306/thebestdatabaseintheworld?useSSL=true&useUnicode=true&characterEncoding=UTF-8";
    //驱动名称
    private static String DRIVER = "com.mysql.cj.jdbc.Driver";
    //用户名
    private static String USER = "root";
    //密码
    private static String PASSWORD = "123456";

    //加载驱动信息
    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        //获取Connection对象
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        System.out.println(conn);

        //准备一条sql语句
        String sql = "INSERT INTO book(book_id,name,number) "
                + "VALUES(1009,'123',996)";
        //获取发送sql语句的对象
        //获取方法一，PreparedStatement可以对sql语句预编译，在数据库中直接执行，效率高
//		PreparedStatement pst = conn.prepareStatement(sql);
//		int row = pst.executeUpdate();
//		System.out.println("插入了 " + row + " 行数据。");

        //获取方法二,Statement不会进行预编译，且容易出现错误
        Statement st = conn.createStatement();
        int row = st.executeUpdate(sql);
        st.close();
        conn.close();
        System.out.println("插入了 " + row + " 行数据。");
    }
}

