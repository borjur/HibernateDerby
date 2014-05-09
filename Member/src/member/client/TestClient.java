package member.client;

import member.dao.MemberDAO;
import member.dao.SessionUtil;
import member.model.Member;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Iterator;
import java.util.List;


public class TestClient {
  private static final Log log = LogFactory.getLog(TestClient.class);

  public static void main(String[] args) {
    log.info("Starting the Member Test Client");

    log.info("Constructing a new Member");
    Member member = new Member("bjones");
    member.setEmail("billy.jones@work.com");
    member.setStreet("987 Maple Street");
    member.setCity("Anytown");
	member.setState("ID");
    member.setZipCode("12333");
    member.setCountry("USA");

    log.info("Adding member to DAO");
    MemberDAO dao = new MemberDAO();
    dao.addMember(member);

    log.info("Listing all members");
    List list = dao.getAllMembers();

    Iterator iter = list.iterator();
    while (iter.hasNext()) {
      log.info(iter.next());
    }
  }
}
