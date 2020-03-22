package com.pk.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pk.bo.EmployeeBO;


@Repository("empDAO")
public class EmployeeDAOImpl implements EmployeeDAO {
	
	private static final String GET_EMPS_BY_DESG="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB IN (:DESG1,:DESG2,:DESG3) ORDER BY JOB";

	@Autowired
	private NamedParameterJdbcTemplate npjt;
	
	public List<Map<String, Object>> getEmployeesByDesg(String desg1, String desg2, String desg3) {
		
		List<Map<String, Object>> listBO = null;
		MapSqlParameterSource paramSource = null;
		//add value for query param
		paramSource = new MapSqlParameterSource();
		paramSource.addValue("DESG1", desg1);
		paramSource.addValue("DESG2", desg2);
		paramSource.addValue("DESG3", desg3);
		
		listBO = npjt.queryForList(GET_EMPS_BY_DESG,paramSource);
															
		return listBO;
	}

	public List<EmployeeBO> getEmpsByJob(String desg1, String desg2, String desg3) {
		
		List<EmployeeBO> llistBO =null;
		Map<String, Object> paramMap = null;
		
		paramMap = new HashMap();
		paramMap.put("DESG1", desg1);
		paramMap.put("DESG2", desg2);
		paramMap.put("DESG3", desg3);
		
		return npjt.query(GET_EMPS_BY_DESG, 
													paramMap, 
															rs->{
																List<EmployeeBO> listBO= null;
																EmployeeBO empBO = null;
																listBO = new ArrayList();
																while(rs.next()) {
																	empBO = new EmployeeBO();
																	empBO.setEmpNO(rs.getInt(1));
																	empBO.setEName(rs.getString(2));
																	empBO.setJob(rs.getString(3));
																	empBO.setSal(rs.getInt(4));
																	listBO.add(empBO);
																}
																return listBO;
															});
	}//method

}//class