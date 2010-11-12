package info.whiter4bbit.ejb;

import java.util.List;

import info.whiter4bbit.model.Budget;

import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Stateless
public class BudgetDaoBean extends BaseDaoBean<Budget> implements BudgetDao {
	
	@Override
	public List<Budget> getBudgets() {
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Budget> query = 
			cb.createQuery(Budget.class);
		Root<Budget> from = query.from(Budget.class);
		CriteriaQuery<Budget> select = query.select(from)
			.where(cb.equal(from.get("deleted"), false));
		return getEntityManager().createQuery(select).getResultList();
	}
	
	@Override
	public Budget getLastBudget() {
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Budget> budgetQuery = cb.createQuery(Budget.class);
		budgetQuery.select(budgetQuery.from(Budget.class));
		return null;
	}
	
	@Override
	public Class<Budget> getModelClass() {
		return Budget.class;
	}
	
}
