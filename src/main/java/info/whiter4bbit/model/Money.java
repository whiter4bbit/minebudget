package info.whiter4bbit.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Money implements Serializable {

	private static final long serialVersionUID = 1699786508595096855L;

	private Double amount;
	
	private Currency currency;

	public Money() {
		
	}
	
	public Money(Double amount, Currency currency) {
		this.amount = amount;
		this.currency = currency;
	}
	
	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	
}
