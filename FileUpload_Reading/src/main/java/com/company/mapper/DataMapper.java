package com.company.mapper;
import java.util.ArrayList;
import java.util.List;
import com.company.command.DataVO;

public interface DataMapper {

	public void save(DataVO vo);
	public List<DataVO> getList();
}
