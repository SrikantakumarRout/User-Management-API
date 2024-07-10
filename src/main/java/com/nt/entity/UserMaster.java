package com.nt.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.Collate;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="JRTP_USER_MASTER")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserMaster {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer userId;
	@Column(length=20)
	private String name;
	@Column(length=20)
	private String password;
	@Column(length=40,unique = true,nullable = false)
	private String email;
	private Long mobileNo;
	private Long aadharNo;
	@Column(length=10)
	private String gender;
	private LocalDate dob;
	@Column(length=10)
	private String activeSw;
	
	//metaData
	@CreationTimestamp
	@Column(insertable=true,updatable=false)
	private LocalDateTime createdOn;
	@UpdateTimestamp
	@Column(insertable=false,updatable=true)
	private LocalDateTime updatedOn;
	@Column(length=20)
	private String createdBy;
	@Column(length=20)
	private String updatedBy;

}











