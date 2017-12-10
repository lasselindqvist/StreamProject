package database.channel;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import dto.Channel;

public final class ChannelRepo {

	private ChannelRepo() {

	}

	public static Channel getChannelByName(EntityManager entityManager, String name) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Channel> query = cb.createQuery(Channel.class);
		Root<Channel> root = query.from(Channel.class);
		if (name != null) {
			query.where(cb.equal(root.get("name"), name));
		}
		try {
			Channel channel = entityManager.createQuery(query).getSingleResult();
			return channel;
		} catch (NoResultException nre) {
			return null;
		}
	}
}
