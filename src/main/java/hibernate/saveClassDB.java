package hibernate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class saveClassDB {
	
	public static void classInsert(String cname) {
		
		Transaction tx=null;
	    ArrayList<ListClasses> clslist=null;
	try {
		
		SessionFactory factory = hibernateCon.getfactory();
		Session session = factory.openSession();
		 tx = session.beginTransaction();
		
		
		 
		 ListClasses cls1=new ListClasses(cname);
		session.save(cls1);
		
		tx.commit();
		session.close();
	   }
	catch (Exception e) {
		e.printStackTrace();
		if (tx != null) {
			tx.rollback();
		}
	   }
	}
	
	
	public static ArrayList<ListClasses>  classDisplay() {
        
	     Transaction tx=null;
	    ArrayList<ListClasses> clslist=null;
	try {
		
		SessionFactory factory = hibernateCon.getfactory();
		Session session = factory.openSession();
		 tx = session.beginTransaction();
		
		clslist = (ArrayList<ListClasses>) session.createCriteria(ListClasses.class).list();
		
		
		tx.commit();
		session.close();
	   }
	catch (Exception e) {
		e.printStackTrace();
		if (tx != null) {
			tx.rollback();
		}
	}
	return clslist;

}



}
