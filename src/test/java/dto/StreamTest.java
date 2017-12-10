package dto;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

import util.Util;

public class StreamTest {

	@Test
	public void emptyTest() {
		User user = new User();

		List<String> commentContents = Util.emptyIfNull(user.getCommentList()).stream()
				.filter(comment -> "Lobby".equals(comment.getChannel().getName())).map(comment -> comment.getContent())
				.collect(Collectors.toList());
		Assert.assertTrue(commentContents.isEmpty());

	}
}
