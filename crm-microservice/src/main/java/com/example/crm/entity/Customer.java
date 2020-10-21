package com.example.crm.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="customers")
public class Customer {
	@Id
	private String identity;
	private String fullname;
	private String sms;
	private String email;
	@Lob
	@Column(columnDefinition="longblob")
	private byte[] photo;
	private List<Address> addresses;
}
