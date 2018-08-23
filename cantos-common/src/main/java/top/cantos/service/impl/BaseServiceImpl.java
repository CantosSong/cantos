package top.cantos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import tk.mybatis.mapper.common.Mapper;
import top.cantos.service.IBaseService;

public class BaseServiceImpl<T> implements IBaseService<T> {
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
	public int updateByPrimaryKey(T record) {
		return mapper.updateByPrimaryKey(record);
	}

	@Override
	public int updateByPrimaryKeySelective(T record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int deleteByPrimaryKey(Object key) {
		return mapper.deleteByPrimaryKey(key);
	}

}
