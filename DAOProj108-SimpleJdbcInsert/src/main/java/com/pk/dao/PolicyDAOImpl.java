package com.pk.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.pk.bo.PolicyBO;

@Repository("policyDAO")
public class PolicyDAOImpl implements PolicyDAO {
	
	private static final String GET_POLICY_NO = "SELECT POLICY_SEQ.NEXTVAL FROM DUAL ";
	
	@Autowired
	private SimpleJdbcInsert sji;
	
	public int getPolicyNO() {
		JdbcTemplate jt = null;
		//get jdbc temp onj
		jt = sji.getJdbcTemplate();
		//invoke method
		return jt.queryForObject(GET_POLICY_NO,Integer.class);
	}

	/*public int insert(PolicyBO bo) {
		Map<String, Object> paramSource = null;
		//set values to map
		paramSource = new HashMap();
		
		paramSource.put("policyID",getPolicyNO());
		paramSource.put("policyName", bo.getPolicyName());
		paramSource.put("policyType", bo.getPolicyType());
		paramSource.put("company", bo.getCompany());
		paramSource.put("term", bo.getTerm());
		paramSource.put("mothlyInstalment", bo.getMonthlyInstalment());
				
		//specify table Name
		sji.setTableName("INSURANCEPOLICY");
		return sji.execute(paramSource);
	}*/
	
	/*public int insert(PolicyBO bo) {
		MapSqlParameterSource paramSource = null;
		//set values to map
		paramSource = new MapSqlParameterSource();
		
		paramSource.addValue("policyID",getPolicyNO());
		paramSource.addValue("policyName", bo.getPolicyName());
		paramSource.addValue("policyType", bo.getPolicyType());
		paramSource.addValue("company", bo.getCompany());
		paramSource.addValue("term", bo.getTerm());
		paramSource.addValue("mothlyInstalment", bo.getMonthlyInstalment());
				
		//specify table Name
		sji.setTableName("INSURANCEPOLICY");
		return sji.execute(paramSource);
	}*/

	public int insert(PolicyBO bo) {
		BeanPropertySqlParameterSource bpsps = null;
		//set values to map
		bpsps = new BeanPropertySqlParameterSource(bo);
		
		//specify table Name
		sji.setTableName("INSURANCEPOLICY");
		return sji.execute(bpsps);
	}
	
}
