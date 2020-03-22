package com.pk.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;

import com.pk.bo.PatientInputBO;
import com.pk.bo.PatientResultDetailsBO;

public class PatientSearchDAOImpl implements PatientSearchDAO {

	private static final String GET_PATIENT_DETAILS_URL = "SELECT PID,PNAME,AGE,GENDER,DISEASE,DOCTOR,WARD_NO,ADRESS,CONTACT FROM PATIENT_INFORMATION WHERE (PNAME IS NOT NULL AND PNAME LIKE ? ) OR (DISEASE IS NOT NULL AND DISEASE LIKE ?) OR (DOCTOR IS NOT NULL AND DOCTOR LIKE ?) OR (ADRESS IS NOT NULL AND ADRESS LIKE ?) ";

	private JdbcTemplate jt;

	public PatientSearchDAOImpl(JdbcTemplate jt) {
		this.jt = jt;
	}

	@Override
	public List<PatientResultDetailsBO> findPatientDetails(PatientInputBO inputBO) {
		List<PatientResultDetailsBO> listResultBO = null;
		System.out.println(inputBO);
		listResultBO = (List<PatientResultDetailsBO>) jt.query(GET_PATIENT_DETAILS_URL, 
												new RowMapperResultSetExtractor(new BeanPropertyRowMapper<PatientResultDetailsBO>(PatientResultDetailsBO.class)), 
				     							inputBO.getPname(),inputBO.getDisease(),inputBO.getDoctor(),inputBO.getAdress());
				
		return listResultBO;
	}
}
		
		
		