package com.pk.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.pk.entity.EmployeeEntity;

@Repository("empDAO")
public class EmployeeDAOImpl implements EmployeeDAO {

	private static final String GET_EMP_BY_DESG_P_PARAM = "FROM EmployeeEntity WHERE desg IN(?,?)";
	private static final String GET_EMP_BY_DESG_N_PARAM = "FROM EmployeeEntity WHERE desg IN(:desg1,:desg2)";
	private static final String DELETE_EMP_BY_SAL_MARK =  "DELETE FROM EmployeeEntity WHERE salary>?";
	
	private static final String UPDATE_SAL_BY_DESG =  "UPDATE EmployeeEntity SET salary = salary + (salary* :per) WHERE desg = :deg ";
	
	@Autowired
	private HibernateTemplate ht;

	@Override
	public List<EmployeeEntity> getEmployeeByDesgByPositionalParameter(String desg1, String desg2) {
		return (List<EmployeeEntity>) ht.find(GET_EMP_BY_DESG_P_PARAM, desg1,desg2);
	}

	@Override
	public List<EmployeeEntity> getEmployeeByDesgByNamedParameter(String desg1, String desg2) {
		return (List<EmployeeEntity>) ht.findByNamedParam(GET_EMP_BY_DESG_N_PARAM, new String[] {"desg1","desg2"},  new String[] {desg1,desg2});
	}

	@Override
	public List<EmployeeEntity> getEmployeebySalRangeTakingGlobalNamedQuery(float minSal, float MaxSal) {
		return (List<EmployeeEntity>) ht.findByNamedQueryAndNamedParam("getEmpbySalRange", new String[] {"minSalary","maxSalary"}, new Float[] {minSal,MaxSal});
	}

	@Override
	public int fireEmployeebySalarymark(float markSalary) {
		ht.setCheckWriteOperations(false);
		return ht.bulkUpdate(DELETE_EMP_BY_SAL_MARK, markSalary);
	
	}

	
	
	@Override
	public int updateEmpSalaryByDesg(String desg, float percentage) {
		
		return ht.execute(new MyCallBackInterface(desg, percentage));
	}
	
	private class MyCallBackInterface implements HibernateCallback<Integer> {

		private String desg;
		private Float percentage;
		
		public MyCallBackInterface(String desg, float percentage) {
			this.desg = desg;
			this.percentage = percentage;
		}

		@Override
		public Integer doInHibernate(Session ses) throws HibernateException {
				Query query = null;
				
				//set query
				query = ses.createQuery(UPDATE_SAL_BY_DESG);
				//set param
				query.setParameter("per", percentage);
				query.setParameter("deg", desg);
				 return query.executeUpdate();
		}

		
		
		
		
	}
	
	
}
