package hibernate;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ListStudents")
public class ListStudents {
	
	


		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name="Sid")
		private int Sid;
		
		@Column(name="Sname")
		private String Sname;
		
		@Column(name="email")
		private String email;
		
		@Column(name="phone")
		private Long phone;
		
		@ManyToOne
		
		ListClasses ListClasses;

		//constructors//
		public ListStudents() {
			super();
			
		}
		
		public ListStudents(String sname, String email, long phone) {
			super();
			Sname = sname;
			this.email = email;
			this.phone = phone;
		}
        
		//getters and setters//

		public int getSid() {
			return Sid;
		}


		public void setSid(int sid) {
			Sid = sid;
		}


		public String getSname() {
			return Sname;
		}


		public void setSname(String sname) {
			Sname = sname;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		public Long getPhone() {
			return phone;
		}


		public void setPhone(Long phone) {
			this.phone = phone;
		}

		public ListClasses getListClasses() {
			return ListClasses;
		}

		public void setListClasses(ListClasses listClasses) {
			ListClasses = listClasses;
		}

		
		
		
		
		
		

}
