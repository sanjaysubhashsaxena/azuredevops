package com.saxena.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Document(collection = "CUSTOMER_RECORDS")
public class Customer {
//	@Id
//	private Object id;
	@Field(name = "CUSTOMER_ID")
	private String custId;
	@Field(name = "NAME")
	private String name;
	@Field(name = "AMOUNT")
	private String amount;
	@Field(name = "CREATION_DATE")
	private Date creationDate;
	@Field(name = "MODIFIED_DATE")
	private Date modifiedDate;
}
