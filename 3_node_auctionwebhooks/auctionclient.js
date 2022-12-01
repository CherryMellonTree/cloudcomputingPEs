let mySocket = new WebSocket("ws://127.0.0.1:3269");
mySocket.addEventListener('open', 
    evt => {
        alert("socket opened!");
    }
);
mySocket.addEventListener('message', evt => {
    processMessage(evt)
})

function sendMsg(payload) {
    if (mySocket.readyState == WebSocket.OPEN) {
        mySocket.send(payload);
        console.log("msg sent");
    }
}

function processMessage(content){
    messageList = content.data.split(" ")
    let keyword = messageList[0]
    switch (keyword){
        case 'O':
            console.log('Welcome, you have connected to a socket server')
            break;
        case 'B':
            console.log('User ' + messageList[1] + ' has just bid ' + messageList[2] + ' on ' + messageList[3])
            addBid(messageList[1], messageList[2], messageList[3]);
            break;
        case 'A':
            console.log('Welcome, administrator, allow me to open the parts you will need:')
            allowAccess();
            break;
        case 'C':
            console.log("The current auction has ended");
            break;
        case 'D':
            startNewauction(messageList)
            break;
        case 'H':
            fixHistory(messageList);
            break;
        case 'U':
            updateUserLog(content.data.substring(2, content.data.length));
            break;
        default:
            alert(content.data);
    }
}
function updateUserLog(payload){
    let log = document.getElementById("userlog");
    let entry = document.createElement("li");
    let content = document.createTextNode(payload);
    entry.appendChild(content);
    log.appendChild(entry);


}
function addBid(name, price, item){
    let tr = createTR(item, name, price);
    let tablecontent =document.getElementById('offerTable');
    tablecontent.appendChild(tr);
}
function allowAccess(){
    let element = document.getElementById("adminRestricted");
    element.style.display = "block";
}
function requestAdmin(){
    sendMsg("RequestingAdmin");
}
function endBidding(){
    sendMsg("Stop");
};
function bid(){
    sendMsg("Bid " + document.getElementById("bidField").value)
};
function sendItem(){
    sendMsg("Item " + document.getElementById("sendItemInputField").value)
};

function startNewauction(messageList){
    let tablecontent =document.getElementById('offerTable');
    while(tablecontent.lastChild){
        tablecontent.removeChild(tablecontent.lastChild);
    }
    if (messageList[1]){
        document.getElementById('currentItem').innerHTML = messageList[1]
    }else{
        document.getElementById('currentItem').innerHTML = "No item currently for auction";
    }
};

function fixHistory(content){
    let tr = createTR(content[1], content[2], content[3].split(",").slice(1));
    let fullHistory = document.getElementById("historyTable");
    fullHistory.appendChild(tr);
};

function createTR(value1, value2, value3){
    let tr = document.createElement("tr");
    let itemCell = document.createElement("td");
    let itemText = document.createTextNode(value1);
    let userCell = document.createElement("td");
    let userText = document.createTextNode(value2);
    let priceCell = document.createElement("td");
    let priceText = document.createTextNode(value3);

    itemCell.appendChild(itemText);
    userCell.appendChild(userText);
    priceCell.appendChild(priceText);
    tr.appendChild(itemCell);
    tr.appendChild(userCell);
    tr.appendChild(priceCell)
    return tr;
}