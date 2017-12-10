package database.channel;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import dto.Channel;
import dto.Comment;

public class CommentRepo {

	public static List<Comment> getLastCommentsForChannel(EntityManager entityManager, Long max, Channel channel) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Comment> query = cb.createQuery(Comment.class);
		Root<Comment> root = query.from(Comment.class);
		if (channel != null) {
			query.where(cb.equal(root.get("channel"), channel));
		}

		query.orderBy(cb.desc(root.get("timestamp")));

		return entityManager.createQuery(query).setMaxResults(max.intValue()).getResultList();
	}
}
