<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <link href="/templates/public/CSS/chatbox.css" rel="stylesheet" type="text/css">
</head>
<style>

</style>
<body>
<div>
    <script>
        let username = "${username}";
        let userID = "${userId}";
    </script>
    <!-- Chatbox bubble -->
    <div class="chat-popup" id="myForm">
        <button id="button-message" type="button" class="btn popup" onclick="openForm()"><img class="logo-popup"
                                                                                              src="/templates/public/img/chat/messenger-logo.svg">
        </button>
        </form>
    </div>
    <!-- Chatbox bubble -->
    <!-- Main chatbox -->
    <div class="" id="myChatBox">
        <!-- Chat-box-header -->
        <div class="chat-box">
            <div class="chat-box-header">
                <div class="" style="width: 68px;">
                    <span style="font-weight: bolder;">TrueMart</span>
                </div>
                <div class="header-btn" style="width: 200px;">
                    <div id="input-new-chat">
                        <input id="new-chat" placeholder="Enter name" autocomplete="off">
                        <div id="list-search-name">
                            <div id="not-have-result">Find not thing</div>
                            <div id="list-search">
                            </div>
                        </div>
                    </div>
                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor"
                         class="bi bi-plus-square" viewBox="0 0 16 16" style="opacity: 0.6;">
                        <path d="M14 1a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1H2a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h12zM2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2z"/>
                        <path d="M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4z"/>
                    </svg>
                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor"
                         class="bi bi-x-square" viewBox="0 0 16 16" style="opacity: 0.6;">
                        <path d="M14 1a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1H2a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h12zM2 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H2z"/>
                        <path d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708z"/>
                    </svg>

                </div>
                <!-- <h3>Some Chat Room<br /><small>Last active: 0 min ago</small></h3> -->
            </div>
            <!-- chat-box-body -->
            <div class="chat-body" style="display: flex; height: 100%; width: 100%; font-size: 14px ">
                <div id="chat_box_body" class="chat-box-body">
                    <div class="header-chat-box-body" style="height: 32px; border-bottom: solid 1px #cfcfcf;">
                        <div id="shop-name"></div>
                    </div>
                    <%--            Chat area--%>
                    <div id="chat_messages" style="overflow: auto;overflow-x: hidden;">
                        <span class="span-welcome">Hello,</span>
                        <span class="span-welcome">Welcome to TrueMart!</span>
                    </div>
                    <div id="typing">
                        <div><span></span> <span></span> <span></span> <span class="n">Someone</span> is typing...</div>
                    </div>
                    <div class="chat-box-footer">
                        <textarea id="chat_input" placeholder="Enter your message here..."></textarea>
                        <button id="send" onclick="sendMessage()" value="Send Message">
                            <svg style="width:24px;height:24px" viewBox="0 0 24 24">
                                <path fill="#006ae3" d="M2,21L23,12L2,3V10L17,12L2,14V21Z"/>
                            </svg>
                        </button>
                    </div>
                </div>
                <div class="right-area">
                    <div class="search-bar">
                        <div class="search-bar-input">
                            <input id="search-name" name="search-name" placeholder="Search by name">
                            <div class="search-icon">
                                <svg xmlns="http://www.w3.org/2000/svg" width="30" height="24" viewBox="0 0 60 60"
                                     style="padding: 2.5px 0 0 0px;">
                                    <path d="M 21 3 C 11.621094 3 4 10.621094 4 20 C 4 29.378906 11.621094 37 21 37 C 24.710938 37 28.140625 35.804688 30.9375 33.78125 L 44.09375 46.90625 L 46.90625 44.09375 L 33.90625 31.0625 C 36.460938 28.085938 38 24.222656 38 20 C 38 10.621094 30.378906 3 21 3 Z M 21 5 C 29.296875 5 36 11.703125 36 20 C 36 28.296875 29.296875 35 21 35 C 12.703125 35 6 28.296875 6 20 C 6 11.703125 12.703125 5 21 5 Z"></path>
                                </svg>
                            </div>
                        </div>
                    </div>
                    <div id="list-chat">
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
<%--<script src="/view/chat-box.js"></script>--%>
<script src="/templates/public/js/chatbox.js"></script>
<script src="/templates/public/js/handlesocket.js"></script>
</body>
</html>