package architecture;

import javax.persistence.EntityManager;

import database.HibernateUtil;

public class PerformService {

	public static PerformableReturnValue perform(IPerformable performable, PerformableParameters parameters) {
		EntityManager em = HibernateUtil.getEntityManager();

		try {
			em = HibernateUtil.getEntityManager();
			em.getTransaction().begin();

			PerformableReturnValue returnValue = performable.perform(em, parameters);

			em.getTransaction().commit();

			return returnValue;
		} catch (Exception e) {
			if (em.getTransaction() != null) {
				em.getTransaction().rollback();
			}
			throw new RuntimeException(e);
		} finally {
			if (em != null) {
				em.close();
			}

		}
	}

}
