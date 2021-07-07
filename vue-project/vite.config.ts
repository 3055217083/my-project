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
      'router': resolve(__dirname, './src/router'),
      'store': resolve(__dirname, './src/store'),
      'vue': 'vue/dist/vue.esm-bundler.js'
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
    },
    optimizeDeps: {

    },
    build: {

    },
    plugins: [vue(),],
  };
});
