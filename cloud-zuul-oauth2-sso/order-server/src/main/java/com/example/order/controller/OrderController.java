package com.example.order.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yinweiwei
 * @date 2019-03-03
 */
@Controller
@RequestMapping("/order")
public class OrderController {

	@GetMapping("/list")
	public String list() {
		return "order/list";
	}

}
