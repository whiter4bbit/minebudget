package info.whiter4bbit;

import java.util.logging.Logger;

import info.whiter4bbit.ejb.CurrencyService;
import info.whiter4bbit.model.Currency;
import info.whiter4bbit.model.Money;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIInput;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;

@ManagedBean(name = "currencyController")
@RequestScoped
public class CurrencyController {
	
	private static final Logger LOG = Logger.getLogger(CurrencyController.class.getName());
	
	private Double usdAmount;
	
	private Money target = new Money();
	
	@EJB
	private CurrencyService currencyService;
	
	public void setTarget(Money target) {
		this.target = target;
	}
	
	public Double getUsdAmount() {
		return usdAmount;
	}
	
	public void setUsdAmount(Double usdAmount) {
		this.usdAmount = usdAmount;
	}
	
	public void usdValue() {
		this.usdAmount = currencyService.convert(target.getCurrency(), Currency.USD, target.getAmount());
	}
	
	public void amountChanged(ValueChangeEvent event) {
		LOG.info("Value changed");		
	}
	
	public void amountValueListener(AjaxBehaviorEvent event) {
		Object currentValue = ((UIInput)event.getSource()).getValue();
		LOG.info("Value changed to " + currentValue);
	}
	
}
