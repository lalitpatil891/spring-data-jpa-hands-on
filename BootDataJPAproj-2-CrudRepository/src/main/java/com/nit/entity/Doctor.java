//Doctor.javas
package com.nit.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="JPA_DOCTOR_INFO")
@Data
public class Doctor {
	
	@Column(name="DOC_ID")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer docid;
	
	@Column(name="DOC_NAME", length=30)
	private String docName;
	
	@Column(name="SPECIALIZATION", length=20)
	private String specialization;
	
	@Column(name="INCOME")
	private double income;

	public Doctor() {
		
	};
	
	public Doctor( String docName, String specialization, double income) {
		super();
//		.this.docid = docid;
		this.docName = docName;
		this.specialization = specialization;
		this.income = income;
	}	
	
}
