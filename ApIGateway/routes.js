const ROUTES = [
    {
        url: '/addtocart',
        auth: false,
        creditCheck: false,
        rateLimit: {
            windowMs: 15 * 60 * 1000,
            max: 10
        },
        proxy: {
            target: "http://localhost:8080/food-delivery/cart/add",
            changeOrigin: true,
            pathRewrite: {
                [`^/addtocart`]: '',
            },
        }
    },
    {
        url: '/login',
        auth: false,
        creditCheck: false,
        rateLimit: {
            windowMs: 15 * 60 * 1000,
            max: 5
        },
        proxy: {
            target: "http://localhost:8080/food-delivery/api/auth/login",
            changeOrigin: true,
            pathRewrite: {
                [`^/login`]: '',
            },
        }
    },
    {
        url: '/viewcart',
        auth: true,
        creditCheck: true,
        rateLimit: {
            windowMs: 15 * 60 * 1000,
            max: 5
        },
        proxy: {
            target: "http://localhost:8080/food-delivery/cart",
            changeOrigin: true,
            pathRewrite: {
                [`^/viewcart`]: '',
            },
        }
    },
    {
        url: '/placeorder',
        auth: true,
        creditCheck: true,
        rateLimit: {
            windowMs: 15 * 60 * 1000,
            max: 15
        },
        proxy: {
            target: "http://localhost:8080/food-delivery/orders",
            changeOrigin: true,
            pathRewrite: {
                [`^/placeorder`]: '',
            },
        }
    },
    {
        url: '/createmenu',
        auth: true,
        creditCheck: true,
        rateLimit: {
            windowMs: 15 * 60 * 1000,
            max: 15
        },
        proxy: {
            target: "http://localhost:8080/food-delivery//api/menus",
            changeOrigin: true,
            pathRewrite: {
                [`^/createmenu`]: '',
            },
        }
    }
]

exports.ROUTES = ROUTES;