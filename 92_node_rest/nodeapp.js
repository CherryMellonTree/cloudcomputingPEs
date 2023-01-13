const express = require('express');
const bodyParser = require('body-parser');

const app = express();
app.use(bodyParser.json());
let dummymessage = {
    "from": "Stephen",
    "to": "Auctionhouse.stonks",
    "amount": 40.3,
    "verified": false
}
let messages = [dummymessage, dummymessage, dummymessage];
let secretKey = 'SECRETS_THERE_ARE';
let verySecretKey = 'adminaccess';

function verifyMessageSyntax(message) {
    if (message.hasOwnProperty("from") && message.hasOwnProperty("to") && message.hasOwnProperty("amount")) {
        if (typeof message.from === "string" && typeof message.to === "string" && typeof message.amount === "number") {
            return true;
        }
    }
    return false;
}

app.get('/message/get/rand', (req, res) => {
    let message = messages[Math.floor(Math.random() * messages.length)];
    res.send(message);
  });

app.get('/message/get/all', (req, res) => {
    let message = messages;
    res.send(JSON.stringify(message));
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
    let message = req.body;
    if (verifyMessageSyntax(message)){
        let response = {"from":message["from"], "to":message["to"], "amount": message["amount"], "verified":false}
        messages.push(response);
        res.send(JSON.stringify(`Message added successfully.`));
    } else {
        res.status(400).send("incorrect message syntax");
    }
});

app.put('/message/:id', (req, res) => {
    let key = req.header('Authorization');
    const id = req.params.id;
    if(key !== secretKey && key !== verySecretKey) {
        res.status(401).send('Unauthorized');
    } else {
        let message = req.body;
        if (verifyMessageSyntax(message)){
            let response = {"from":message["from"], "to":message["to"], "amount": message["amount"], "verified":false}
            messages[id] = response;
            res.send(JSON.stringify(`Message updated successfully.`));
        } else {
            res.status(400).send("incorrect message syntax");
        }
    }
});
app.patch('/message/verify/:id', (req, res) => {
    let key = req.header('Authorization');
    const id = req.params.id;

    if(key !== secretKey && key !== verySecretKey) {
        res.status(401).send('Unauthorized');
    } else {
        let message = messages[id];
        if (message){
            message["verified"] = true;
            messages[id] = message;
            res.send("payment verified!");
        }else{
            res.status(400).send("This id either has no message, or this route does not exist")
        }
    }
})

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

