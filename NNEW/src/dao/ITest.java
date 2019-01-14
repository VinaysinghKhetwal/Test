package dao;

import java.util.List;

public interface ITest<T> {

	List<T> getAll(T object);
	List<T> update(T object);
	List<T> delete(T object);
 	}
