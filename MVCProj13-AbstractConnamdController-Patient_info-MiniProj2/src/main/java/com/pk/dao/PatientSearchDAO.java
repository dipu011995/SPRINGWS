package com.pk.dao;

import java.util.List;

import com.pk.bo.PatientInputBO;
import com.pk.bo.PatientResultDetailsBO;

public interface PatientSearchDAO {
	
	public List<PatientResultDetailsBO> findPatientDetails(PatientInputBO bo);

}
