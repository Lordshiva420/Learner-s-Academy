package hibernate;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


@Entity
@Table(name="ListTeachers")
public class ListTeachers {
	
	//variables//
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Tid")
	private int Tid;
	
	@Column(name="tname")
	private String tname;
	
	@ManyToOne
	@JoinColumn(name="classid")
	ListClasses ListClasses;
	
	//teacher to subject mapping//
	@OneToMany(cascade= CascadeType.ALL,mappedBy="ListTeachers")
	@LazyCollection(LazyCollectionOption.FALSE)
	List<ListSubjects> ListSubjects;
	
	
   //constructors//
	
	public ListTeachers() {
		super();
	}
	
	public ListTeachers(String tname) {
		super();
		this.tname = tname;
	}

	public ListTeachers(int tid, String tname) {
		super();
		Tid = tid;
		this.tname = tname;
	}
	
     //getters and setters//
	
	public int getTid() {
		return Tid;
	}

	public void setTid(int tid) {
		Tid = tid;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	

	public ListClasses getListClasses() {
		return ListClasses;
	}

	public void setListClasses(ListClasses listClasses) {
		ListClasses = listClasses;
	}

	public List<ListSubjects> getListSubjects() {
		return ListSubjects;
	}

	public void setListSubjects(List<ListSubjects> listSubjects) {
		ListSubjects = listSubjects;
	}


	
	
	
	
	
	
}
