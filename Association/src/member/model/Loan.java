package member.model;

import java.util.Date;




public class Loan {
  private Integer id;
  private Date loanDate;
  private DVD dvd;
  private Member member;

  public DVD getDvd() {
    return dvd;
  }

  public void setDvd(DVD dvd) {
    this.dvd = dvd;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Date getLoanDate() {
    return loanDate;
  }

  public void setLoanDate(Date loanDate) {
    this.loanDate = loanDate;
  }

  public Member getMember() {
    return member;
  }

  public void setMember(Member member) {
    this.member = member;
  }
}
