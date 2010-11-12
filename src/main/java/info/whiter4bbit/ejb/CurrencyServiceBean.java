package info.whiter4bbit.ejb;

import java.util.HashMap;
import java.util.Map;

import info.whiter4bbit.model.Currency;
import info.whiter4bbit.model.CurrencyProperties;

import javax.ejb.Singleton;

@Singleton
public class CurrencyServiceBean implements CurrencyService {

	private Map<Currency, CurrencyProperties> properties;
	
	public CurrencyServiceBean() {
		CurrencyProperties blrProps = new CurrencyProperties();
		blrProps.setCurrency(Currency.BLR);
		blrProps.setFromUSD(3030.);
		blrProps.setToUSD(1/3030.);
		
		CurrencyProperties usdProps = new CurrencyProperties();
		usdProps.setCurrency(Currency.USD);
		usdProps.setFromUSD(1.);
		usdProps.setToUSD(1.);
		
		properties = new HashMap<Currency, CurrencyProperties>();
		properties.put(Currency.BLR, blrProps);
		properties.put(Currency.USD, usdProps);
	}
	
	@Override
	public Double convert(Currency from, Currency to, Double amount) {
		Double usdAmount = properties.get(from).getToUSD()*amount;
		return properties.get(to).getFromUSD()*usdAmount;
	}
}
