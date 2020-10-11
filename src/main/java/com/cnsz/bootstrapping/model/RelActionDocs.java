package com.cnsz.bootstrapping.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@IdClass(RelActionDocsPK.class)
public class RelActionDocs {

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name = "idAction", referencedColumnName="idAction")
	private Action idAction;
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idDocument", referencedColumnName="idDocument")
	private Document idDocument;

	public RelActionDocs() {
	}

	public RelActionDocs(Action idAction, Document idDocument) {
		super();
		this.idAction = idAction;
		this.idDocument = idDocument;
	}

	public Action getIdAction() {
		return idAction;
	}

	public void setIdAction(Action idAction) {
		this.idAction = idAction;
	}

	public Document getIdDocument() {
		return idDocument;
	}

	public void setIdDocument(Document idDocument) {
		this.idDocument = idDocument;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(idAction, idDocument);
	}
	 
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		RelActionDocs that = (RelActionDocs) o;
		return Objects.equals(idAction, that.idAction) && Objects.equals(idDocument, that.idDocument);
	}

	@Override
	public String toString() {
		return "RelActionDocs [idDocument=" + idDocument + "]";
	}
}
