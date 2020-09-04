package com.example.repertory.controller;

import com.example.common.entity.Repertory;
import com.example.repertory.service.RepertoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yinweiwei
 * @date 2019-03-03
 */
@RestController
public class RepertoryController {

	@Autowired
	private RepertoryService repertoryService;

	@GetMapping("/list")
	public List<Repertory> list() {
		return repertoryService.ListRepertory();
	}

}
