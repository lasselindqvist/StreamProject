package application.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import application.websocket.WebSocketComment;
import architecture.PerformService;
import architecture.PerformableParameters;
import architecture.performables.C001;

@Controller
public class WebSocketCommentController {

	@MessageMapping("/newcomment")
	@SendTo("/topic/comments")
	public WebSocketComment greeting(WebSocketComment comment) throws Exception {
		C001 c001 = new C001();
		PerformableParameters parameters = new PerformableParameters();
		parameters.setParameter(C001.CHANNEL, comment.getChannel());
		parameters.setParameter(C001.USERNAME, comment.getUser());
		parameters.setParameter(C001.CONTENTS, comment.getContent());
		PerformService.perform(c001, parameters);
		return comment;
	}

}