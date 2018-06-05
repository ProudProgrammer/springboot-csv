package hu.gaborbalazs.practice.springboot.exception;

public enum ExceptionType {

	DATA_STORE_CORRUPT("Data store corrupt or not found");

	private String exceptionMessage;

	private ExceptionType(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

	public String getExceptionMessage() {
		return exceptionMessage;
	}
}
 