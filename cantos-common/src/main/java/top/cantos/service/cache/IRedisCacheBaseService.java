package top.cantos.service.cache;

import org.springframework.cache.annotation.Cacheable;

public interface IRedisCacheBaseService<T> {

	@Cacheable(key = "#id.toString()")
	T selectByPrimaryKey(Object id);

	int insert(T t);

	public int insertSelective(T record);

	@Cacheable(key = "#id.toString()")
	public int updateByPrimaryKey(T record, Object id);

	@Cacheable(key = "#id.toString()")
	public int updateByPrimaryKeySelective(T record, Object id);

	@Cacheable(key = "#id.toString()")
	public int deleteByPrimaryKey(Object id);
}
