package com.example.order.controller;

import com.example.common.entity.Repertory;
import com.example.order.service.RpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author yinweiwei
 * @date 2019-03-03
 */
@RestController
@RequestMapping("/rpc")
public class RpcController {

	@Autowired
	private RpcService rpcService;

	@GetMapping("/list")
	public List<Repertory> list() {
		return rpcService.listRepertory();
	}

}
