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
        auth: true,
        creditCheck: false,
        rateLimit: {
            windowMs: 15 * 60 * 1000,
            max: 3
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
        url: '/register',
        auth: true,
        creditCheck: false,
        rateLimit: {
            windowMs: 15 * 60 * 1000,
            max: 3
        },
        proxy: {
            target: "http://localhost:8080/food-delivery/api/auth/register",
            changeOrigin: true,
            pathRewrite: {
                [`^/register`]: '',
            },
        }
    },
    {
        url: '/viewcart',
        auth: false,
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
        auth: false,
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
        auth: false,
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