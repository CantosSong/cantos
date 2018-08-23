package top.cantos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import top.cantos.IMemberControllerService;
import top.cantos.entity.MemberEntity;

@RestController
public class TestController {
	@Autowired
	private IMemberControllerService memberControllerService;

	@GetMapping("find")
	public MemberEntity find(Long id) {
		// TODO Auto-generated method stub
		return memberControllerService.find(id);
	}
	@PostMapping("save")
	public int save(@RequestBody MemberEntity entity) {
		// TODO Auto-generated method stub
		return memberControllerService.save(entity);
	}
}
