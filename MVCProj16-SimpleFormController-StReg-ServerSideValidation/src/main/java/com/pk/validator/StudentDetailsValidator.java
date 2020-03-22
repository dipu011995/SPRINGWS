package com.pk.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.pk.command.StudentCommand;

public class StudentDetailsValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		//return clazz == StudentCommand.class;
		return clazz.isAssignableFrom(StudentCommand.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("StudentDetailsValidator.validate()");
		StudentCommand  cmd = null;
		
		cmd = (StudentCommand) target;
		
		if(cmd.getSname()==null || cmd.getSname().length()==0 || cmd.getSname().equals(""))
			errors.rejectValue("sname","st.name.required");
		else if (cmd.getSname().length()>30) 
			errors.rejectValue("sname","st.name.maxlength");
		
		if(cmd.getSaddrs()==null || cmd.getSaddrs().length()==0 || cmd.getSaddrs().equals(""))
			errors.rejectValue("saddrs","st.saddr.required");
		else if(cmd.getSaddrs().length()<3)
			errors.rejectValue("saddrs", "st.addrs.minlength");
		
		if(cmd.getCourse()==null || cmd.getCourse().length()==0 || cmd.getCourse().equals(""))
			errors.rejectValue("course","st.course.required");
		
		if(cmd.getBranch()==null || cmd.getBranch().length()== 0 || cmd.getBranch().equals(""))
			errors.rejectValue("branch", "st.branch.required");
		
		if(cmd.getMob()== null || cmd.getMob().equals(""))
			errors.rejectValue("mob", "st.mob.required");
		//write this in application logic error
//		else if (String.valueOf(cmd.getMob()).length()!=10)
//			errors.rejectValue("mob", "st.mob.length");

	}

}
