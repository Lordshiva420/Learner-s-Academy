package hibernate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class saveStudentsDB {
	


	public static void studentInsert(String stuname,String stuemail, long stuphone) {
        
	     Transaction tx=null;
	    ArrayList<ListStudents> sublist=null;
	try {
		
		SessionFactory factory = hibernateCon.getfactory();
		Session session = factory.openSession();
		 tx = session.beginTransaction();
		
		
		 
		 ListStudents stu1=new ListStudents(stuname,stuemail,stuphone);
		session.save(stu1);
		
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

public static ArrayList< ListStudents>  studentDisplay() {
   
    Transaction tx=null;
   ArrayList<ListStudents> stulist=null;
try {
	
	SessionFactory factory = hibernateCon.getfactory();
	Session session = factory.openSession();
	 tx = session.beginTransaction();
	
	stulist = (ArrayList<ListStudents>) session.createCriteria(ListStudents.class).list();
	
	
	tx.commit();
	session.close();
  }
catch (Exception e) {
	e.printStackTrace();
	if (tx != null) {
		tx.rollback();
	}
}
return stulist;

}


	}


