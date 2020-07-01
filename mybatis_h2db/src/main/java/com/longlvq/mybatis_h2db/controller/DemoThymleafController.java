package com.longlvq.mybatis_h2db.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.longlvq.mybatis_h2db.entity.PerSonEntity;
import com.longlvq.mybatis_h2db.form.PerSonForm;
import com.longlvq.mybatis_h2db.repository.PerSonRepository;

@Controller
@RequestMapping("thymeleaf")
public class DemoThymleafController {
	@Autowired
	PerSonRepository perSonepository;
	
	@GetMapping("/listPerson")
	public String updateMutiRecord(Model model) {
		PerSonForm perSonForm = new PerSonForm();
		perSonForm.setPerSonEntityList(perSonepository.selectAllStudent());
        model.addAttribute("perSonForm", perSonForm);
		return "personList";
	}
	
	@PostMapping("/update-muti")
	public String updateMutiRecord(PerSonForm perSonForm) {
		perSonepository.updateMutiRecord(perSonForm.getPerSonEntityList());
		return "redirect:/thymeleaf/listPerson";
	}
}
