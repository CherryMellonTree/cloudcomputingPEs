const WebSocket = require('ws')
const wss = new WebSocket.Server({port:3269})
let teller = 0;
let clients = 0;
let clientData = new Map();
let highestBid = 0;
let currentItem = "liver";
let itemList = ["liver"];
let lastbid;
let fullHistory = []
wss.on('connection', ws => {
    onJoin(ws);

    ws.on('message', msg=>{
        triggerMessageEvent(ws, msg);
    })
    ws.on('close', msg => {
        clientLeft(ws, msg);
    })
})

function onJoin(ws){
    console.log("connection established")
    clients ++;
    usedID = clients;
    console.log({id: usedID, date:new Date()});
    clientData.set(ws, {id: usedID, date:new Date()})
    ws.send("welcome to my websocket");
    fullHistory.forEach( h => {
        ws.send("H " + h);
    })
    ws.send("D " + currentItem);
    wss.clients.forEach(client => {
        client.send("U " + client + " : A client has joined the service");
    })

}

async function triggerMessageEvent(ws, msg){
    teller++;
    console.log(msg + " received as message number"+ teller + " from " + clientData.get(ws).id);
    msg = ('' + msg)
    console.log(typeof(msg))
    messageList = msg.split(" ")
    let keyword = messageList[0]
    switch (keyword){
        case 'RequestingAdmin':
            console.log("granting acess")
            ws.send("A")
            break;
        case 'Bid':
            console.log(messageList[1])
            if (Number(messageList[1])>Number(highestBid)){
                console.log("received bid, sending out data");
                highestBid = messageList[1];
                wss.clients.forEach(client => {
                    client.send("B "+ clientData.get(ws).id + " " + messageList[1] + " " + currentItem );
                })
                lastbid = currentItem + " " + clientData.get(ws).id + " " + messageList
            }
            else{
                console.log("not high enough of a bid")
            }
            break;
        case 'Stop':
            wss.clients.forEach(client => {
                client.send("C");
            })
            await new Promise(r => setTimeout(r, 2000));
            currentItem = itemList[0]
            wss.clients.forEach(client => {
                client.send("D " + itemList[0]);
                client.send("H " + lastbid);
            })
            itemList.shift();
            fullHistory.push(lastbid)
            highestBid = 0;
            break;
        case 'Item':
            itemList.push(msg.substring(5))
            console.log("added item")
            console.log(itemList)
            break;
        default:
            console.log("no proper parsing for this message!")

    }
}
function clientLeft(client_left, msg){
    console.log(msg)
    console.log(client_left)
    function toon(key, value) {
        console.log(key['id']);
        console.log(value)
    }
    clientData.forEach(toon);
    console.log(client_left)
    wss.clients.forEach(client => {
        id = clientData.get(client_left).id
        client.send("U " + id + "A client has left the service");
    })
}