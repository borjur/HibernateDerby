package member.exception;




public class UnavailableDVDException extends LoanException {

  public UnavailableDVDException() {
  }

  public UnavailableDVDException(String message) {
    super(message);
  }

  public UnavailableDVDException(String message, Throwable cause) {
    super(message, cause);
  }

  public UnavailableDVDException(Throwable cause) {
    super(cause);
  }

}