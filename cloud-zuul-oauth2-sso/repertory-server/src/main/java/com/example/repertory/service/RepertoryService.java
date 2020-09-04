package com.example.repertory.service;

import com.example.common.entity.Repertory;
import com.example.repertory.repository.RepertoryRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yww
 */
@Service
public class RepertoryService {

	@Resource
	private RepertoryRepository repertoryRepository;

	public List<Repertory> ListRepertory() {
		return repertoryRepository.findAll();
	}
}
