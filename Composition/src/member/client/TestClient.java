package member.client;

import member.dao.MemberDAO;
import member.dao.SessionUtil;
import member.model.Address;
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
    Member member = new Member("msmith");

    Address address = new Address();
    address.setStreet("543 Elm Street");
    address.setCity("Nowheresville");
    address.setState("IA");
    address.setZipCode("99999");
    address.setCountry("USA");

    member.setAddress(address);
    member.setEmail("mary.smith@work.com");

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
