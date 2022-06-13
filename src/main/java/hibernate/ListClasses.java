package hibernate;

import java.util.List;
import java.util.Set;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="ListClasses")
public class ListClasses {
	//variables//
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="cid")	
		private int cid;

	@Column(name="cname")
		private String cname;
	
	//classes to student mapping//
	@OneToMany(cascade= CascadeType.ALL, mappedBy="ListClasses")
	@LazyCollection(LazyCollectionOption.FALSE)
	List<ListStudents> ListStudents;
	
	// Classes to subject mapping //
	@OneToMany(cascade= CascadeType.ALL,mappedBy="ListClasses")
	@LazyCollection(LazyCollectionOption.FALSE)
	List<ListSubjects> ListSubjects;
	
	//classes to teachers mapping//

	@OneToMany(cascade= CascadeType.ALL,mappedBy="ListClasses")
	@LazyCollection(LazyCollectionOption.FALSE)
	List<ListTeachers> ListTeachers;
	 
	//construtors//

	public ListClasses() {
		super();
	}
	
	
	public ListClasses(String cname) {
		super();
		this.cname = cname;
	}

	public ListClasses(int cid, String cname) {
		super();
		this.cid = cid;
		this.cname = cname;
	}
	
	//getters and setters//
	
	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

//student setters and getters//

	public List<ListStudents> getListStudents() {
		return ListStudents;
	}


	public void SetListStudents(List<ListStudents> stu) {
		ListStudents=stu;
	}

//subject getters and setters//
	public List<ListSubjects> getListSubjects() {
		return ListSubjects;
	}


	public void setListSubjects(List<ListSubjects> listSubjects) {
		ListSubjects = listSubjects;
	}


//teacher getters and setters//
	public List<ListTeachers> getListTeachers() {
		return ListTeachers;
	}


	public void setListTeachers(List<ListTeachers> listTeachers) {
		ListTeachers = listTeachers;
	}
	


	


	@Override
	public String toString() {
		return "ListClasses [cid=" + cid + ", cname=" + cname + ", ListStudents=" + ListStudents + ", ListSubjects="
				+ ListSubjects + ", ListTeachers=" + ListTeachers + "]";
	}


	
	
	
}
