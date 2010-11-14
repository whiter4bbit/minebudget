package info.whiter4bbit.ejb.currency;

import info.whiter4bbit.model.Currency;
import info.whiter4bbit.model.CurrencyProperties;

import java.util.HashMap;
import java.util.Map;

public final class CurrencyUtils {

	private static final Map<Currency, CurrencyProperties> properties =  
		new HashMap<Currency, CurrencyProperties>() {{
			put(Currency.BLR, new BLRCurrencyProperties());
			put(Currency.USD, new USDCurrencyProperties());
		}};
	
	public static CurrencyProperties getProperties(Currency currency) {
		assert currency != null;
		CurrencyProperties currencyProperties = properties.get(currency);
		if (currencyProperties == null) {
			throw new IllegalStateException("CurrencyProperties instance for " 
					+ currency + " not defined");
		}
		return currencyProperties;
	}
		
}
