package com.cg.ecommerce.web;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ecommerce.dto.EcomerceMessage;
import com.cg.ecommerce.dto.EcommErrorInfo;
import com.cg.ecommerce.exceptions.NoCartException;
import com.cg.ecommerce.exceptions.NoOrderException;
import com.cg.ecommerce.exceptions.NoProductException;
import com.cg.ecommerce.exceptions.NoReviewException;

@RestController
public class EcomerceExceptionAdvice {
   Logger logger = LoggerFactory.getLogger(EcomerceExceptionAdvice.class);
   
	@ExceptionHandler({NoCartException.class, NoOrderException.class, NoProductException.class, NoReviewException.class})
	@ResponseStatus(code=HttpStatus.NOT_FOUND)
	public EcommErrorInfo handleExcveption(Exception ex) {
		logger.error(ex.getMessage());
		return new EcommErrorInfo (ex.getMessage());
	}
}
