package com.boot.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Book {
	@Id
	@GeneratedValue
	private int id;
	
	private float price;
	@Column(name="published_date")
	private LocalDate publishdate;
	private String title;
	private String author;
	private String content;
	
	public Book(){
		
	}
	public Book(int id, float price, LocalDate publishdate, String title, String author, String content) {
		super();
		this.id = id;
		
		this.price = price;
		this.publishdate = publishdate;
		this.title = title;
		this.author = author;
		this.content = content;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public LocalDate getPublishdate() {
		return publishdate;
	}
	public void setPublishdate(LocalDate publishdate) {
		this.publishdate = publishdate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
