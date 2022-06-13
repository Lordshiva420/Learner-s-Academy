package hibernate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class saveSubjectsDB {

	public static void subjectInsert(String subname) {
            
		     Transaction tx=null;
		    ArrayList<ListSubjects> sublist=null;
		try {
			
			SessionFactory factory = hibernateCon.getfactory();
			Session session = factory.openSession();
			 tx = session.beginTransaction();
			
			
			 
			 ListSubjects sub1=new ListSubjects(subname);
			session.save(sub1);
			
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
	
	public static ArrayList<ListSubjects>  subjectDisplay() {
        
	     Transaction tx=null;
	    ArrayList<ListSubjects> sublist=null;
	try {
		
		SessionFactory factory = hibernateCon.getfactory();
		Session session = factory.openSession();
		 tx = session.beginTransaction();
		
		sublist = (ArrayList<ListSubjects>) session.createCriteria(ListSubjects.class).list();
		
		
		tx.commit();
		session.close();
	   }
	catch (Exception e) {
		e.printStackTrace();
		if (tx != null) {
			tx.rollback();
		}
	}
	return sublist;

}



	}


