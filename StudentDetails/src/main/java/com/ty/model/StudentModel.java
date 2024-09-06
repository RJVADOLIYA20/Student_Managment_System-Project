package com.ty.model;

import com.ty.Utility.StudentDAO;

public interface StudentModel {
 
	void add();
	void delete();
	void update();
	
	public static StudentModel getInstance() {
		return new StudentDAO();
	}
}
