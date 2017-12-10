var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect() {
    var socket = new SockJS('/gs-guide-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/comments', function (comment) {
        	showMessage(JSON.parse(comment.body).channel, JSON.parse(comment.body).user, JSON.parse(comment.body).content);
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendComment() {
    stompClient.send("/app/newcomment", {}, JSON.stringify({'channel': $("#channel").val(), 'content': $("#content").val(), 'user': $("#user").val()}));
    $('#content').val('');
    $('#content').focus();
}

function showMessage(channel, user, content) {
	if ($("#channel").val() == channel) {
		$("#messages").append("<tr><td>" + user + ": " + content + "</td></tr>");
	}
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendComment(); });
});

window.onload = function() {
	connect();
};

