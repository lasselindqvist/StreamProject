package dto;

import org.junit.Test;

public class StreamTest {

	@Test
	public void testStream() {
		User user = new User();
		/*
		 * List<String> commentContents =
		 * Util.emptyIfNull(user.getCommentList()).stream() .filter(comment ->
		 * "Lobby".equals(comment.getChannel().getName())).map(comment ->
		 * comment.getContent()) .collect(Collectors.toList());
		 * Assert.assertTrue(commentContents.isEmpty());
		 */
	}
}
