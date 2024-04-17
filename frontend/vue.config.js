module.exports = {
    transpileDependencies: ['vuetify'],
    devServer: {
        port: 8081,
        proxy: 'http://192.168.1.110:8085',
        allowedHosts: 'all',
        headers: {
            "Access-Control-Allow-Origin": "*",
            "Access-Control-Allow-Methods": "GET, POST, PUT, DELETE, PATCH, OPTIONS",
            "Access-Control-Allow-Headers": "X-Requested-With, content-type, Authorization"
        }
    }
}