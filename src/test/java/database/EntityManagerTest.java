package database;

import java.time.Instant;

import javax.persistence.EntityManager;

import org.junit.Test;

import dto.Channel;
import dto.Comment;
import dto.User;

public class EntityManagerTest {

	@Test
	public void testDatabase() {
		EntityManager em = HibernateUtil.getEntityManager();
		em.getTransaction().begin();

		User user = new User();
		user.setName("niimi");
		em.persist(user);

		Channel channel = new Channel();
		channel.setName("kanava2");
		em.persist(channel);

		Comment comment = new Comment();
		comment.setContent("sisältö");
		comment.setTimestamp(Instant.now());
		comment.setUser(user);
		comment.setChannel(channel);
		em.persist(comment);

		System.out.println("USER_ID: " + user.getId());

		em.getTransaction().commit();
		em.close();

	}
}
