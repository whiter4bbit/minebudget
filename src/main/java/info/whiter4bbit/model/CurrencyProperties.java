package info.whiter4bbit.model;

import java.util.Locale;

public interface CurrencyProperties {
	
	Currency getCurrency();	
		
	Double getToUSD();

	Double getFromUSD();

	Locale getLocale();
	
}
