package info.whiter4bbit;

import info.whiter4bbit.model.Money;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Money.class)
public class MoneyConverter implements Converter {
	
	@Override
	public Object getAsObject(FacesContext ctx, UIComponent comp, String value) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public String getAsString(FacesContext ctx, UIComponent comp, Object value) {
		Money money = (Money) value;
		return String.format("%s %.2f", money.getCurrency(), money.getAmount());
	}
}
