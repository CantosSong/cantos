package top.cantos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import top.cantos.IMemberControllerService;
import top.cantos.entity.MemberEntity;
import top.cantos.service.cache.IRedisCacheBaseService;

@RestController
public class MemberController implements IMemberControllerService {
	@Autowired
	IRedisCacheBaseService<MemberEntity> service;

	@Override
	public MemberEntity find(@PathVariable Long id) {
		return service.selectByPrimaryKey(id);
	}

	@Override
	public int save(@RequestBody MemberEntity entity) {
		// TODO Auto-generated method stub
		return 0;
	}

}
