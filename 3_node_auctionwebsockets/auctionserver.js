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

function onJoin(client){
    console.log("connection established")
    clients ++;
    usedID = clients;
    console.log({id: usedID, date:new Date()});
    clientData.set(client, {id: usedID, date:new Date()})
    client.send("welcome to my websocket");
    fullHistory.forEach( h => {
        client.send("H " + h);
    })
    client.send("D " + currentItem);
    wss.clients.forEach(thisone => {
        id = clientData.get(client).id
        thisone.send("U Client with ID: " + id + " has joined the auction");
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
    wss.clients.forEach(client => {
        id = clientData.get(client_left).id
        client.send("U Client with ID: " + id + " has left the auction");
    })
}