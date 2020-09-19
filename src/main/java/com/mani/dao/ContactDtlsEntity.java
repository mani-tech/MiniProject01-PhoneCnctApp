package com.mani.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="contact_info")
public class ContactDtlsEntity {
	@Id
	@GeneratedValue
	@Column(name="contact_id")
	private Integer cid;
	@Column(name="contact_name")
	private String name;
	@Column(name="contact_email")
	private String email;
	@Column(name="contact_phnNo")
	private long phoneNo;

}
