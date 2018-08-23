package top.cantos.service.cache.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;

import tk.mybatis.mapper.common.Mapper;
import top.cantos.service.cache.IRedisCacheBaseService;

@CacheConfig(cacheNames = "member")
public class RedisCacheBaseService<T> implements IRedisCacheBaseService<T> {
	@Autowired
	private Mapper<T> mapper;

	@Override
	public T selectByPrimaryKey(Object id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public int insert(T t) {
		return mapper.insert(t);
	}

	@Override
	public int insertSelective(T record) {
		return mapper.insertSelective(record);
	}

	@Override
	public int updateByPrimaryKey(T record, Object id) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int updateByPrimaryKeySelective(T record, Object id) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int deleteByPrimaryKey(Object key) {
		return mapper.deleteByPrimaryKey(key);
	}
}
