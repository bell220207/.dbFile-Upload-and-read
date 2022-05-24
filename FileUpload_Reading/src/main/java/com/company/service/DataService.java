package com.company.service;
import java.util.ArrayList;
import java.util.List;
import com.company.command.DataVO;

public interface DataService {
	
	// 반환타입이 없을 때는 void로 바꿔주어야 한다
	public void save(DataVO vo);
	public List<DataVO> getList();
}
