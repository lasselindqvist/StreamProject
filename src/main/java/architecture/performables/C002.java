package architecture.performables;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;

import architecture.IPerformable;
import architecture.PerformableParameters;
import architecture.PerformableReturnValue;
import database.channel.ChannelRepo;
import database.channel.CommentRepo;
import dto.Channel;
import dto.Comment;

public class C002 implements IPerformable {

	public static final String CHANNEL = "CHANNEL";
	public static final String RETURNVALUE_MESSAGELIST = "RETURNVALUE_MESSAGELIST";

	@Override
	public PerformableReturnValue perform(EntityManager entityManager, PerformableParameters parameters) {

		String channelname = (String) parameters.getParameter(CHANNEL);

		Channel channel = ChannelRepo.getChannelByName(entityManager, channelname);
		if (channel == null) {
			channel = new Channel();
			channel.setName(channelname);
			entityManager.persist(channel);
		}

		List<Comment> commentList = CommentRepo.getLastCommentsForChannel(entityManager, 50L, channel);
		Collections.reverse(commentList);

		PerformableReturnValue returnValue = new PerformableReturnValue();
		returnValue.setReturnValue(RETURNVALUE_MESSAGELIST, commentList);

		return returnValue;
	}

}
