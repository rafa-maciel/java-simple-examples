package com.rmaciel.learning.springmvc.ebookstore.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value=WebApplicationContext.SCOPE_SESSION)
public class Cart implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Map<CartItem, Integer> items = new LinkedHashMap<CartItem, Integer>();
	
	public void add(CartItem item) {
		items.put(item, getSize(item) + 1);
	}

	public int getSize(CartItem item) {
		if (!items.containsKey(item)) {
			items.put(item, 0);
		}
		return items.get(item);
	}
	
	public int getSize() {
		return items.values().stream().reduce(0, (next, sum) -> next + sum);
	}
	
	public Collection<CartItem> getItems() {
		return this.items.keySet();
	}
	
	public BigDecimal getTotal(CartItem item) {
		return item.getTotal(getSize(item));
	}
	
	public BigDecimal getTotal() {
		BigDecimal total = BigDecimal.ZERO;
		
		for (CartItem item : this.items.keySet()) {
			total = total.add(this.getTotal(item));
		}
		
		return total;
	}

	public void remove(Ebook ebook, TypePrice typePrice) {
		CartItem item = new CartItem(ebook, typePrice);
		this.items.remove(item);
	}
}
