package com.cnsz.bootstrapping.model;

import java.io.Serializable;
import java.util.Objects;

public class RelActionDocsPK implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long idAction;
	private Long idDocument;
	
	public RelActionDocsPK() {
	}
	
	public RelActionDocsPK(Long idAction, Long idDocument) {
		this.idAction = idAction;
		this.idDocument = idDocument;
	}

	@Override
	 public int hashCode() {
	  int hash = 5;
	  hash = 83 * hash + this.idAction.hashCode();
	  hash = 83 * hash + Objects.hashCode(this.idDocument);
	  return hash;
	 }
	 
	 @Override
	 public boolean equals(Object obj) {
	  if (obj == null) {
	   return false;
	  }
	  if (getClass() != obj.getClass()) {
	   return false;
	  }
	  final RelActionDocsPK other = (RelActionDocsPK) obj;
	  if (this.idAction != other.idAction) {
	   return false;
	  }
	  if (!Objects.equals(this.idDocument, other.idDocument)) {
	   return false;
	  }
	  return true;
	 } 
	
}
