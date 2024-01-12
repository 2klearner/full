package com.example.demo.pojo;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
public int pid;
	private String pname;
	private Date orderdate;
	private int cost;

}

