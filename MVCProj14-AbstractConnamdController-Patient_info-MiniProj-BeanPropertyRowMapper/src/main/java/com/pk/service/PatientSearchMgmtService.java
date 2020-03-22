package com.pk.service;

import java.util.List;

import com.pk.dto.PatientInputDTO;
import com.pk.dto.PatientResultDetailsDTO;

public interface PatientSearchMgmtService {

	public List<PatientResultDetailsDTO> searchPatient(PatientInputDTO dto);
}
