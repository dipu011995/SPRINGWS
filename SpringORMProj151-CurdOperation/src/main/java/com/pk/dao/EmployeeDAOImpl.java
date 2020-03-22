package com.pk.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.pk.entity.EmployeeEntity;

@Repository("empDAO")
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public int saveEmployee(EmployeeEntity empEntity) {
		ht.setCheckWriteOperations(false);
		return (int) ht.save(empEntity);
		}

	@Override
	public EmployeeEntity getEmployeeById(int id) {
		return ht.get(EmployeeEntity.class, id);
	}

	@Override
	public void updateEmployee(EmployeeEntity emp) {
		ht.setCheckWriteOperations(false);
		ht.saveOrUpdate(emp);
	}

}
