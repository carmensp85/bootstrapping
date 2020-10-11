package com.cnsz.bootstrapping.dao;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import java.util.Iterator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.cnsz.bootstrapping.model.Action;
import com.cnsz.bootstrapping.model.Communication;
import com.cnsz.bootstrapping.model.Document;
import com.cnsz.bootstrapping.model.RelActionDocs;

@Repository
public class ActionDAOImpl implements ActionDAO {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Action getActionDetails() {
		Action act = em.find(Action.class, new Long(2));
		return act;
	}

	@Override
	public Action addAction() {
		Communication c = em.find(Communication.class, new Long(1));
		
		File f1 = new File("/Users/misanmez/Documents/MA_renta_2018.PDF");
		File f2 = new File("/Users/misanmez/Documents/AYUDAS_COMEDOR_DAVID.pdf");
		File f3 = new File("/Users/misanmez/Documents/JJ_RENTA_2019.pdf");
		
		Action a1 = new Action();
		a1.setChannel("canal de prueba");
		a1.setDescription("Descripción de acción");
		
		Document d1 = new Document();
		Document d2 = new Document();
		try {
			d1.setContents(Files.readAllBytes(f1.toPath()));
			d1.setName(f1.getName());
			d2.setContents(Files.readAllBytes(f2.toPath()));
			d2.setName(f2.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		a1.addDocument(d1);
		a1.addDocument(d2);
		a1.setComm(c);
		
		em.persist(a1);
		return a1;
	}

	@Override
	public void editAction() {
		Action act = em.find(Action.class, new Long(2));
		act.setDescription("cambio la desccc");
		//act.getDocs().get(0).getIdDocument().setName("cambio el filename");
		
		Document d = em.getReference(Document.class, act.getDocs().get(1).getIdDocument().getIdDocument());
		d.setName("filename1111");
		em.persist(d);
		
		em.persist(act);
	}

	@Override
	public void addComm() {
		Communication c = new Communication();
		c.setDescription("Descripppp");
		c.setType("TIPO 1");
		em.persist(c);
		
	}

	@Override
	public Communication getCommDetails() {
		Communication c = em.find(Communication.class, new Long(1));
		return c;
	}

	

}
