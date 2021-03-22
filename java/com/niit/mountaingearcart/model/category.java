package com.niit.mountaingearcart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="category2")
@Data
public class category {

	@Id
	@GeneratedValue
	@Column(name = "category_id")
	@NotEmpty(message="Enter a valid category ID")
	private String category_id;
	@Column(name = "category_name")
	@NotEmpty(message="Enter a valid category name")
	private String category_name;
	

}
