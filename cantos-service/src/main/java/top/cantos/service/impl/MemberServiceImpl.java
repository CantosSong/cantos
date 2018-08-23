package top.cantos.service.impl;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import top.cantos.entity.MemberEntity;
import top.cantos.service.cache.impl.RedisCacheBaseService;

@Service
@CacheConfig(cacheNames = "member")
public class MemberServiceImpl extends RedisCacheBaseService<MemberEntity> {
}