package info.whiter4bbit.ejb;

import info.whiter4bbit.model.BaseModel;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public abstract class BaseDaoBean<T extends BaseModel> implements BaseDao<T> {
	@PersistenceContext
	private EntityManager entityManager;
	
	public abstract Class<T> getModelClass();
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	@Override
	public T get(Serializable id) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> query 
			= cb.createQuery(getModelClass());
		Root<T> from = query.from(getModelClass());
		CriteriaQuery<T> select = query.select(from)
			.where(cb.equal(from.get("id"), id));
		List<T> list = entityManager.createQuery(select).getResultList();
		if (list.size() > 0) {
			return list.get(0);
		} else {
			throw new IllegalStateException("No records found");
		}
	}
	
	@Override
	public T save(T instance) {
		instance.setDeleted(false);
		instance.setCreated(new Date());
		getEntityManager().persist(instance);
		return instance;
	}
	
	@Override
	public void delete(T instance) {
		instance.setDeleted(true);
		getEntityManager().merge(instance);
	}
}
