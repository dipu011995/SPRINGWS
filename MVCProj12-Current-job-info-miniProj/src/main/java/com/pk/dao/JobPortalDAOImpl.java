package com.pk.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.pk.bo.JobPortalBO;

public final class JobPortalDAOImpl implements JobPortalDAO {
	
	private static final String GET_ALL_CURRENT_JOB_OPENINGS_LIST = "SELECT JOB_ID,COMPANY_NAME,POSITION,JOB_PROFILE,NO_OF_POSITION,EXPERIANCE_RANGE,SALARY_RANGE,LOCATION FROM CURRENT_JOB_INFO ";
	private JdbcTemplate jt;
	
	public JobPortalDAOImpl(JdbcTemplate jt) {
		this.jt = jt;
	}
	
	@Override
	public List<JobPortalBO> getAllTrandingJobOpenings() {
		
		List<JobPortalBO> listBo = null;
		
		listBo = jt.query(GET_ALL_CURRENT_JOB_OPENINGS_LIST, new JobDetailsExtractor());
		return listBo;
	}
	
	private class JobDetailsExtractor implements ResultSetExtractor<List<JobPortalBO>>{

		@Override
		public List<JobPortalBO> extractData(ResultSet rs) throws SQLException, DataAccessException {
			List<JobPortalBO> jobListBo = null;
			JobPortalBO bo = null;
			
			jobListBo = new ArrayList<JobPortalBO>();
			//extract result fromresultset and set to bo
			while(rs.next()) {
				bo = new JobPortalBO();
				bo.setJobId(rs.getInt(1));
				bo.setCompanyName(rs.getString(2));
				bo.setPosition(rs.getString(3));
				bo.setJobProfile(rs.getString(4));
				bo.setNoOfPosition(rs.getInt(5));
				bo.setExpRange(rs.getString(6));
				bo.setSalaryrange(rs.getString(7));
				bo.setLocation(rs.getString(8));
				
				//add bo to list bo
				jobListBo.add(bo);
			}//while			
			return jobListBo;
		}//inner Class
		
	}

}
