let indexCurrentFocus
let imgCurrentFocus;
let shopNameCurrentFocus;
let indexLoadChat = 0;
let maxAmountChatRecords = 0;
let receivername;
let username = $(".user a span").attr("class");
let userID = $(".user a").attr("class");
// window.open = function (){
//


document.getElementById("chat_input_text").addEventListener('keydown', function (evt) {
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
            indexCurrentFocus = senderChats[i].classList.item(1);
            imgCurrentFocus = senderChats[i].querySelector(".tag-img img").src;
            shopNameCurrentFocus = senderChats[i].querySelector(".tag-name .tag-shopname").textContent;
            indexLoadChat = 0;
            maxAmountChatRecords = 0;
            loadChatArea(senderChats[i].classList.item(1));
            senderChats[i].style.backgroundColor = "#ebedf1";
            senderChats[i].style.fontWeight = "100";
            senderChats[i].style.fontStyle = "unset";
            senderChats[i].style.color = "black";
            document.getElementById("shop-name").innerHTML = senderChats[i].querySelector(".tag-shopname").textContent;
            var objDiv = document.getElementById("chat_messages");
            window.requestAnimationFrame(function () {
                objDiv.scrollTop = objDiv.scrollHeight;
            });
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
    const element = document.getElementById("chat_messages");
    while (element.firstChild) {
        element.removeChild(element.firstChild);
    }
    let http;
    let listMessage;
    let URL;
    http = new XMLHttpRequest();

    if (maxAmountChatRecords === 0) {
        URL = "http://localhost:8080/chatData?userId=" + Id + "&maxAmountChatRecords=" + maxAmountChatRecords;
        http.open("GET", URL, false);
        http.send();
        maxAmountChatRecords = parseInt(http.response);
    }
    URL = "http://localhost:8080/chatData?userId=" + Id + "&indexLoadChat=" + indexLoadChat;
    http.open("GET", URL, false);
    http.send();
    listMessage = JSON.parse(http.response);

    listMessage.reverse();
    listMessage.forEach(message => {
        if (parseInt(message.sender_id) === parseInt(userID)) {
            addMyMessage(message);
        } else {
            addOtherMessage(message);
        }
    })
    document.querySelector(".chat-box-body > .chat-box-footer").style.display = "flex";
    document.querySelector(".header-chat-box-body").style.display = "flex";
    document.querySelector(".sub-chat-btn").style.display = "flex";
    document.getElementById("chat_input_text").value = "";
    document.querySelector(".chat-box-file-upload").innerHTML = "";
    list_file = [];
}

// Check scroll top
document.getElementById("chat_messages").addEventListener("scroll", function () {
    if (this.scrollTop == 0) {
        let lastScroll = this.scrollHeight;
        indexLoadChat += 1;
        if (indexLoadChat * 12 <= maxAmountChatRecords) {
            loadChatArea(indexCurrentFocus);
        }
        this.scrollTop = this.scrollHeight - lastScroll;
    }
})

function addMyMessage(message) {
    para = document.createElement("div");
    element = document.getElementById("chat_messages");
    para.className = "message my-message ";
    const paraImg = document.createElement("div");
    paraImg.className = "message my-img-message ";
    if (message.type_mess === "text") {
        const regex = /(https?:\/\/[^\s]+)/g;
        message.messages = message.messages.replace(regex, '<a href="$1">$1</a>');
        para.appendChild(document.createTextNode(message.messages));
        element.appendChild(para);
    } else if (message.type_mess.split("/")[0] === "data:image") {
        let img = new Image();
        img.src = message.type_mess + "," + message.messages;
        img.alt = message.name_mess;
        paraImg.append(img)
        element.appendChild(paraImg);
    } else {
        let link = document.createElement("a");
        link.href = message.type_mess + "," + message.messages;
        link.text = message.name_mess;
        link.download;
        para.appendChild(link);
        element.appendChild(para);
    }
}

function addOtherMessage(message) {
    let element = document.getElementById("chat_messages");
    let profile;
    let span;
    if ((element.lastChild === null) || (element.lastChild.classList[1] === "my-message")) {
        profile = document.createElement("div");
        span = document.createElement("span");
        span.textContent = shopNameCurrentFocus;
        span.style.color = "black"
        const img = new Image();
        img.src = imgCurrentFocus;
        img.style.width = "20px";
        img.style.height = "20px";
        img.style.margin = "2px 5px 2px 0";
        profile.className = "profile other-profile"
        profile.appendChild(img);
        profile.appendChild(span);
        element.appendChild(profile);
    }
    ;

    let para = document.createElement("div");
    para.className = "message other-message ";
    const paraImg = document.createElement("div");
    paraImg.className = "message other-img-message";
    if (message.type_mess === "text") {
        const regex = /(https?:\/\/[^\s]+)/g;
        message.messages = message.messages.replace(regex, '<a href="$1">$1</a>');
        para.appendChild(document.createTextNode(message.messages));
        element.appendChild(para);
    } else if (message.type_mess.split("/")[0] === "data:image") {
        let img = new Image();
        img.src = message.type_mess + "," + message.messages;
        img.alt = message.name_mess;
        paraImg.append(img)
        element.appendChild(paraImg);
    } else {
        let link = document.createElement("a");
        link.href = message.type_mess + "," + message.messages;
        link.text = message.name_mess;
        link.download;
        para.appendChild(link);
        element.appendChild(para);
    }
}

// Xoa hung chat
function removeExistTag(ID, userName, name, shopname) {
    let senderChats = document.getElementsByClassName("tag-area");
    for (let i = 0; i < senderChats.length; i++) {
        let indexChat = senderChats[i].classList.item(1);
        if (parseInt(Id) === parseInt(indexChat)) {
            senderChats[i].remove();
        }
    }
    addSenderTag(ID, userName, name, shopname, document.getElementById("list-chat"));
}

// Them moi khung chat
function addSenderTag(ID, username, name, shopname, position) {
    const para = document.createElement("div");
    const sender_user = document.createElement("div");
    const sub_img = document.createElement("div");
    const element = position;
    const sender_tagname = document.createElement("div");
    const sender_shopname = document.createElement("div");
    const sender_username = document.createElement("div");
    para.setAttribute("class", "tag-area");
    para.classList.add(ID);
    sender_user.setAttribute("class", "tag-user");
    sender_tagname.setAttribute("class", "tag-name");
    sender_shopname.setAttribute("class", "tag-shopname");
    sender_username.setAttribute("class", "tag-username");
    sub_img.setAttribute("class", "tag-img");
    const img = new Image();
    img.onerror = function () {
        img.src = "/templates/public/img/chat/images.png";
    };
    img.src = "/templates/public/img/shop/" + ID + ".jpg";
    sub_img.append(img);
    if (shopname !== "") {
        sender_shopname.append(document.createTextNode(shopname));
    } else {
        sender_shopname.append(document.createTextNode(name));
    }
    sender_username.append(document.createTextNode(username));
    sender_tagname.append(sender_shopname);
    sender_tagname.append(sender_username);
    sender_user.append(sub_img);
    sender_user.append(sender_tagname);
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
        if (listResponse.listID.length === 0) {
            document.getElementById("not-have-result").style.display = "block";
        } else {
            document.getElementById("not-have-result").style.display = "none";
            for (let i = 0; i < listResponse.listID.length; i++) {
                addSenderTag(listResponse.listID[i], listResponse.listUserName[i], listResponse.listName[i], listResponse.listShopName[i], document.getElementById("list-search"));
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
    let ShopName_search = eventTarget.querySelector(".tag-shopname").textContent;
    let UserName_search = eventTarget.querySelector(".tag-username").textContent;
    console.log("list-search-name: ", eventTarget);
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
        addSenderTag(ID_search, UserName_search, ShopName_search, ShopName_search, document.getElementById("list-chat"));
        selectChat(eventTarget);
    }
    document.getElementById("list-search").innerHTML = "";
});


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
    for (let i = 0; i < listResponse.listID.length; i++) {
        addSenderTag(listResponse.listID[i], listResponse.listUserName[i], listResponse.listName[i], listResponse.listShopName[i], document.getElementById("list-chat"));
    }
}


function isLink(text) {
    var regex = /(ftp|http|https):\/\/(\w+:{0,1}\w*@)?(\S+)(:[0-9]+)?(\/|\/([\w#!:.?+=&%@!\-\/]))?/;
    return regex.test(text);
}

// Gui tin nhan
async function sendMessage() {
    if (typeof websocket != 'undefined' && websocket.readyState === WebSocket.OPEN) {
        const date = new Date();
        let chat_input = document.getElementById("chat_input_text");
        let message_data = [];
        if (chat_input.value !== "") {
            message_data.push({type_mess: "text", name_mess: "", messages: chat_input.value});
        }

        for (let i = 0; i < list_file.length; i++) {
            var file = list_file[i].message.split(",");
            message_data.push({type_mess: file[0], name_mess: list_file[i].name, messages: file[1]});
        }

        let Str =
            date.getFullYear()
            + "-" + ("00" + (date.getMonth() + 1)).slice(-2)
            + "-" + ("00" + date.getDate()).slice(-2) + " "
            + ("00" + date.getHours()).slice(-2) + ":"
            + ("00" + date.getMinutes()).slice(-2)
            + ":" + ("00" + date.getSeconds()).slice(-2);

        websocket.send(JSON.stringify({
            username: username,
            receiver: indexCurrentFocus,
            data: message_data,
            date_send: Str
        }));
        //Khoi tao tin nhan moi
        message_data.forEach(ele => {
            addMyMessage(ele);
        })
        document.querySelector(".chat-box-file-upload").innerHTML = "";
        list_file = [];
        chat_input.value = "";
        element.scrollTop = element.scrollHeight;
    }
}


// Them moi upload
let list_file = []
document.getElementById("attach-btn").addEventListener("input", async () => {
    let data_file = await handleFileUpload();
    list_file = await Promise.all(data_file);

    document.querySelector(".chat-box-file-upload").innerHTML = "";
    for (let i = 0; i < list_file.length; i++) {
        let img = new Image();
        img.src = list_file[i].message;
        if (img.src.split("/")[0] === "data:image") {
            $(".chat-box-file-upload").append(' <div class="file-upload-area ' + i + '">' +
                '<div class="upload">\n' +
                '                            <img alt="' + list_file[i].name + '" src="' + list_file[i].message + '">\n' +
                '                            </div>' +
                '<div class="delete">\n' +
                '                                <i class="fa fa-times" aria-hidden="true"></i>\n' +
                '                            </div>\n' +
                '                        </div>')
        } else {
            $(".chat-box-file-upload").append('<div class="file-upload-area  ' + i + '">\n' +
                '                                    <div class="file-upload">\n' +
                '                                        <div class="file-upload-icon">\n' +
                '                                            <i class="fa fa-file-text-o" aria-hidden="true"></i>\n' +
                '                                        </div>\n' +
                '                                        <div class="file-upload-name">\n' +
                '                                            <span>' + list_file[i].name + '</span>\n' +
                '                                        </div>\n' +
                '                                    </div>\n' +
                '                                    <div class="delete">\n' +
                '                                        <i class="fa fa-times" aria-hidden="true"></i>\n' +
                '                                    </div>\n' +
                '                                </div>')
        }
    }
});
// Delete upload
document.querySelector(".chat-box-file-upload").addEventListener("click", function (event) {
    let target = event.target;
    if (target.classList.contains("delete") || target.classList.contains("fa-times")) {
        let divParent = target.closest(".file-upload-area");
        let delete_img = divParent.classList[1];
        list_file.splice(parseInt(delete_img), 1);
        divParent.remove();

    }
});

function toBase64(file) {
    var reader = new FileReader();
    reader.readAsDataURL(file);
    return new Promise((resolve, reject) => {
        reader.onload = function () {
            resolve(reader.result);
        };
        reader.onerror = function (error) {
            reject(error);
        };
    });
}

async function handleFileUpload() {
    let data_file = list_file;
    var files = $("#attach-btn")[0].files;
    for (let i = 0; i < files.length; i++) {
        await toBase64(files[i]).then((result) => {
            data_file.push({name: files[i].name, message: result});
        })
    }
    document.getElementById("attach-btn").value = "";
    return data_file;
}

// Nhan tin nhan
function processMessage(message) {
    const obj = JSON.parse(message.data);
    if (parseInt(indexCurrentFocus) === obj.sender_id) {
        obj.data.forEach(ele => {
            addOtherMessage(ele);
        })
        removeExistTag(obj.sender_id, obj.sender_username, obj.sender_name, obj.sender_shop_name);
    } else {
        removeExistTag(obj.sender_id, obj.sender_username, obj.sender_name, obj.sender_shop_name);
        document.querySelector(".tag-area").style.color = "blue";
        document.querySelector(".tag-area").style.fontStyle = "italic";
        document.querySelector(".tag-area").style.fontWeight = "bold";
    }
}

// Modal

function closeModal() {
    document.getElementById("myModal").style.display = "none";
    document.querySelector(".modal-content-chat").innerHTML = "";
    document.getElementsByTagName("body")[0].style.overflow = "auto"
}
document.getElementById("chat_messages").addEventListener("click",function (event){
    if (event.target.tagName === "IMG"){
        document.getElementsByTagName("body")[0].style.overflow = "hidden"
        let length = document.getElementById("chat_messages").querySelectorAll("img").length;
        let eventSrc = event.target.src;
        let indexCurrentSlice = 0;
        $(".modal-content-chat").append('            <span class="close cursor" onclick="closeModal()">&times;</span>\n');
        document.getElementById("myModal").style.display = "block";
        document.getElementById("chat_messages").querySelectorAll("img").forEach((event, index) => {
            if (eventSrc === event.src){
                indexCurrentSlice = index + 1;
            }
            $(".modal-content-chat").append('            <div class="mySlides">\n' +
                '                <div class="numbertext">' + (index + 1) + ' / ' + length + '</div>\n' +
                '                <img src="' + event.src + '" >\n' +
                '            </div>');
        })
        $(".modal-content-chat").append(' <a class="prev" onclick="plusSlides(-1)">&#10094;</a>\n' +
            '            <a class="next" onclick="plusSlides(1)">&#10095;</a>');
        $(".modal-content-chat").append("<div class='tiny-slice-area'></div>")
        $(".tiny-slice-area").append("<div class='tiny-slice'></div>");
        document.getElementById("chat_messages").querySelectorAll("img").forEach((event, index) => {
            $(".tiny-slice").append('            <div class="column">\n' +
                '                <img class="demo cursor" src="'+event.src+'" style="width:100%; height:100%" onclick="currentSlide('+(index+1)+')" alt="Nature and sunrise">\n' +
                '            </div>');
        })
        currentSlide(indexCurrentSlice);
    }
})

var slideIndex = 1;

function plusSlides(n) {
    showSlides(slideIndex += n);
}

function currentSlide(n) {
    showSlides(slideIndex = n);
}

function showSlides(n) {
    var i;
    var slides = document.getElementsByClassName("mySlides");
    var dots = document.getElementsByClassName("demo");
    if (n > slides.length) {slideIndex = 1}
    if (n < 1) {slideIndex = slides.length}
    for (i = 0; i < slides.length; i++) {
        slides[i].style.display = "none";
    }
    for (i = 0; i < dots.length; i++) {
        dots[i].className = dots[i].className.replace(" active", "");
    }
    slides[slideIndex-1].style.display = "block";
    dots[slideIndex-1].className += " active";
    document.getElementById("myModal").style.backgroundImage = "linear-gradient(to top, rgba(0,0,0,0) 0%,rgba(0,0,0,1) 100%), url(" + slides[slideIndex-1].children[1].src + ")";

}