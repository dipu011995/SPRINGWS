package com.pk.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class LoginDTO implements Serializable{
	
	public String user;
	public String pass;	

}
