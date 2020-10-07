const express = require('express')
const app = express()

const bodyParser = require('body-parser')
app.use(bodyParser.urlencoded({ extended: false }))
app.use(bodyParser.json())

var { fakeBooks } = require('./fakeData')
app.get('/books', function(req, res) {
    res.json({
        result: "ok",
        data: fakeBooks
    })
})

app.post('/books', function(req, res) {
    const { id, imageUrl, name, author, rate, description } = req.body
    console.log(JSON.stringify(req.body))
    fakeBooks.push({ id, imageUrl, name, author, rate, description })
    res.json({
        result: "ok",
        data: fakeBooks
    })
})
const PORT = 3000
app.listen(PORT, () => {
    console.log(`Server listening at http://localhost:${PORT}`)
})