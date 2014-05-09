package member.exception;




public class TooManyLoansException extends LoanException {

  public TooManyLoansException() {
  }

  public TooManyLoansException(String message) {
    super(message);
  }

  public TooManyLoansException(String message, Throwable cause) {
    super(message, cause);
  }

  public TooManyLoansException(Throwable cause) {
    super(cause);
  }

}