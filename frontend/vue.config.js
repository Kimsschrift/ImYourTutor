const { defineConfig } = require("@vue/cli-service");
module.exports = defineConfig({
  transpileDependencies: true,
  lintOnSave: false,
  devServer: {
    client: {
      overlay: false
    }
  },
  chainWebpack: config => {
    if (process.env.NODE_ENV === 'development') {
      config.devtool('eval-cheap-module-source-map');
    }
  }
});
