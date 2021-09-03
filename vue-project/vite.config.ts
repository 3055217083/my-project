import {defineConfig} from 'vite'
import vue from '@vitejs/plugin-vue'
import {resolve} from 'path'

// https://vitejs.dev/config/

export default defineConfig(() => {
  return {
    esbuild: {
      // target: 'es2015'
    },
    alias: {
      '@': resolve(__dirname, './src'),
      'views': resolve(__dirname, './src/views'),
    },
    /*支持运行时编译*/
    runtimeCompiler: true,
    css: {

    },
    server: {
      proxy: {
       /* '/web': {
          target: "http://abc/",
          changeOrigin: true,
        },*/
      }
      ,open: true
    },
    optimizeDeps: {

    },
    build: {

    },
    plugins: [vue(),],
  };
});
