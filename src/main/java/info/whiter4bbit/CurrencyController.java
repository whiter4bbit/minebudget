package info.whiter4bbit;

import java.util.logging.Logger;

import info.whiter4bbit.ejb.CurrencyService;
import info.whiter4bbit.model.Currency;
import info.whiter4bbit.model.Money;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
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
		this.usdAmount 
			= currencyService.convert(target.getCurrency(), Currency.USD, target.getAmount());
	}
	
	public void amountChanged(ValueChangeEvent event) {	        
	        LOG.info("some");
		LOG.info("Amount changed to " + event.getNewValue());		
	}
	
	public void currencyChanged(ValueChangeEvent event) {
		LOG.info("Currency changed to " + event.getNewValue());
	}
	
}
