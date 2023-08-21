const express = require('express')

const {ROUTES} = require("./routes");

const {setupLogging} = require("./logging");//For loggin information about the incoming requests
const {setupRateLimit} = require("./ratelimit");//for setting up reduced and more controlled load on certain micro services
const {setupProxies} = require("./proxy");//For setting up the proxy rules, responsible for redirecting incoming requests to actual micro services


const app = express()
const port = 3000;


setupLogging(app);
setupRateLimit(app, ROUTES);
setupProxies(app, ROUTES);



app.listen(port, () => {
    console.log(`GateWay listening at http://localhost:${port}`)
})



app.get('/info',(req,res,next)=>{
    res.send('testing the apigateway');
})
