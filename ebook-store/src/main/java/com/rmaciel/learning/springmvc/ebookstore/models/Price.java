package com.rmaciel.learning.springmvc.ebookstore.models;

import java.math.BigDecimal;

import javax.persistence.Embeddable;

@Embeddable
public class Price {

	private BigDecimal value;
	private TypePrice type;
	
	public BigDecimal getValue() {
		return value;
	}
	public TypePrice getType() {
		return type;
	}
	public void setValue(BigDecimal value) {
		this.value = value;
	}
	public void setType(TypePrice type) {
		this.type = type;
	}
	
	
}
