package top.cantos;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import top.cantos.entity.MemberEntity;

@FeignClient(value = "member")
@CacheConfig(cacheNames = "member")
public interface IMemberControllerService {

	@GetMapping(value = "/find/{id}")
	@Cacheable(key = "#id.toString()")
	MemberEntity find(@PathVariable Long id);

	@PostMapping(value = "/save")
	int save(@RequestBody MemberEntity entity);
}
