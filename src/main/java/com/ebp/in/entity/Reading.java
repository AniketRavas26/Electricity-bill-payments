package com.ebp.in.entity;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Reading {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long readingId;

	private Double unitsConsumed;
	private String readingPhoto;
	private Date readingDate;
	private Double pricePerUnits;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "connection_id_fk", referencedColumnName = "connectionId", nullable = true)
	//@JsonIgnore
	private Connection readingForConnection;
	
	private Long connectionId;

	

}