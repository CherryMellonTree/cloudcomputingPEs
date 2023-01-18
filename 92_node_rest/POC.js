const express = require('express');
const bodyParser = require('body-parser');

const app = express();
app.use(bodyParser.json());

let messages = ["Hello, World!", "Welcome to my API", "Goodbye"];
let secretKey = 'SECRETS_THERE_ARE';
let verySecretKey = 'adminaccess';


app.get('/message/get/rand', (req, res) => {
  let message = messages[Math.floor(Math.random() * messages.length)];
  res.send(message);
});

app.get('/message/get/all', (req, res) => {
    let message = messages;
    res.send(message);
  });

app.get('/message/get/:id', (req, res) => {
    const id = req.params.id;
    if (messages.length-1<id){
        res.status(404).send('Not Found');
    }else{
        let message = messages[id];
        if (message){
            res.send(message);
        }else{
            res.status(400).send("This id either has no message, or this route does not exist")
        }
    }
  });



app.post('/message/add', (req, res) => {
    let message = req.body.message;
    messages.push(message);
    res.send(`\"${message}\" added successfully.`);
});

app.put('/message/:id', (req, res) => {
    let key = req.header('Authorization');
    if(key !== secretKey && key !== verySecretKey) {
        res.status(401).send('Unauthorized');
    } else {
        let id = req.params.id;
        messages[id] = req.body.message;
        res.send(`Message with id ${id} updated successfully.`);
    }
});

app.delete('/message/:id', (req, res) => {
    let key = req.header('Authorization');
    if(key !== verySecretKey) {
        res.status(401).send('Unauthorized');
    } else {
        let id = req.params.id;
        messages.splice(id, 1);
        res.send(`Message with id ${id} deleted successfully.`);
    }
});

app.listen(3000, () => {
    console.log('Server listening on port 3000');
});

