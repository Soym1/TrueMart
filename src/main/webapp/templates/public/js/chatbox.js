let indexCurrentFocus;
let receivername;
// window.open = function (){
//
// }

document.getElementById("chat_input").addEventListener('keydown', function(evt) {
    if (evt.keyCode == 13 && !evt.shiftKey) {
        sendMessage();
        evt.preventDefault();
    }
});
document.getElementsByClassName("bi bi-x-square")[0].addEventListener("click", closeForm);

document.getElementsByClassName("bi bi-plus-square")[0].addEventListener("click", () => {
        document.getElementById("new-chat").value = ""
        if (document.getElementById("new-chat").style.display === "none") {
            document.getElementById("new-chat").style.display = "flex";
        } else {
            document.getElementById("new-chat").style.display = "none";
            document.getElementById("list-search-name").style.display = "none"
        }
    }
)

function openForm() {
    document.getElementById("myChatBox").style.display = "block";
    document.getElementById("button-message").style.display = "none";
}

function closeForm() {
    document.getElementById("myChatBox").style.display = "none";
    document.getElementById("button-message").style.display = "block";
}

// selectChat
function selectChat(eventTarget) {
    let senderChats = document.getElementsByClassName("tag-area");
    for (let i = 0; i < senderChats.length; i++) {
        if (senderChats[i].classList.item(1) === eventTarget.classList.item(1)) {
            indexCurrentFocus = senderChats[i].classList.item(1)
            loadChatArea(senderChats[i].classList.item(1));
            senderChats[i].style.backgroundColor = "#ebedf1";
            senderChats[i].style.fontWeight = "100";
            senderChats[i].style.fontStyle = "unset";
            senderChats[i].style.color = "black";
            document.getElementById("shop-name").innerHTML = senderChats[i].textContent;
        } else {
            senderChats[i].style.backgroundColor = "white";
        }
    }
}

// function selectElement() {
document.getElementById("list-chat").addEventListener("click", (event) => {
    let eventTarget = event.target;
    while (eventTarget.parentElement.id !== "list-chat") {
        eventTarget = eventTarget.parentElement;
    }
    selectChat(eventTarget);
});

function loadChatArea(Id) {
    let http;
    let listMessage;
    http = new XMLHttpRequest();
    http.open("GET", "http://localhost:8080/chatData?userId=" + userID + "&senderId=" + Id, false);
    http.send();
    listMessage = JSON.parse(http.response);
    const element = document.getElementById("chat_messages");
    while (element.firstChild) {
        element.removeChild(element.firstChild);
    }
    listMessage.forEach(message => {
        if (parseInt(message.sender_id) === parseInt(userID)) {
            addMyMessage(message);
        } else {
            addOtherMessage(message);
        }
    })
    document.querySelector(".chat-box-body > .chat-box-footer").style.display = "flex";
    document.querySelector(".header-chat-box-body").style.display = "flex";
}

function addMyMessage(message) {
    addInfoToChat();
    span.textContent = username;
    // profile.className = "profile my-profile"
    // profile.appendChild(img);
    // profile.appendChild(span);
    para.className = "message my-message ";
    para.appendChild(document.createTextNode(message.message));
    // element.appendChild(profile);
    element.appendChild(para);
    element.scrollTop = element.scrollHeight;
}

function addOtherMessage(message) {
    addInfoToChat();
    span.textContent = document.getElementById("shop-name").textContent;
    profile.className = "profile other-profile"
    profile.appendChild(img);
    profile.appendChild(span);
    para.className = "message other-message ";
    para.appendChild(document.createTextNode(message.message));
    element.appendChild(profile);
    element.appendChild(para);
    element.scrollTop = element.scrollHeight;
}

// Xoa hung chat
function removeExistTag(Id, Name) {
    let senderChats = document.getElementsByClassName("tag-area");
    for (let i = 0; i < senderChats.length; i++) {
        let indexChat = senderChats[i].classList.item(1);
        if (parseInt(Id) === parseInt(indexChat)) {
            senderChats[i].remove();
        }
    }
    addSenderTag(Id, Name, document.getElementById("list-chat"));
}

// Them moi khung chat
function addSenderTag(Id, Name, position) {
    const para = document.createElement("div");
    const sender_user = document.createElement("div");
    const sub_img = document.createElement("div");
    const element = position;
    const img = document.createElement("img");
    const sender_name = document.createElement("div");

    para.setAttribute("class", "tag-area");
    para.classList.add(Id);
    sender_user.setAttribute("class", "tag-user");
    // sender_user.classList.add(Id);
    sender_name.setAttribute("class", "tag-name");
    sub_img.setAttribute("class", "tag-img");
    img.src = "/templates/public/img/chat/images.png";
    sub_img.append(img);
    sender_name.append(document.createTextNode(Name));
    sender_user.append(sub_img);
    sender_user.append(sender_name);
    para.append(sender_user);
    element.insertBefore(para, element.firstChild);
}

document.getElementById("search-name").addEventListener("input", (event) => {
    let listOfName = document.querySelectorAll(".tag-name");
    listOfName.forEach(Name => {
        if (!Name.innerHTML.includes(event.target.value)) {
            Name.parentElement.parentElement.style.display = "none";
        } else {
            Name.parentElement.parentElement.style.display = "block";
        }
    })
});

document.getElementById("new-chat").addEventListener("input", (event) => {
    let targetInput = document.getElementById("new-chat");
    if (targetInput.value === "") {
        document.getElementById("list-search-name").style.display = "none";
    } else {
        document.getElementById("list-search-name").style.display = "flex";
        http.open("GET", "http://localhost:8080/chatData?search=" + targetInput.value, false);
        http.send();
        let listResponse = JSON.parse(http.response);
        while (document.getElementById("list-search").firstChild) {
            document.getElementById("list-search").removeChild(document.getElementById("list-search").firstChild);
        }
        if (listResponse.listSenderById.length === 0) {
            document.getElementById("not-have-result").style.display = "block";
        } else {
            document.getElementById("not-have-result").style.display = "none";
            for (let i = 0; i < listResponse.listSenderById.length; i++) {
                addSenderTag(listResponse.listSenderById[i], listResponse.listSenderByName[i], document.getElementById("list-search"));
            }
        }
    }
});

document.getElementById("list-search-name").addEventListener("click", (event) => {
    let eventTarget = event.target;
    while (eventTarget.parentElement.id !== "list-search") {
        eventTarget = eventTarget.parentElement;
    }
    ;
    let ID_search = eventTarget.classList.item(1);
    let Name_search = eventTarget.textContent;
    let flagCheck = false;
    document.getElementById("new-chat").style.display = "none";
    document.getElementById("list-search-name").style.display = "none";
    while (document.getElementById("list-search").firstChild) {
        document.getElementById("list-search").removeChild(document.getElementById("list-search").firstChild);
    }
    document.querySelectorAll(".tag-area").forEach((event) => {
        if (event.classList.item(1) === ID_search) {
            flagCheck = true;
            event.scrollIntoView({
                behavior: 'auto',
                block: 'center',
                inline: 'center'
            });
            selectChat(eventTarget);
        }
    })
    if (!flagCheck) {
        addSenderTag(ID_search, Name_search, document.getElementById("list-chat"));
        selectChat(eventTarget);
    }

});

function addInfoToChat() {
    profile = document.createElement("div");
    span = document.createElement("span");
    para = document.createElement("div");
    element = document.getElementById("chat_messages");
    img = document.createElement("img");
    img.src = "https://images.unsplash.com/photo-1537396123722-b93d0acd8848?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=400&fit=max&ixid=eyJhcHBfaWQiOjE0NTg5fQ&s=efc6e85c24d3cfdd15cd36cb8a2471ed"
    img.style.width = "20px";
    img.style.height = "20px";
    img.style.margin = "2px 5px 2px 0";
}

///////////////////////////////////////////////////////////////////////////////////////////
//              HANDLE SOCKET
///////////////////////////////////////////////
let chat_messages;

// Create Websocket Server
const websocket = new WebSocket("ws://localhost:8080/chatRoomServer?" + username);
websocket.onopen = function () {
    processOpen();
};
websocket.onmessage = function (message) {
    processMessage(message);
};
// websocket.onclose = function (message) {
//     processClose(message);
// };
websocket.onerror = function (message) {
    processError(message);
};

function processOpen() {
    http = new XMLHttpRequest();
    http.open("GET", "http://localhost:8080/chatData?username=" + username, false);
    http.send();
    let listResponse = JSON.parse(http.response);
    for (let i = 0; i < listResponse.listSenderById.length; i++) {
        addSenderTag(listResponse.listSenderById[i], listResponse.listSenderByName[i], document.getElementById("list-chat"));
    }
}

function processError(message) {
    chat_messages.value += "Error... " + message + " \n";
}

// Gui tin nhan
function sendMessage() {
    if (typeof websocket != 'undefined' && websocket.readyState === WebSocket.OPEN && chat_input.value != "") {
        const date = new Date();
        const Str =
            date.getFullYear()
            + "-" + ("00" + (date.getMonth() + 1)).slice(-2)
            + "-" + ("00" + date.getDate()).slice(-2) + " "
            + ("00" + date.getHours()).slice(-2) + ":"
            + ("00" + date.getMinutes()).slice(-2)
            + ":" + ("00" + date.getSeconds()).slice(-2);
        websocket.send(JSON.stringify({
            sender: username, receiver: document.getElementById("shop-name").textContent, message: chat_input.value,
            submit_date: Str
        }));
        const para = document.createElement("div");
        para.className = "message my-message ";
        const data = chat_input.value + " \n";
        para.appendChild(document.createTextNode(data));
        const element = document.getElementById("chat_messages");
        element.appendChild(para);
        element.scrollTop = element.scrollHeight
        chat_input.value = "";
    }
}

// Nhan tin nhan
function processMessage(message) {
    const obj = JSON.parse(message.data);
    if (document.getElementById("shop-name").textContent === obj.sender_name) {
        addOtherMessage(obj);
        removeExistTag(obj.sender_id, obj.sender_name);
    } else {
        removeExistTag(obj.sender_id, obj.sender_name);
        document.querySelector(".tag-area").style.color = "blue";
        document.querySelector(".tag-area").style.fontStyle = "italic";
        document.querySelector(".tag-area").style.fontWeight = "bold";
    }
}