package com.pk.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pk.bo.JobPortalBO;
import com.pk.dao.JobPortalDAO;
import com.pk.dto.JobPortalDTO;

public class JobPortalMgmtServiceImpl implements JobPortalMgmtService {
	
	private JobPortalDAO dao;
	
	public JobPortalMgmtServiceImpl(JobPortalDAO dao) {
		this.dao = dao;
	}

	@Override
	public List<JobPortalDTO> findAllCurretntTrendingJob() {
		List<JobPortalBO> listBO = null;
		List<JobPortalDTO> listDTO = new ArrayList<JobPortalDTO>();
		
		listBO = dao.getAllTrandingJobOpenings();
		
		//convert listBo to listDTO
		listBO.forEach(bo->{
			JobPortalDTO dto = new JobPortalDTO();
			BeanUtils.copyProperties(bo, dto);
			dto.setSlNo(listDTO.size()+1);
			listDTO.add(dto);
		});
		return listDTO;
	}

	

}
