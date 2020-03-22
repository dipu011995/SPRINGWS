package com.pk.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;

import com.pk.bo.PatientInputBO;
import com.pk.bo.PatientResultDetailsBO;

public class PatientSearchDAOImpl implements PatientSearchDAO {

	private static final String GET_PATIENT_DETAILS_URL = "SELECT PID,PNAME,AGE,GENDER,DISEASE,DOCTOR,WARD_NO,ADRESS,CONTACT FROM PATIENT_INFORMATION WHERE PNAME = ? OR DISEASE = ? OR DOCTOR = ? OR ADRESS = ? ";

	private JdbcTemplate jt;

	public PatientSearchDAOImpl(JdbcTemplate jt) {
		this.jt = jt;
	}

	@Override
	public List<PatientResultDetailsBO> findPatientDetails(PatientInputBO inputBO) {
		List<PatientResultDetailsBO> listResultBO = null;
		
		
		jt.query(GET_PATIENT_DETAILS_URL,
					new RowMapperResultSetExtractor(new BeanPropertyRowMapper<PatientResultDetailsBO>(PatientResultDetailsBO.class)), 
					inputBO.getPname(), inputBO.getDisease(), inputBO.getDoctor(), inputBO.getAdress());
		
		listResultBO = jt.query(GET_PATIENT_DETAILS_URL, new ResultSetExtractor<List<PatientResultDetailsBO>>() {

			@Override
			public List<PatientResultDetailsBO> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<PatientResultDetailsBO> listResBO = null;
				PatientResultDetailsBO resBO = null;

				listResBO = new ArrayList<PatientResultDetailsBO>();
				while (rs.next()) {
					resBO = new PatientResultDetailsBO();
					resBO.setPid(rs.getInt(1));
					resBO.setPname(rs.getString(2));
					resBO.setAge(rs.getInt(3));
					resBO.setGender(rs.getString(4));
					resBO.setDisease(rs.getString(5));
					resBO.setDoctor(rs.getString(6));
					resBO.setWordNo(rs.getInt(7));
					resBO.setAdress(rs.getString(8));
					resBO.setContact(rs.getLong(9));

					listResBO.add(resBO);
				}
				return listResBO;
			}
		}, inputBO.getPname(), inputBO.getDisease(), inputBO.getDoctor(), inputBO.getAdress());

		return listResultBO;
	}

	/*	@Override
		public List<PatientResultDetailsBO> findPatientDetails(PatientInputBO inputBO) {
			List<PatientResultDetailsBO> listResultBO = null;	
			listResultBO = jt.query(GET_PATIENT_DETAILS_URL, new PatientResultSetExtractor(),  inputBO.getPname(),inputBO.getDisease(),inputBO.getDoctor(),inputBO.getAdress());				
			return listResultBO;
		}//searchPatientDetails()
	
		private class PatientResultSetExtractor implements ResultSetExtractor<List<PatientResultDetailsBO>>{
			@Override
			public List<PatientResultDetailsBO> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<PatientResultDetailsBO> listBO = null;
				PatientResultDetailsBO bo = null;
	
				listBO = new ArrayList<PatientResultDetailsBO>();
				while(rs.next()) {
					bo = new PatientResultDetailsBO();
					bo.setPid(rs.getInt(1));
					bo.setPname(rs.getString(2));
					bo.setAge(rs.getInt(3));
					bo.setGender(rs.getString(4));
					bo.setDisease(rs.getString(5));
					bo.setDoctor(rs.getString(6));
					bo.setWordNo(rs.getInt(7));
					bo.setAdress(rs.getString(8));
					bo.setContact(rs.getLong(9));
	
					listBO.add(bo);
				}//while
				return listBO;
			}//extractData
		}//class
	 */
}
