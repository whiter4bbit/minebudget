package info.whiter4bbit.ejb;

import info.whiter4bbit.model.Budget;
import info.whiter4bbit.model.Expense;
import info.whiter4bbit.model.Money;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class BudgetServiceBean implements BudgetService {

	private static final Logger LOG = Logger.getLogger(BudgetServiceBean.class.getName());
	
	@EJB
	private ExpenseDao expenseDao;
	
	@EJB
	private CurrencyService currencyService;

	@Override
	public Money calculateBalance(Budget budget) {
		List<Expense> expenses = expenseDao.find(budget.getId());
		Money budgetAmount = budget.getAmount();
		Double balance = budgetAmount.getAmount();
		int expesesCount = 0;
		for (Expense expense : expenses) {
			Money amount = expense.getAmount();
			final Double budgetCurrencyAmount
				= currencyService.convert(amount, budgetAmount.getCurrency()).getAmount();
			balance -= budgetCurrencyAmount;
			expesesCount++;
		}
		LOG.info("balance from " + budgetAmount + " is "				
				+ balance + " with " + expesesCount + " expenses");
		return new Money(balance, budgetAmount.getCurrency());
	}
}
