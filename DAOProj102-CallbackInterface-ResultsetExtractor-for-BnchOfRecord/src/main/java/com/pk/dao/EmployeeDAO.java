package com.pk.dao;

import java.util.List;
import com.pk.bo.EmployeeBO;

public interface EmployeeDAO {

	public List<EmployeeBO> getEmpsDetailsByDesg(String desg1,String desg2,String desg3) throws Exception;

}
