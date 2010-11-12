package info.whiter4bbit.ejb;

public interface Converter<F, T> {
	T convert(F from);
}
