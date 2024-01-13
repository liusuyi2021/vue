const {defineConfig} = require('@vue/cli-service')
module.exports = defineConfig({
    transpileDependencies: true,
    lintOnSave: false, // 关闭语法检查 防止不必要的语法报错
    devServer: {
        host: "localhost",
        port: 8080,
        //代理
        proxy: {
            "/api": {
                // 目标地址
                target: "http://localhost:8081",
                //请求重写路径么？
                ws: true,
                // 重写路径: 去掉路径中开头的/api
                pathRewrite: {
                    '^/api': ''
                },
                //改变跨域么？
                changeOrigin: true
            }
        }
    }
})

