package sopra.formation.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.transaction.annotation.Transactional;

public class IPersonneRepositoryCustomImpl implements IPersonneCustomRepository {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional(readOnly = true)
	public <T> List<T> findAll(Class<T> clazz) {
		TypedQuery<T> query = em.createQuery("from " + clazz.getSimpleName(), clazz);

		return query.getResultList();
	}
}
