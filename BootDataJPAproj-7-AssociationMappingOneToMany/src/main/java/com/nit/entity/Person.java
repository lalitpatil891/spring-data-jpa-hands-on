package com.nit.entity;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="JPA_OTM_PERSON")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Person implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pid;
	
	@NonNull
	@Column(length = 20)
	private String pname;
	
	@NonNull
	@Column(length= 20)
	private String city;
	
	//One person can have many PhoneNumbers
	@OneToMany(targetEntity = PhoneNumber.class, cascade = CascadeType.ALL, mappedBy ="personInfo")
	private Set<PhoneNumber> contactDetails;

	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", city=" + city + "]";
	}
	
	
	
}
