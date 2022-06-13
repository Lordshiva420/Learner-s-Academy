package hibernate;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ListSubjects")
public class ListSubjects {
	      //variables//
	
			@Id
			@GeneratedValue(strategy=GenerationType.AUTO)
			@Column(name="Subid")
			private int Subid;
			
			@Column(name="Subname")
			private String Subname;
			
			@ManyToOne
			ListClasses ListClasses;


			@ManyToOne
			
			ListTeachers ListTeachers ;
			
			public ListSubjects(String subname) {
				super();
				Subname = subname;
				
			}
			
			
			public ListSubjects() {
				super();
			}

			public ListSubjects(int subid, String subname) {
				super();
				Subid = subid;
				Subname = subname;
			}

			
			//getters and setters //
			

			
			public int getSubid() {
				return Subid;
			}

			public void setSubid(int subid) {
				Subid = subid;
			}

			public String getSubname() {
				return Subname;
			}

			public void setSubname(String subname) {
				Subname = subname;
			}


		




			



			public ListClasses getListClasses() {
				return ListClasses;
			}


			public void setListClasses(ListClasses listClasses) {
				ListClasses = listClasses;
			}


			public ListTeachers getListTeachers() {
				return ListTeachers;
			}


			public void setListTeachers(ListTeachers listTeachers) {
				ListTeachers = listTeachers;
			}
			
			
			
	
			
			
			
			
}
