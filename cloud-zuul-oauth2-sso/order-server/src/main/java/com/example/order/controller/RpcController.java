package com.example.order.controller;

import com.example.common.entity.Repertory;
import com.example.common.exception.BaseException;
import com.example.common.exception.ResponseEnum;
import com.example.order.service.RpcService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yinweiwei
 * @date 2019-03-03
 */
@RestController
@RequestMapping("/rpc")
public class RpcController {

	@Resource
	private RpcService rpcService;

	@GetMapping("/list")
	public List<Repertory> list() {
		return rpcService.listRepertory();
	}

	@GetMapping("/test/{userName}")
	public String test(@PathVariable("userName") String userName, @RequestParam(required = false) String userId){
		ResponseEnum.NOT_NULL.assertNotNull(userId,"userId");
		return userName;
	}

}
