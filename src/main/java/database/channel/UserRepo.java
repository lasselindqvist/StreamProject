package database.channel;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import dto.User;

public final class UserRepo {

	private UserRepo() {

	}

	public static User getUserByName(EntityManager entityManager, String name) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<User> query = cb.createQuery(User.class);
		Root<User> root = query.from(User.class);
		if (name != null) {
			query.where(cb.equal(root.get("name"), name));
		}
		try {
			User user = entityManager.createQuery(query).getSingleResult();
			return user;
		} catch (NoResultException nre) {
			return null;
		}
	}
}
