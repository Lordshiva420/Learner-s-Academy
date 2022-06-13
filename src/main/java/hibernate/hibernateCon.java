package hibernate;

import javax.persistence.EntityTransaction;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class hibernateCon {

	      static Transaction tx = null;
	     static SessionFactory factory;
		
		public static SessionFactory getfactory() {
			
			AnnotationConfiguration cfg = new AnnotationConfiguration();
			cfg = (AnnotationConfiguration)cfg.configure();
			factory = cfg.buildSessionFactory();
			
			return factory;
			
		}

	

}
