package info.whiter4bbit.ejb;

import java.util.ArrayList;
import java.util.List;

public abstract class ListConverter<F, T> implements Converter<F, T> {
	
	public List<T> convert(List<F> from) {
		List<T> list = new ArrayList<T>();
		for (F f : from) {
			list.add(convert(f));
		}
		return list;
	}
	
}
