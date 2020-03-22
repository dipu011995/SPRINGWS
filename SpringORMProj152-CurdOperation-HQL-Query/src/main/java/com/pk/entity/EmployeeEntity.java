package com.pk.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import lombok.Data;

@Entity
@Table(name ="EMPLOYEE" )
@Data
@NamedQueries({
						@NamedQuery(name = "getEmpbySalRange",query ="FROM EmployeeEntity WHERE salary>=:minSalary AND salary<=:maxSalary" ),
								}
)
public class EmployeeEntity implements Serializable {
	
	@Id
	@GenericGenerator(name = "gen1", strategy = "increment")
	@GeneratedValue(generator = "gen1")
	@Column(name = "EID",length = 10)
	@Type(type = "int")
	private int eid;
	
	@Column(name = "ENAME",length = 20)
	@Type(type = "string")
	private String ename;
	
	@Column(name = "DESG",length = 20)
	@Type(type = "string")
	private String desg;
	
	@Column(name = "SALARY",length = 10,scale = 10,precision = 2)
	@Type(type = "float")
	private float salary;
	
}
