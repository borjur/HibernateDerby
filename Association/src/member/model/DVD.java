package member.model;

import member.exception.UnavailableDVDException;




public class DVD {
  private Integer id;
  private String title;
  private double price;
  private Loan loan;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Loan getLoan() {
    return loan;
  }

  public void setLoan(Loan loan) throws UnavailableDVDException {
    if (this.loan != null) {
      if (this.loan.equals(loan))
        return;
      else
        throw new UnavailableDVDException(this.getTitle() + " is already borrowed to " + this.getLoan().getMember().getUsername());
    }
    this.loan = loan;
  }

  public void removeLoan() {
    this.loan = null;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }
}
