package info.whiter4bbit.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import javax.persistence.metamodel.SingularAttribute;

import info.whiter4bbit.model.Budget;
import info.whiter4bbit.model.Expense;

@Stateless
public class ExpenseDaoBean extends BaseDaoBean<Expense> implements ExpenseDao {
	
	private static final String BUDGET_ATTRIBUTE = "budget";
	
	private static final String BUDGET_ID_ATTRIBUTE = "id";

	@Override
	@SuppressWarnings("unchecked")
	public List<Expense> find(Long id) {
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		Metamodel metaModel = getEntityManager().getMetamodel();
		CriteriaQuery<Expense> query = cb.createQuery(Expense.class);		
		EntityType<Expense> expenseEntityType = metaModel.entity(Expense.class);
		SingularAttribute<Expense, Budget> budgetAttribute 
				= (SingularAttribute<Expense, Budget>) 
				expenseEntityType.getSingularAttribute(BUDGET_ATTRIBUTE);
		Root<Expense> expenseRoot = query.from(Expense.class);
		Path<Budget> path = expenseRoot.get(budgetAttribute);
		CriteriaQuery<Expense> expenses = query.select(expenseRoot)
			.where(cb.and(cb.equal(path.get(BUDGET_ID_ATTRIBUTE), id),
					cb.equal(expenseRoot.get("deleted"), false)));
		return getEntityManager().createQuery(expenses).getResultList();
	}
	
	@Override
	public Class<Expense> getModelClass() {
		return Expense.class;
	}
}
