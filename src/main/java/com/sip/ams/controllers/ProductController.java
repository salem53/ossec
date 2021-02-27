package com.sip.ams.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("product")
public class ProductController {

	
	@RequestMapping("list")
	public String listProduct()
	{
		return "product/list";
	}
}
