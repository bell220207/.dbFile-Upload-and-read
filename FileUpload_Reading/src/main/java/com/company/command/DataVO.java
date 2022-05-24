package com.company.command;
import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataVO {
	private String id;
	private String pwd;
	private String name;
	private char level;
	private String desc;
	private Timestamp reg_Date;
//	private char completeYn;
}
