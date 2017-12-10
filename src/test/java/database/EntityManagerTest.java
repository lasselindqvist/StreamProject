package database;

import java.time.Instant;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Test;

import dto.Channel;
import dto.Comment;
import dto.User;

public class EntityManagerTest {

	@Test
	public void entityManagerTest1() {
		EntityManager em = HibernateUtil.getEntityManager();
		em.getTransaction().begin();

		User user = new User();
		user.setName("name 2");
		em.persist(user);

		Channel channel = new Channel();
		channel.setName("channel 2");
		em.persist(channel);

		Comment comment = new Comment();
		comment.setContent("contents");
		comment.setTimestamp(Instant.now());
		comment.setUser(user);
		comment.setChannel(channel);
		em.persist(comment);

		Assert.assertNotNull(user.getId());

		em.getTransaction().commit();
		em.close();
	}

	@Test
	public void entityManagerTest2() {
		EntityManager em = HibernateUtil.getEntityManager();
		em.getTransaction().begin();

		User user = new User();
		user.setName("name 1");
		em.persist(user);

		Channel channel = new Channel();
		channel.setName("channel 1");
		em.persist(channel);

		Comment comment = new Comment();
		comment.setContent("hello to you");
		comment.setTimestamp(Instant.now());
		comment.setUser(user);
		comment.setChannel(channel);
		em.persist(comment);

		Assert.assertNotNull(user.getId());

		em.getTransaction().commit();
		em.close();
	}
}
