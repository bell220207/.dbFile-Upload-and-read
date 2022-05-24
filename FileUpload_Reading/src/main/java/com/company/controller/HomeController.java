package com.company.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	// 업로드 화면 이동
	@RequestMapping(value="/")
	public String uploadView() {
		return "upload/uploadView";
	}
	
}
