package info.whiter4bbit.ejb;

import java.util.List;

import info.whiter4bbit.model.Budget;

import javax.ejb.Remote;

@Remote
public interface BudgetDao extends BaseDao<Budget> {
	List<Budget> getBudgets();
	Budget getLastBudget();
}
