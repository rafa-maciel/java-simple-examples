package com.rmaciel.learning.springmvc.ebookstore.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.rmaciel.learning.springmvc.ebookstore.models.Ebook;

public class EbookValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Ebook.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "title", "field.required");
		ValidationUtils.rejectIfEmpty(errors, "description", "field.required");
		
		Ebook ebook = (Ebook) target;
		
		if (ebook.getPages() <= 0) errors.rejectValue("pages", "field.required");
	}

}
