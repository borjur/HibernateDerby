package member.client;

import member.dao.BorrowingController;
import member.dao.MemberDAO;
import member.dao.SessionUtil;
import member.exception.LoanException;
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

    MemberDAO dao = new MemberDAO();

    Member john = dao.getMember("jdoe");
    Member sally = dao.getMember("ssmith");

    try {
      BorrowingController.addLoan(john, "Star Wars");
      BorrowingController.addLoan(john, "Stagecoach");
      log.info("Step 1: John borrowed Star Wars and Stagecoach");
    }
    catch (LoanException e) {
      log.error(e); // unexpected
      System.exit(0);
    }

    try {
      BorrowingController.addLoan(sally, "Star Wars");
      log.info("Step 2: Sally borrowed Star Wars");
    }
    catch (LoanException e) {
      // expected
      log.info("Step 2: Sally's loan on Star Wars failed: " + e.getMessage());
    }

    try {
      BorrowingController.addLoan(john, "Jungle Book");
      log.info("Step 3: John borrowed Jungle Book");
    }
    catch (LoanException e) {
      // expected
      log.info("Step 3: John's loan on Jungle Book failed: " + e.getMessage());
    }

    try {
      BorrowingController.returnLoan(john, "Star Wars");
      log.info("Step 4: John returned Star Wars.");
    }
    catch (LoanException e) {
      log.error(e); // unexpected
      System.exit(0);
    }

    try {
      BorrowingController.addLoan(sally, "Star Wars");
      log.info("Step 5: Sally borrowed Star Wars");
    }
    catch (LoanException e) {
      log.error(e); // unexpected
      System.exit(0);
    }

  }
}