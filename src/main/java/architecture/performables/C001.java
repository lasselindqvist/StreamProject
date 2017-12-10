package architecture.performables;

import java.time.Instant;

import javax.persistence.EntityManager;

import architecture.IPerformable;
import architecture.PerformableParameters;
import architecture.PerformableReturnValue;
import database.channel.ChannelRepo;
import database.channel.UserRepo;
import dto.Channel;
import dto.Comment;
import dto.User;

public class C001 implements IPerformable {

	public static final String USERNAME = "USERNAME";
	public static final String CHANNEL = "CHANNEL";
	public static final String CONTENTS = "CONTENTS";

	@Override
	public PerformableReturnValue perform(EntityManager entityManager, PerformableParameters parameters) {

		String username = (String) parameters.getParameter(USERNAME);
		String channelname = (String) parameters.getParameter(CHANNEL);
		String contents = (String) parameters.getParameter(CONTENTS);

		User user = UserRepo.getUserByName(entityManager, username);
		if (user == null) {
			user = new User();
			user.setName(username);
			entityManager.persist(user);
		}

		Channel channel = ChannelRepo.getChannelByName(entityManager, channelname);
		if (channel == null) {
			channel = new Channel();
			channel.setName(channelname);
			entityManager.persist(channel);
		}

		Comment comment = new Comment();
		comment.setTimestamp(Instant.now());
		comment.setContent(contents);
		comment.setUser(user);
		comment.setChannel(channel);
		entityManager.persist(comment);

		return new PerformableReturnValue();
	}

}
