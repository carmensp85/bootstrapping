package com.cnsz.bootstrapping.model;

import java.io.Serializable;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Document implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@GeneratedValue
	@Id
	private Long idDocument;
	
	private String name;
	
	@Column(columnDefinition = "BLOB")
	@Basic(fetch=FetchType.LAZY)
	@Lob
	private byte[] contents;
	
	//@OneToMany(mappedBy="idDocument", cascade = CascadeType.ALL)
	//private List<RelActionDocs> actions = new ArrayList<>();

	public Long getIdDocument() {
		return idDocument;
	}

	public void setIdDocument(Long idDocument) {
		this.idDocument = idDocument;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getContents() {
		return contents;
	}

	public void setContents(byte[] contents) {
		this.contents = contents;
	}
	
	/*public List<RelActionDocs> getActions() {
		return actions;
	}

	public void setActions(List<RelActionDocs> actions) {
		this.actions = actions;
	}
	
	public void addAction(Action action) {
		RelActionDocs rel = new RelActionDocs(action,this);
		actions.add(rel);
		action.getDocs().add(rel);
	}*/
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Document doc = (Document) o;
        return Objects.equals(idDocument, doc.idDocument);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(idDocument);
    }

	@Override
	public String toString() {
		return "Document [idDocument=" + idDocument + ", name=" + name + "]";
	}
    
    
}
