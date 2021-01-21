package error_old;

public class ToyotaException extends RuntimeException {

	private final String errorMessage = "I love Toyotas";

	public String getErrorMessage() {
		return errorMessage;
	}
}
