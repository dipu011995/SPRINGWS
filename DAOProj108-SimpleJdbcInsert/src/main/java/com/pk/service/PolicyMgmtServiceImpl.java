package com.pk.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pk.bo.PolicyBO;
import com.pk.dao.PolicyDAO;
import com.pk.dto.PolicyDTO;

@Service("empService")
public class PolicyMgmtServiceImpl implements PolicyMgmtService {

	@Autowired
	private PolicyDAO dao;
	
	public String applyPolicy(PolicyDTO dto) {
		PolicyBO bo = null;
		int result = 0;
		bo = new PolicyBO();
		//copy dto to bo
		BeanUtils.copyProperties(dto, bo);
		result =  dao.insert(bo);
		if(result==0)
			return "Insuraince application failed to procedd,plz try again";
		else
			return "Insuraince application sucessed";
	}

}
