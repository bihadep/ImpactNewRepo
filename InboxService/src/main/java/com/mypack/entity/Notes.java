package com.mypack.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "notes_tb")
public class Notes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String notes;
	private String fromEmployeeId;
	private Long fromId;
	private String toEmployeeId;
	private Long toId;
	private boolean isReply;
	private String reply;
	@Column(updatable = false)
	private Date createdDate = new Date();
	private Date updatedDate;

}
