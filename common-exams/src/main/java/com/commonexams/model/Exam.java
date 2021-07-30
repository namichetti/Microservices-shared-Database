package com.commonexams.model;

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@Table(name="exams")
public class Exam {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@CreationTimestamp
	@Column(name="create_at",nullable = false, updatable = false)
	private LocalDate createAt;
	
	@OneToMany(mappedBy="exam",cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	List<Question> questions;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="subject_id")
	private Subject subject;
	
	public Exam(){
		this.questions = new ArrayList<>();
	}
	
	public void setQuestions(List<Question> questions) {
		this.questions.clear();
		questions.forEach(question-> this.addQuestion(question));
	}

	private void addQuestion(Question question) {
		question.setExam(this);
		this.questions.add(question);
	}
}
