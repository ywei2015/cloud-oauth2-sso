package com.example.order.service.impl;

import com.example.common.entity.Repertory;
import com.example.common.exception.BaseException;
import com.example.order.service.RpcService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RpcServiceError implements RpcService {

	@Override
	public List<Repertory> listRepertory() {
		throw new RuntimeException("repertory server is disable");
	}

}
