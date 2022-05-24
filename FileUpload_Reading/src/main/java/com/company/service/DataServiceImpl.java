package com.company.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.company.command.DataVO;
import com.company.mapper.DataMapper;

@Service("DataService")
public class DataServiceImpl implements DataService{

	@Autowired
	private DataMapper dataMapper;

	@Override
	public void save(DataVO vo) {
		dataMapper.save(vo);
	}

	@Override
	public List<DataVO> getList() {
		return dataMapper.getList();
	}
}
