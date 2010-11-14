package info.whiter4bbit.ejb.currency;

import java.util.Locale;

import info.whiter4bbit.model.Currency;
import info.whiter4bbit.model.CurrencyProperties;

public final class BLRCurrencyProperties implements CurrencyProperties {	
	
	@Override
	public Currency getCurrency() {
		return Currency.BLR;
	}

	@Override
	public Double getToUSD() {
		return 1/3030.;
	}

	@Override
	public Double getFromUSD() {
		return 3030.;
	}

	@Override
	public Locale getLocale() {
		return new Locale("be", "BY");
	}
	
}
