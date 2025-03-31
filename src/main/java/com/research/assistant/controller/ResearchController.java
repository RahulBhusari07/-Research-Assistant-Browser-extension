package com.research.assistant.controller;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.research.assistant.model.ResearchRequest;
import com.research.assistant.service.ResearchService;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/research")
@CrossOrigin("*")
@AllArgsConstructor
public class ResearchController {
	
	private  ResearchService researchService;
     
	@Autowired
	public void setResearchService(ResearchService researchService) {
		this.researchService = researchService;
	}
	

	@PostMapping("/process")
	public   ResponseEntity<String> processContent(@RequestBody ResearchRequest request) {
		
		String result = researchService.processContent(request);
		return ResponseEntity.ok(result);
		
	}
	

	
	
	
	

}
