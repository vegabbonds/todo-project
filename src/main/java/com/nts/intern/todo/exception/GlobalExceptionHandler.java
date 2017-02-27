package com.nts.intern.todo.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.nts.intern.todo.message.ErrorMessage;

@ControllerAdvice
@Controller
public class GlobalExceptionHandler {

	final static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = DuplicateKeyException.class)
	public String handleDuplicateKeyException(DuplicateKeyException e, Model model) {
		logger.info("DuplicateKeyException");
		model.addAttribute("errorMessage", ErrorMessage.DUPLICATED_KEY_EXCEPTION.getMessage());
		return "errorPage";
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = RuntimeException.class)
	public String handleRuntimeException(RuntimeException e, Model model) {
		logger.info("RuntimeException");
		model.addAttribute("errorMessage", ErrorMessage.RUNTIME_EXCEPTION.getMessage());
		return "errorPage";
	}
}