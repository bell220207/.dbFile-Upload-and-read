package com.company.controller;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.company.command.DataVO;
import com.company.service.DataService;

@Controller
public class uploadController {

	@Autowired
	@Qualifier("DataService")
	DataService dataService;
	
	// 업로드 기능
	@RequestMapping(value="/data", method=RequestMethod.POST)
	public String upload(@RequestParam("file") MultipartFile file, 
						 DataVO vo, HttpSession session ) {
		
		// 선언부
		String line = ""; // 파일 내용 저장할 변수
		boolean complete = true ; // 예외발생여부 구분
		int count = 0;	 // 성공 건수
		int count_f = 0; // 실패건수
		int i=0; // for문 용
		ArrayList<Integer> line_f = new ArrayList<Integer>();  // 실패한 라인번호 모으는 배열 
		ArrayList<String> text_f = new ArrayList<String>();    // 실패한 텍스트 모으는 배열 
		BufferedReader br = null;

		try {
			br = new BufferedReader(new InputStreamReader(file.getInputStream(), "UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 데이터 처리부
		try{ // 잘못된 db는 건너뛰고 다음 행 저장 진행시키는 예외처리
			for(i=1; (line=br.readLine()) != null; i++) { // 다음 줄이 없을 때까지 도는 for문
			
				String [] array = line.split("/");
				vo.setId(array[0]);
				vo.setPwd(array[1]);
				vo.setName(array[2]);
				vo.setLevel(array[3].charAt(0));
				vo.setDesc(array[4]);
				vo.setReg_Date(Timestamp.valueOf(array[5]));
				dataService.save(vo); // for 문 안에 있어야 모든 값을 등록
				count++;
			}
		}catch(Exception e) {
			complete = false; // 예외발생
			count_f++; // 실패건수 증가
			// i이용해서 line_f에 넘버 저장,  array이용해서 text_f에 실패 텍스트 저장
			line_f.add(i);
			text_f.add(line);
			e.printStackTrace();
			System.out.println("======================================");
		} // for문
		
		// 다 돌고 난 뒤에 세션에 결과 저장
		if(complete==true) { 
			session.setAttribute("count", count);
			return "redirect:/result/resultView_S"; 
		}else {
			try {
				session.setAttribute("count_f", count_f);
				session.setAttribute("line_f", line_f); // 실패 라인번호 배열
				session.setAttribute("text_f", text_f); // 실패 텍스트 배열
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("======================================");
			}
			return "redirect:/result/resultView_F"; 
		}
	}
}