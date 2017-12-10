package architecture;

import javax.persistence.EntityManager;

public interface IPerformable {

	public PerformableReturnValue perform(EntityManager em, PerformableParameters parameters);

}
