package com.company.controller;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.company.command.DataVO;
import com.company.service.DataService;

@Controller
@RequestMapping("/result")
public class resultController {

	@Autowired
	@Qualifier("DataService")
	DataService dataService;
	
	// 결과 화면 이동 - 전체 성공
	@RequestMapping(value="/resultView_S")
	public void result_s(DataVO vo, HttpSession session) {
	}
	
	// 조회 기능
	@ResponseBody 
	@RequestMapping(value="/list")
	public List<DataVO> list() {
		
		// 서비스 연결
		List<DataVO> results = dataService.getList();
		return results;
	}	
	
	// 결과 화면 이동 - 전체 / 일부 실패
	@RequestMapping(value="/resultView_F") // 리다이렉트 해서 get으로 들어옴
	public void result_f() {
		
	}
}
