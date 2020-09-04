package com.example.order.service;

import com.example.common.entity.Repertory;
import com.example.order.service.impl.RpcServiceError;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author yww
 */
@FeignClient(value = "repertory", fallback = RpcServiceError.class)
public interface RpcService {

	/**
	 * @return
	 */
	@RequestMapping(value = "/repertory/list",method = RequestMethod.GET)
	List<Repertory> listRepertory();

}
