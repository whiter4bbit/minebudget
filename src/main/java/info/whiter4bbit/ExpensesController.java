package info.whiter4bbit;

import info.whiter4bbit.ejb.BudgetDao;
import info.whiter4bbit.ejb.ExpenseDao;
import info.whiter4bbit.model.Budget;
import info.whiter4bbit.model.Expense;
import info.whiter4bbit.model.Money;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import static java.lang.String.format;

@ManagedBean(name = "expensesController")
@RequestScoped
public class ExpensesController {

	private static final Logger LOG = Logger.getLogger(ExpensesController.class.getName());
	
	private Long budgetId;
	
	private Budget budget;
	
	private Expense current;
	
	@ManagedProperty("#{sessionScope}")
	private Map<String, Object> sessionMap;
	
	private List<Expense> expenses;
	
	@EJB
	private ExpenseDao expenseDao;
	
	@EJB
	private BudgetDao budgetDao;
	
	public Budget getBudget() {
		if (budget == null) {
			budget = budgetDao.get(getBudgetId());
		}
		return budget;
	}
	
	public Long getBudgetId() {
		if (budgetId == null) {			
			budgetId = (Long) sessionMap.get("_budgetId");
			LOG.info("Loading budgetId from session " + budgetId);
		}
		return budgetId;
	}
	
	public void setBudgetId(Long budgetId) {
		LOG.info("Setting budget id to " + budgetId);
		sessionMap.put("_budgetId", budgetId);
		this.budgetId = budgetId;
	}
	
	public List<Expense> getExpenses() {
		if (expenses == null) {
			expenses = expenseDao.find(budgetId);
			LOG.info(format("Loaded %d expenses for budgetId %d", expenses.size(), budgetId));
		}
		return expenses;
	}
	
	public void setExpenses(List<Expense> expenses) {
		this.expenses = expenses;
	}
	
	public Expense getCurrent() {
		if (current == null) {
			current = new Expense();			
			current.setBudget(getBudget());
			current.setAmount(new Money());
		}
		return current;
	}
	
	public void setCurrent(Expense current) {
		this.current = current;
	}
	
	public String createExpense() {
		FacesContext.getCurrentInstance()
				.getExternalContext().getFlash().setRedirect(true);
		FacesContext.getCurrentInstance()
				.addMessage(null, new FacesMessage("New expense was successful created"));
		FacesContext.getCurrentInstance().getExternalContext()
				.getFlash().setKeepMessages(true);
		expenseDao.save(current);
		return "expenseslist?faces-redirect=true&amp;includeViewParams=true";		
	}
	
	public void setSessionMap(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
	
}
