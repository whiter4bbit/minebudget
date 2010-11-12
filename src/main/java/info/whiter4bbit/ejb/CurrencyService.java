package info.whiter4bbit.ejb;

import info.whiter4bbit.model.Currency;

import javax.ejb.Remote;

@Remote
public interface CurrencyService {
	Double convert(Currency from, Currency to, Double amount);
}
