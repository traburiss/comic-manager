module.exports={
  outputDir: '../src/main/resources/dist/',
  devServer: {
    port: 8081,
    proxy: {
      "/api": {
        target: 'http://localhost:8080/',
        changeOrigin: true, // 是否改变域名
        ws: true
      }
    }
  }
}
