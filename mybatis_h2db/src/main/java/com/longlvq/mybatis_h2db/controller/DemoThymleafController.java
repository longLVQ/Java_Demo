package com.longlvq.mybatis_h2db.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
        model.addAttribute("maxCnt", getMaxWordCnt(perSonForm.getPerSonEntityList()));
		return "personList";
	}
	
	@PostMapping("/update-muti")
	public String updateMutiRecord(PerSonForm perSonForm) {
		//genarate list temp 
		List<PerSonEntity> perSonList = perSonForm.getPerSonEntityList();
		if(perSonForm.getPerSonEntityList() == null) {
			return "err";
		}
		for (PerSonEntity perSonEntity : perSonList) {
			if(perSonEntity.getWord_cnt() != null && perSonEntity.getWord_cnt().compareTo(new BigDecimal(0))>0) {
				List<String> stringList = new ArrayList<String>();
				for (int i = 0; i < perSonEntity.getWord_cnt().intValue(); i++) {
					stringList.add(String.valueOf(i+1) );
				}
				perSonEntity.setWordCntTempList(stringList);
			}
		}
		
		perSonepository.updateMutiRecord(perSonForm.getPerSonEntityList());
		return "redirect:/thymeleaf/listPerson";
	}
	
	private BigDecimal getMaxWordCnt(List<PerSonEntity> list) {
		if(list != null && list.size() > 0) {
			BigDecimal maxCnt = list.get(0).getWord_cnt();
			for (PerSonEntity perSonEntity : list) {
				if(perSonEntity.getWord_cnt().compareTo(maxCnt) > 0) {
					maxCnt = perSonEntity.getWord_cnt();
				}
			}
			return maxCnt;
		}
		return null;
	}
}
