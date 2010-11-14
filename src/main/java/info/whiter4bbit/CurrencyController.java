package info.whiter4bbit;

import java.util.logging.Logger;

import info.whiter4bbit.ejb.CurrencyService;
import info.whiter4bbit.model.Currency;
import info.whiter4bbit.model.Money;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIInput;
import javax.faces.component.UISelectOne;
import javax.faces.event.ValueChangeEvent;

@ManagedBean(name = "currencyController")
@RequestScoped
public class CurrencyController {
	
	private static final Logger LOG = Logger.getLogger(CurrencyController.class.getName());

	private UIInput amountInput;
	
	private UISelectOne currencySelect;
	
	private Money usdValue;
	
	public CurrencyController() {
		LOG.info("instance was created");
	}
	
	@EJB
	private CurrencyService currencyService;

	public Money getUsdValue() {
		return usdValue;
	}
	
	public void setUsdValue(Money usdValue) {
		this.usdValue = usdValue;
	}
	
	public UIInput getAmountInput() {
		return amountInput;
	}

	public void setAmountInput(UIInput amountInput) {
		this.amountInput = amountInput;
	}

	public UISelectOne getCurrencySelect() {
		return currencySelect;
	}

	public void setCurrencySelect(UISelectOne currencySelect) {
		this.currencySelect = currencySelect;
	}

	private void updateUSDValue(Double amount, Currency currency) {
		if (currency!=null && amount != null) {
			Double value = currencyService.convert(currency, Currency.USD, amount);
			this.usdValue = new Money(value, Currency.USD);
		}
	}
	
	public void amountChanged(ValueChangeEvent event) {
		Currency currency = (Currency) getCurrencySelect().getValue();
		Double amount = (Double) event.getNewValue();
		updateUSDValue(amount, currency);
		LOG.info("Amount changed to " + event.getNewValue() + " currency value = " + currency);
	}
	
	public void currencyChanged(ValueChangeEvent event) {		
		Currency currency = (Currency) event.getNewValue();
		Double amount = (Double) amountInput.getValue();
		updateUSDValue(amount, currency);
		LOG.info("Currency changed to " + event.getNewValue() + " amount value = " + amount);
	}
	
}
