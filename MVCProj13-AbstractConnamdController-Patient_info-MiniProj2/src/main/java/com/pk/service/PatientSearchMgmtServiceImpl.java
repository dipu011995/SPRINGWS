package com.pk.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.pk.bo.PatientInputBO;
import com.pk.bo.PatientResultDetailsBO;
import com.pk.dao.PatientSearchDAO;
import com.pk.dto.PatientInputDTO;
import com.pk.dto.PatientResultDetailsDTO;

public class PatientSearchMgmtServiceImpl implements PatientSearchMgmtService {

	private PatientSearchDAO dao;

	public PatientSearchMgmtServiceImpl(PatientSearchDAO dao) {
		this.dao = dao;
	}

	@Override
	public List<PatientResultDetailsDTO> searchPatient(PatientInputDTO inputDTO) {
		PatientInputBO inputBO = null;
		List<PatientResultDetailsBO> listResultBO = null;
		List<PatientResultDetailsDTO> listResultDTO = new ArrayList<PatientResultDetailsDTO>();
		
		// convert dto to bo
		inputBO = new PatientInputBO();
		BeanUtils.copyProperties(inputDTO, inputBO);
		// use dao
		listResultBO = dao.findPatientDetails(inputBO);

		// convert bo dto
		listResultBO.forEach(resultBO -> {
			PatientResultDetailsDTO resultDTO = new PatientResultDetailsDTO();
			BeanUtils.copyProperties(resultBO, resultDTO);
			listResultDTO.add(resultDTO);
		});
		return listResultDTO;
	}

}
