package com.cnsz.bootstrapping.dao;

import com.cnsz.bootstrapping.model.Action;
import com.cnsz.bootstrapping.model.Communication;

public interface ActionDAO {

	public Action getActionDetails();
	
	public Communication getCommDetails();
	
	public Action addAction();
	
	public void editAction();
	
	public void addComm();
	
}
