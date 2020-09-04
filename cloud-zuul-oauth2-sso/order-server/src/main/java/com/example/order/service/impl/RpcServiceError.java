package com.example.order.service.impl;

import com.example.common.entity.Repertory;
import com.example.common.exception.ApiException;
import com.example.order.service.RpcService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RpcServiceError implements RpcService {

	@Override
	public List<Repertory> listRepertory() {
		throw new ApiException("repertory server is disable");
	}

}
