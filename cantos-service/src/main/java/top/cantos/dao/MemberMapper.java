package top.cantos.dao;

import org.apache.ibatis.annotations.Mapper;

import top.cantos.entity.MemberEntity;

@Mapper
public interface MemberMapper extends tk.mybatis.mapper.common.Mapper<MemberEntity> {
}
