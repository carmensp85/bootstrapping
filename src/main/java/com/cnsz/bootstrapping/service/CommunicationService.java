package com.cnsz.bootstrapping.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnsz.bootstrapping.dao.ActionDAO;
import com.cnsz.bootstrapping.model.Action;
import com.cnsz.bootstrapping.model.Communication;

@Service
@Transactional
public class CommunicationService {
	
	@Autowired
	private ActionDAO actionDao;
	
	public Action getActionDetails() {
		return actionDao.getActionDetails();
	}
	
	public Communication getCommDetails() {
		return actionDao.getCommDetails();
	}
	
	public void editAction() {
		actionDao.editAction();
	}
	
	public void addActions() {
		actionDao.addAction();
		//actionDao.addAction(2);
		//actionDao.addAction(3);
	}
	
	public void addComm() {
		actionDao.addComm();
		//actionDao.addAction(2);
		//actionDao.addAction(3);
	}
}
