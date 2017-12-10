package database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Component;

@Component
public final class HibernateUtil {

	private HibernateUtil() {

	}

	private static EntityManagerFactory entityManagerFactory;

	static {
		entityManagerFactory = Persistence.createEntityManagerFactory("h2database");
	}

	public static EntityManager getEntityManager() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}

}
