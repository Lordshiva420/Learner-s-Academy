package hibernate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class saveTeachersDB {

	public static void teacherInsert(String Tname) {
        
	     Transaction tx=null;
	    ArrayList<ListTeachers> tealist=null;
	try {
		
		SessionFactory factory = hibernateCon.getfactory();
		Session session = factory.openSession();
		 tx = session.beginTransaction();
	
		 ListTeachers tea1=new ListTeachers(Tname);
		session.save(tea1);
		
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

public static ArrayList<ListTeachers>  teacherDisplay() {
   
    Transaction tx=null;
   ArrayList<ListTeachers> tealist=null;
try {
	
	SessionFactory factory = hibernateCon.getfactory();
	Session session = factory.openSession();
	 tx = session.beginTransaction();
	
	tealist = (ArrayList<ListTeachers>) session.createCriteria(ListTeachers.class).list();
	
	
	tx.commit();
	session.close();
  }
catch (Exception e) {
	e.printStackTrace();
	if (tx != null) {
		tx.rollback();
	}
}
return tealist;

}




}
