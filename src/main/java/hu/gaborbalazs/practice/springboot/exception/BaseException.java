package hu.gaborbalazs.practice.springboot.exception;

@SuppressWarnings("serial")
public class BaseException extends RuntimeException {

	private ExceptionType exceptionType;

	public BaseException(ExceptionType exceptionType) {
		super(exceptionType.getExceptionMessage());
		this.exceptionType = exceptionType;
	}

	public ExceptionType getExceptionType() {
		return exceptionType;
	}

}
