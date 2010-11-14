package info.whiter4bbit;

import info.whiter4bbit.ejb.CurrencyService;
import info.whiter4bbit.model.Currency;
import info.whiter4bbit.model.Money;

import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIInput;
import javax.faces.component.UIOutput;
import javax.faces.component.UISelectOne;
import javax.faces.event.ValueChangeEvent;

@ManagedBean(name = "currencyListener")
@ApplicationScoped
public class CurrencyListener {
	
	private static final Logger LOG = Logger.getLogger(CurrencyListener.class.getName());
	
	@EJB
	private CurrencyService currencyService;
	
	private void updateUSDValue(UIOutput output, Double amount, Currency currency) {
		if (currency!=null && amount != null) {
			Double value = currencyService.convert(currency, Currency.USD, amount);
			Money usdValue = new Money(value, Currency.USD);
			output.setValue(usdValue);
		}
	}
	
	public void amountValueChangedEvent(ValueChangeEvent event) {
		UIInput amountInput = (UIInput) event.getSource();
		UISelectOne currencySelect = (UISelectOne) amountInput.findComponent("currency");
		UIOutput output = (UIOutput) amountInput.findComponent("usdValue");
		Double amount = (Double) amountInput.getValue();
		Currency currency = (Currency) currencySelect.getValue();
		
		updateUSDValue(output, amount, currency);
		LOG.info("amountInput " + amountInput + " currencySelect " + currencySelect);
	}
	
	public void currencyValueChangedEvent(ValueChangeEvent event) {		
		UISelectOne currencySelect = (UISelectOne) event.getSource();
		UIInput amountInput = (UIInput) currencySelect.findComponent("amount");
		UIOutput output = (UIOutput) currencySelect.findComponent("usdValue");
		Double amount = (Double) amountInput.getValue();
		Currency currency = (Currency) currencySelect.getValue();
		
		updateUSDValue(output, amount, currency);
		LOG.info("amountInput " + amountInput + " currencySelect " + currencySelect);
	}
	
}
