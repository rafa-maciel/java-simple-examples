package com.rmaciel.learning.springmvc.ebookstore.models;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Ebook {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String title;
	private String description;
	private int pages;
	
	@ElementCollection
	private List<Price> prices;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Calendar publicationDate;
	
	private String summaryPath;
	
	public BigDecimal priceTo(TypePrice type) {
		return prices.stream().filter(price -> price.getType().equals(type)).findFirst().get().getValue();
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public int getPages() {
		return pages;
	}

	public List<Price> getPrices() {
		return prices;
	}
	
	public Calendar getPublicationDate() {
		return publicationDate;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setPrices(List<Price> prices) {
		this.prices = prices;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}
	
	public void setPublicationDate(Calendar publicationDate) {
		this.publicationDate = publicationDate;
	}

	public String getSummaryPath() {
		return summaryPath;
	}

	public void setSummaryPath(String summaryPath) {
		this.summaryPath = summaryPath;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ebook other = (Ebook) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
	
	
	
	
}
