package hu.gaborbalazs.practice.springboot.exception;

public class ExceptionResponse {

	private ExceptionType exceptionType;

	public ExceptionResponse(ExceptionType exceptionType) {
		this.exceptionType = exceptionType;
	}

	public ExceptionType getExceptionType() {
		return exceptionType;
	}

	public void setExceptionType(ExceptionType exceptionType) {
		this.exceptionType = exceptionType;
	}
}
