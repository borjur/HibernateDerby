package member.dao;

import member.model.DVD;
import member.model.Loan;
import member.model.Member;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.Session;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.List;


public class MemberDAO {
  private static final Log log = LogFactory.getLog(MemberDAO.class);

  public void addMember(Member member) {
    Session session = SessionUtil.sessionFactory.getCurrentSession();
    Transaction tx = session.beginTransaction();
    session.save(member);
    tx.commit();
  }

  public List getAllMembers() {
    Session session = SessionUtil.sessionFactory.getCurrentSession();
    Transaction tx = session.beginTransaction();
    List result = session.createQuery("From Member").list();
    tx.commit();
    return result;
  }

  public Member getMember(String username) {
    Session session = SessionUtil.sessionFactory.getCurrentSession();
    Transaction tx = session.beginTransaction();
    Query query = session.createQuery("From Member m left join fetch m.addresses left join fetch m.reviews where m.username = :username");
    query.setString("username", username);
    Member member = (Member) query.uniqueResult();
    tx.commit();
    return member;

  }

  public DVD getDVD(String title) {
    Session session = SessionUtil.sessionFactory.getCurrentSession();
    Transaction tx = session.beginTransaction();
    Query query = session.createQuery("From DVD d where d.title = :title");
    query.setString("title", title);
    DVD dvd = (DVD) query.uniqueResult();
    tx.commit();
    return dvd;
  }

  public void addLoan(Loan loan) {
    Session session = SessionUtil.sessionFactory.getCurrentSession();
    Transaction tx = session.beginTransaction();
    session.saveOrUpdate(loan);
    tx.commit();
  }

  public void returnLoan(Loan loan) {
    Session session = SessionUtil.sessionFactory.getCurrentSession();
    Transaction tx = session.beginTransaction();
    session.delete(loan);
    tx.commit();

  }

}

