package com.pk.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.pk.bo.StudentBO;

public class StudentDAOImpl implements StudentDAO {
	
	private static final String INSERT_STUDENT = "INSERT INTO STUDENT_INFO (SNO,SNAME,SADDRS,COURSE,BRANCE,MOB)  VALUES (SNO_SEQ.NEXTVAL,?,?,?,?,?)";
	
	private JdbcTemplate jt;

	public StudentDAOImpl(JdbcTemplate jt) {
		this.jt = jt;
	}

	public int addStudent(StudentBO bo) {
		
		return jt.update(INSERT_STUDENT,bo.getSname(),bo.getSaddrs(),bo.getCourse(),bo.getBranch(),bo.getMob());
	
	}

}
