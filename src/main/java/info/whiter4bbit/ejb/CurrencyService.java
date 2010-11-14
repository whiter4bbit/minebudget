package info.whiter4bbit.ejb;

import info.whiter4bbit.model.Currency;
import info.whiter4bbit.model.Money;

import javax.ejb.Remote;

@Remote
public interface CurrencyService {
	Double convert(Currency from, Currency to, Double amount);
	Money convert(Money from, Currency to);
}
