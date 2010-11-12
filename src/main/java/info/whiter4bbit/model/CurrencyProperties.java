package info.whiter4bbit.model;

public class CurrencyProperties {
	
	private Currency currency;
	
	private Double toUSD;
	
	private Double fromUSD;

	public Currency getCurrency() {
		return currency;
	}
	
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	
	public Double getToUSD() {
		return toUSD;
	}

	public void setToUSD(Double toUSD) {
		this.toUSD = toUSD;
	}

	public Double getFromUSD() {
		return fromUSD;
	}

	public void setFromUSD(Double fromUSD) {
		this.fromUSD = fromUSD;
	}
	
}
