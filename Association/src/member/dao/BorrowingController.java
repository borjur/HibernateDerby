package member.dao;

import java.util.Date;
import java.util.Iterator;

import member.exception.LoanException;
import member.model.DVD;
import member.model.Loan;
import member.model.Member;



public class BorrowingController {

  public static void addLoan(Member member, String title) throws LoanException {
    MemberDAO dao = new MemberDAO();
    DVD dvd = dao.getDVD(title);

    Loan loan = new Loan();
    loan.setLoanDate(new Date());
    loan.setDvd(dvd);
    loan.setMember(member);

    member.addLoan(loan);
    dvd.setLoan(loan);

    dao.addLoan(loan);
  }

  public static void returnLoan(Member member, String title) throws LoanException {
    MemberDAO dao = new MemberDAO();
    DVD dvd = dao.getDVD(title);

    Loan loan = dvd.getLoan();
    if (loan == null)
      throw new LoanException(title + " is not loaned out");
    member.removeLoan(loan);
    dvd.removeLoan();
    dao.returnLoan(loan);
  }

}
