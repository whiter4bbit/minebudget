package info.whiter4bbit;

import info.whiter4bbit.model.Money;

import java.util.Date;

public class BudgetDto {	
	private Long id;
	private String name;
	private Money amount;
	private Money currentAmount;
	private Date created;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Money getAmount() {
		return amount;
	}
	public void setAmount(Money amount) {
		this.amount = amount;
	}
	public Money getCurrentAmount() {
		return currentAmount;
	}
	public void setCurrentAmount(Money currentAmount) {
		this.currentAmount = currentAmount;
	}
	
	public Date getCreated() {
		return created;
	}
	
	public void setCreated(Date created) {
		this.created = created;
	}
}
