package info.whiter4bbit.ejb;

import info.whiter4bbit.model.BaseModel;

import java.io.Serializable;

public interface BaseDao<T extends BaseModel> {
	T get(Serializable id);
	T save(T t);
	void delete(T instance);
}
