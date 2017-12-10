package application.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import architecture.PerformService;
import architecture.PerformableParameters;
import architecture.PerformableReturnValue;
import architecture.performables.C002;
import dto.Comment;

@Controller
public class ChatController {

	@RequestMapping("/chat")
	public String channel(@RequestParam(value = "channel", required = false, defaultValue = "Lobby") String channel,
			@RequestParam(value = "user", required = false, defaultValue = "Anon") String user, Model model) {

		C002 c002 = new C002();
		PerformableParameters parameters = new PerformableParameters();
		parameters.setParameter(C002.CHANNEL, channel);
		PerformableReturnValue returnValue = PerformService.perform(c002, parameters);
		List<Comment> commentList = (List<Comment>) returnValue.getReturnValue(C002.RETURNVALUE_MESSAGELIST);
		List<String> messageList = commentList.stream()
				.map(comment -> comment.getUser().getName() + ": " + comment.getContent()).collect(Collectors.toList());
		model.addAttribute("messages", messageList);
		model.addAttribute("channel", channel);
		model.addAttribute("user", user);
		return "chat";
	}

}
