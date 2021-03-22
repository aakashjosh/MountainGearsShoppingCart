package com.niit.mountaingearcart.model;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.BatchSize;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;

@Entity
@BatchSize(size = 1)
@Table(name = "product3")
public class product {
	@Id
	@Column(name = "product_id")
	private String product_id;

	@Column(name = "product_name")
	@NotEmpty(message="Please enter a product name")
	private String product_name;

	@Column(name = "category")
	@NotEmpty(message="Please enter category")
	private String category;

	@Column(name = "supplier_id")
	@NotEmpty(message="Please enter Supplier Id")
	private String supplier_id;

	@Column(name = "product_description")
	@NotEmpty(message="Please enter product description")
	private String product_description;

	@Column(name = "product_price")
	@NotNull(message="Please enter product Price")
	private int product_price;

	@Column(name = "product_discount")
	@NotNull(message="Please enter product Discount")
	private int product_discount;

	@Column(name = "product_image")
	private String product_image;

	transient private MultipartFile product_file;

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSupplier_id() {
		return supplier_id;
	}

	public void setSupplier_id(String supplier_id) {
		this.supplier_id = supplier_id;
	}

	public String getProduct_description() {
		return product_description;
	}

	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}

	public int getProduct_price() {
		return product_price;
	}

	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}

	public int getProduct_discount() {
		return product_discount;
	}

	public void setProduct_discount(int product_discount) {
		this.product_discount = product_discount;
	}

	public String getProduct_image() {
		return product_image;
	}

	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}

	public MultipartFile getProduct_file() {
		return product_file;
	}

	public void setProduct_file(MultipartFile product_file) {
		this.product_file = product_file;
	}
	public String getFilePath(String path1,String contextPath)
	{
		String fileName=null;
		if(!product_file.isEmpty())
		{
			try
			{
				
				
				fileName=product_file.getOriginalFilename();
				byte[] bytes = product_file.getBytes();
				String npath=path1+"\\WEB-INF\\resources\\"+fileName;
				System.out.print("path :" + npath); 
				
				BufferedOutputStream buffStream = new BufferedOutputStream(new FileOutputStream(new File(npath)));
				buffStream.write(bytes);
	            buffStream.close();
	            String dbfilename=contextPath+"/resources/"+fileName;
	            setProduct_image(dbfilename);
	            System.out.println("dbfilenmae:"+dbfilename);
	            return dbfilename;
	            
			}
			catch(Exception e)
			{
				System.out.println("exception occurs");
				System.out.println(e.getMessage());
				return "fail";
			}
		}
		else
		{
			System.out.println("file is empty");
			return "fail";
		}
	}
}
