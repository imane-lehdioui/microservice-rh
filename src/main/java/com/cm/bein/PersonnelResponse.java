package com.cm.bein;

import com.cm.rh.entity.TypePersonnel;

public interface PersonnelResponse {

	Long getId();
	
	String getNom();	   
	String getPrenom();
	String getMatricule();
	TypePersonnel getTypePersonnel();
}
