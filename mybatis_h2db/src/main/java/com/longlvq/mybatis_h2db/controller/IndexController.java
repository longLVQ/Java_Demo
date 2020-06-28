package com.longlvq.mybatis_h2db.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.longlvq.mybatis_h2db.entity.PerSonEntity;
import com.longlvq.mybatis_h2db.repository.PerSonRepository;

@Controller
public class IndexController {
	@Autowired
	PerSonRepository perSonepository;
	
	@ResponseBody
	@GetMapping("/")
	public PerSonEntity getPersonById() {
		return perSonepository.selectStudentById(1);
	}
	@ResponseBody
	@GetMapping("/all")
	public List<PerSonEntity> getPersonAll() {
		return perSonepository.selectAllStudent();
	}
}
