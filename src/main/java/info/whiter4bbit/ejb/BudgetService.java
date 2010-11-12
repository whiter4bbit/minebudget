package info.whiter4bbit.ejb;

import info.whiter4bbit.model.Budget;
import info.whiter4bbit.model.Money;

import javax.ejb.Remote;

@Remote
public interface BudgetService {
	Money calculateBalance(Budget budget);
}
