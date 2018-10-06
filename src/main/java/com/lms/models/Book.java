package com.lms.models;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "lms_tbl")
public class Book {
	
	@Id
	//Quan s'inserti un nou book object aquest valor es generara automaticament
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "book_name")
	private String bookName;
	
	//Si el nom de l'atribut coincideix amb el de la columna no cal l'annotation
	private String author;
	
	@Column(name = "purchase_date")
	@Temporal(TemporalType.DATE)
	private Date purchaseDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	
	
	
	

}
