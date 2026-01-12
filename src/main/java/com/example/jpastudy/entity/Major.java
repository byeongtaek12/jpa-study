package com.example.jpastudy.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "MAJOR_TB")
public class Major {

	@Id
	@GeneratedValue
	private Long majorId;

	private String name;

	private String category;

	@OneToMany
	@JoinColumn(name = "major_id")
	private List<Student> students = new ArrayList<>();

	public Major(String name, String category) {
		this.name = name;
		this.category = category;
	}
}
