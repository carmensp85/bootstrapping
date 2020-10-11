package com.cnsz.bootstrapping.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Action implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue
	private Long idAction;
	
	private String description;
	
	private String channel;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Communication comm;
	
	@OneToMany(mappedBy="idAction", cascade = CascadeType.ALL)
	private List<RelActionDocs> docs = new ArrayList<>();

	public Long getIdAction() {
		return idAction;
	}

	public void setIdAction(Long idAction) {
		this.idAction = idAction;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}
	
	public List<RelActionDocs> getDocs() {
		return docs;
	}

	public void setDocs(List<RelActionDocs> docs) {
		this.docs = docs;
	}

	public void addDocument(Document doc) {
		RelActionDocs rel = new RelActionDocs(this,doc);
		docs.add(rel);
		//doc.getActions().add(rel);
	}
	
	public void removeDocument(Document doc) {
		for (Iterator<RelActionDocs> iterator = docs.iterator();
	             iterator.hasNext(); ) {
			RelActionDocs rel = iterator.next();
            if (rel.getIdAction().equals(this) &&
            		rel.getIdDocument().equals(doc)) {
                iterator.remove();
                //rel.getIdDocument().getActions().remove(doc);
                rel.setIdAction(null);
                rel.setIdDocument(null);
            }
	        }
	}
	
	public Communication getComm() {
		return comm;
	}

	public void setComm(Communication comm) {
		this.comm = comm;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Action act = (Action) o;
		return Objects.equals(idAction, act.idAction);
	}

	@Override
	public int hashCode() {
		return Objects.hash(idAction);
	}

	@Override
	public String toString() {
		return "Action [idAction=" + idAction + ", description=" + description
				+ ", channel=" + channel + ", docs=" + docs + "]";
	}
	
	
	
}
