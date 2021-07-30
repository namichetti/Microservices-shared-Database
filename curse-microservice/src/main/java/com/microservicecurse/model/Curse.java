package com.microservicecurse.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.commonexams.model.Exam;
import org.hibernate.annotations.CreationTimestamp;
import com.springboot.app.model.Student;

import lombok.Data;

@Data
@Entity
@Table(name="curses")
public class Curse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@Column(name="create_at")
	@CreationTimestamp
	private LocalDate createAt;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "curse_id")
	private List<Student> students;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name			      = "curse_exam", 
			   joinColumns 	      = @JoinColumn(name="curse_id"),
			   inverseJoinColumns = @JoinColumn(name="exam_id"))
	private List<Exam> exams;
	
	public Curse() {
		this.students = new ArrayList<>();
		this.exams = new ArrayList<>();
	}
}
