package hu.gaborbalazs.practice.springboot.aspect;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import hu.gaborbalazs.practice.springboot.exception.BaseException;
import hu.gaborbalazs.practice.springboot.exception.ExceptionResponse;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	@ExceptionHandler(BaseException.class)
	public ExceptionResponse handleTestException(RuntimeException ex, WebRequest request) {
		return new ExceptionResponse(ex.getMessage());
	}
}
