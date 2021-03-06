var websocket = null;
var username = localStorage.getItem("name");
//判断当前浏览器是否支持WebSocket
//连接发生错误的回调方法
/*websocket.onerror = function () {
    setMessageInnerHTML("WebSocket连接发生错误");
};
//连接成功建立的回调方法
websocket.onopen = function () {
    setMessageInnerHTML("WebSocket连接成功");
};
//接收到消息的回调方法
websocket.onmessage = function (event) {
    setMessageInnerHTML(event.data);
};
//连接关闭的回调方法
websocket.onclose = function () {
    setMessageInnerHTML("WebSocket连接关闭");
};*/
//监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
window.onbeforeunload = function () {
    closeWebSocket();
};

//关闭WebSocket连接
function closeWebSocket() {
    websocket.close();
}

function setMessageInnerHTML(msg) {
    alert(msg);
}

function sendMsg() {
    var username = "xiayu";
    var msg = "hello server";
    if ('WebSocket' in window) {
        websocket = new WebSocket("ws://localhost:9999" + "/websocket/" + username + "/" + msg);
    } else {
        alert('当前浏览器 Not support websocket')
    }
}

$(function () {
    chat.init();
});
var chat = {
    init: function () {
        $("#chat").click(function () {
            console.log("hello");
            sendMsg();
        });
    }
};