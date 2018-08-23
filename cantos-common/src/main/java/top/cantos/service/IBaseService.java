package top.cantos.service;

public interface IBaseService<T> {

	T selectByPrimaryKey(Object id);

	int insert(T t);

	public int insertSelective(T record);

	public int updateByPrimaryKey(T record);

	public int updateByPrimaryKeySelective(T record);

	public int deleteByPrimaryKey(Object key);

}
