package info.whiter4bbit.ejb.currency;

import java.util.Locale;

import info.whiter4bbit.model.Currency;
import info.whiter4bbit.model.CurrencyProperties;

public class USDCurrencyProperties implements CurrencyProperties {

	@Override
	public Currency getCurrency() {
		return Currency.USD;
	}

	@Override
	public Double getToUSD() {
		return 1.;
	}

	@Override
	public Double getFromUSD() {
		return 1.;
	}

	@Override
	public Locale getLocale() {
		return new Locale("en", "US");
	}

}
