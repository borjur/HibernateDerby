package member.dao;

import org.hibernate.cfg.ImprovedNamingStrategy;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;



public class SessionUtil {
  private static final Log log = LogFactory.getLog(SessionUtil.class);

  //todo complete this class

  public static final SessionFactory sessionFactory;

  static {
    try {
      // Create the SessionFactory from hibernate.cfg.xml

      Configuration configuration = new Configuration().configure();
      sessionFactory = configuration.buildSessionFactory();
    } catch (Throwable ex) {
      log.error("Initial SessionFactory creation failed." + ex);
      throw new ExceptionInInitializerError(ex);
    }
  }
}
