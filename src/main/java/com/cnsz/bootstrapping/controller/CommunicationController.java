package com.cnsz.bootstrapping.controller;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cnsz.bootstrapping.model.Action;
import com.cnsz.bootstrapping.model.Communication;
import com.cnsz.bootstrapping.service.CommunicationService;

@Controller
public class CommunicationController {
	
	@Autowired
	private CommunicationService commService;
	
	@RequestMapping(value="/getAction", method=RequestMethod.GET)
	public ResponseEntity<String> getActionDetails() {
		Action action = commService.getActionDetails();
		action.getDocs().get(0).getIdDocument().getName();
		System.out.println("resultado: " + action.toString());
		System.out.println("Total docs de la accion: " + action.getDocs().size());
		return new ResponseEntity<String>("Todo OK - datos obtenidos",HttpStatus.OK);
	}
	
	@RequestMapping(value="/getComm", method=RequestMethod.GET)
	public ResponseEntity<String> getCommDetails() {
		Communication comm = commService.getCommDetails();
		System.out.println("resultado: " + comm.toString());
		System.out.println("Total acciones:" + comm.getActions().size());
		
		int totalDocs = 0;
		for(Iterator<Action> it = comm.getActions().iterator(); it.hasNext(); ) {
			Action a = it.next();
			totalDocs = totalDocs + a.getDocs().size();
		}
		
		System.out.println("Total docs:" + totalDocs);
		return new ResponseEntity<String>("Todo OK - datos obtenidos",HttpStatus.OK);
	}
	
	@RequestMapping(value="/editAction", method=RequestMethod.GET)
	public ResponseEntity<String> editAction() {
		commService.editAction();
		return new ResponseEntity<String>("Todo OK - datos modificados",HttpStatus.OK);
	}
	
	@RequestMapping(value="/addAction", method=RequestMethod.GET)
	public ResponseEntity<String> addActionDetails() {
		commService.addActions();
		return new ResponseEntity<String>("Todo OK",HttpStatus.OK);
	}
	
	@RequestMapping(value="/addComm", method=RequestMethod.GET)
	public ResponseEntity<String> addComm() {
		commService.addComm();
		return new ResponseEntity<String>("Todo OK",HttpStatus.OK);
	}

}
