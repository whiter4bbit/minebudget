package info.whiter4bbit.ejb;

import info.whiter4bbit.ejb.currency.CurrencyUtils;
import info.whiter4bbit.model.Currency;
import info.whiter4bbit.model.CurrencyProperties;
import info.whiter4bbit.model.Money;

import javax.ejb.Singleton;

@Singleton
public class CurrencyServiceBean implements CurrencyService {
	
	@Override
	public Double convert(Currency from, Currency to, Double amount) {
		CurrencyProperties currencyFrom = CurrencyUtils.getProperties(from);
		CurrencyProperties currencyTo = CurrencyUtils.getProperties(to);
		Double usdAmount = currencyFrom.getToUSD() * amount;
		return currencyTo.getFromUSD() * usdAmount;
	}
	
	@Override
	public Money convert(Money from, Currency to) {
		Double amount = convert(from.getCurrency(), to, from.getAmount());		
		return new Money(amount, to);
	}
}
