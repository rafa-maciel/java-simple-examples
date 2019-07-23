package com.rmaciel.learning.springmvc.ebookstore.models;

import java.math.BigDecimal;

public class PaymentData {
	private BigDecimal value;

	public PaymentData(BigDecimal value) {
		this.value = value;
	}
	
	public BigDecimal getValue() {
		return value;
	}
}

