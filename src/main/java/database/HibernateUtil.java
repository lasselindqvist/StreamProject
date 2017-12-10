package database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public final class HibernateUtil {

	private HibernateUtil() {

	}

	private static EntityManagerFactory entityManagerFactory;

	private static SessionFactory sessionFactory;

	static {
		// entityManagerFactory =
		// Persistence.createEntityManagerFactory("persistence.xml");
		// sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
		// sessionFactory = new
		// Configuration().configure().buildSessionFactory();
		entityManagerFactory = Persistence.createEntityManagerFactory("h2database");
	}

	public static EntityManager getEntityManager() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}

	public static Session getSession() {
		return sessionFactory.openSession();
	}

	@Autowired
	public HibernateUtil(EntityManagerFactory factory) {
		if (factory.unwrap(SessionFactory.class) == null) {
			throw new NullPointerException("factory is not a hibernate factory");
		}
		sessionFactory = factory.unwrap(SessionFactory.class);
	}

}
