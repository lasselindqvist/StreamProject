package architecture.performables;

import org.junit.Test;

import application.websocket.WebSocketComment;
import architecture.PerformService;
import architecture.PerformableParameters;

public class C001Test {

	@Test
	public void C001Test1() {
		WebSocketComment comment = new WebSocketComment();
		comment.setChannel("channel");
		comment.setUser("username");
		comment.setContent("contents");

		C001 c001 = new C001();
		PerformableParameters parameters = new PerformableParameters();
		parameters.setParameter(C001.CHANNEL, comment.getChannel());
		parameters.setParameter(C001.USERNAME, comment.getUser());
		parameters.setParameter(C001.CONTENTS, comment.getContent());
		PerformService.perform(c001, parameters);
	}

}
