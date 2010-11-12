package info.whiter4bbit;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import info.whiter4bbit.ejb.BudgetDao;
import info.whiter4bbit.ejb.BudgetService;
import info.whiter4bbit.model.Budget;
import info.whiter4bbit.model.Money;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import static java.lang.String.format;

@ManagedBean(name = "budgetController")
@RequestScoped
public class BudgetController {

	private static final Logger LOG = Logger.getLogger(BudgetController.class.getName());

	@EJB
	private BudgetDao budgetDao;

	@EJB
	private BudgetService budgetService;

	private List<BudgetDto> budgets;

	private Budget current;
	
	private Long selectedBudgetId;

	private BudgetDto transform(Budget budget) {
		BudgetDto dto = new BudgetDto();
		dto.setId(budget.getId());
		dto.setName(budget.getName());
		dto.setAmount(budget.getAmount());
		dto.setCurrentAmount(budgetService.calculateBalance(budget));
		dto.setCreated(budget.getCreated());
		return dto;
	}
	
	public List<BudgetDto> getBudgets() {
		List<Budget> budgetEntities = budgetDao.getBudgets();
		budgets = new ArrayList<BudgetDto>();
		for (Budget budget : budgetEntities) {
			budgets.add(transform(budget));
		}
		return budgets;
	}

	public Budget getCurrent() {
		if (current == null) {
			LOG.info(format("Creating budget for %s phase",
					FacesContext.getCurrentInstance().getCurrentPhaseId()));
			current = new Budget();
			current.setAmount(new Money());
		}
		return current;
	}
	
	public void setSelectedBudgetId(Long selectedBudgetId) {
		this.selectedBudgetId = selectedBudgetId;
	}
	
	public Long getSelectedBudgetId() {
		return selectedBudgetId;
	}

	public void setCurrent(Budget budget) {
		this.current = budget;
	}
	
	private BudgetDto selectedBudget;
	
	public BudgetDto getSelectedBudget() {
		if (selectedBudget == null) {
			Budget budget = budgetDao.get(selectedBudgetId);
			selectedBudget = transform(budget);
		}
		return selectedBudget;
	}
	
	public void delete() {
		Budget budget = budgetDao.get(selectedBudgetId);
		budgetDao.delete(budget);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(format("Budget '%s' was successful removed", budget.getName())));
	}
	
	public String doCreate() {
		budgetDao.save(current);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(format("Budget '%s' was successful created", current.getName())));
		FacesContext.getCurrentInstance().getExternalContext().getFlash()
				.setKeepMessages(true);
		FacesContext.getCurrentInstance()
				.getExternalContext().getFlash().put("test", "test");		
		LOG.info(format("Created budget %s", current));
		return "index?faces-redirect=true";
	}
}
