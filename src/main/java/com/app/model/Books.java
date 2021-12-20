package com.app.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author kulashekar
 *
 */
@Entity
@Table
public class Books implements Comparable<Books> {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String author;
    private LocalDate releasedate;
    private String publisher;
    private int numberofpages;
    private double price;
    

    public Books() {
        super();
    }


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public LocalDate getReleasedate() {
		return releasedate;
	}


	public void setReleasedate(LocalDate releasedate) {
		this.releasedate = releasedate;
	}


	public String getPublisher() {
		return publisher;
	}


	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}


	public int getNumberofpages() {
		return numberofpages;
	}


	public void setNumberofpages(int numberofpages) {
		this.numberofpages = numberofpages;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public Books(int id, String name, String author, LocalDate releasedate, String publisher, int numberofpages,
			double price) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.releasedate = releasedate;
		this.publisher = publisher;
		this.numberofpages = numberofpages;
		this.price = price;
	}


	@Override
	public String toString() {
		return "Books [id=" + id + ", name=" + name + ", author=" + author + ", releasedate=" + releasedate
				+ ", publisher=" + publisher + ", numberofpages=" + numberofpages + ", price=" + price + "]";
	}


	@Override
	public int compareTo(Books o) {
	 
		return 0;
	}



	
	 }