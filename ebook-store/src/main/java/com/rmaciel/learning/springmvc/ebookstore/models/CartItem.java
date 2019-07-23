package com.rmaciel.learning.springmvc.ebookstore.models;

import java.math.BigDecimal;

public class CartItem {
	private Ebook ebook;
	private TypePrice typePrice;
	
	public CartItem(Ebook ebook, TypePrice typePrice) {
		this.ebook = ebook;
		this.typePrice = typePrice;
	}
	
	public BigDecimal getPrice() {
		return this.ebook.priceTo(this.typePrice);
	}
	
	public BigDecimal getTotal(int quantity) {
		return this.getPrice().multiply(new BigDecimal(quantity));
	}

	public Ebook getEbook() {
		return ebook;
	}

	public void setEbook(Ebook ebook) {
		this.ebook = ebook;
	}

	public TypePrice getTypePrice() {
		return typePrice;
	}

	public void setTypePrice(TypePrice typePrice) {
		this.typePrice = typePrice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ebook == null) ? 0 : ebook.hashCode());
		result = prime * result + ((typePrice == null) ? 0 : typePrice.hashCode());
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
		CartItem other = (CartItem) obj;
		if (ebook == null) {
			if (other.ebook != null)
				return false;
		} else if (!ebook.equals(other.ebook))
			return false;
		if (typePrice != other.typePrice)
			return false;
		return true;
	}
	
	
	
	
	
		
}
