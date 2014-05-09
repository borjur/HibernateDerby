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

    Member member;
    MemberDAO dao = new MemberDAO();

    member = dao.getMember("tjohnson");

    if (member == null) {
        log.info("Constructing a new Member");
      member = new Member("tjohnson");

      Address homeAddress = new Address();
      homeAddress.setStreet("111 Red Oak Drive");
      homeAddress.setCity("Smallville");
      homeAddress.setState("WI");
      homeAddress.setZipCode("77777");
      homeAddress.setCountry("USA");

      Address workAddress = new Address();
      workAddress.setStreet("555 Big Company Drive");
      workAddress.setCity("Smallville");
      workAddress.setState("WI");
      workAddress.setZipCode("77777");
      workAddress.setCountry("USA");


      member.addAddress("Home", homeAddress);
      member.addAddress("Work", workAddress);

      member.addReview("Great service, keep on the good work!");
      member.addReview("Took a long time before they had my favorite movie");

      member.setEmail("tom.johnson@work.com");

      log.info("Adding member to DAO");
      dao.addMember(member);
    }

    log.info("Listing a member");
    member = dao.getMember("tjohnson");

    log.info(member);
  }
}
