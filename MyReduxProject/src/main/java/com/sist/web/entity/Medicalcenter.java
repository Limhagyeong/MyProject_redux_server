package com.sist.web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
/*
 * type text 
name text 
centertype text 
opentype text 
sido text 
gungu text 
dong text 
post int 
address text 
phone text 
opendate int
cno int
 */
@Entity
@Data
public class Medicalcenter {
	@Id
	public int cno;
	public String type,name,centertype,opentype,sido,gungu,dong,post,address,phone;
	public int opendate;
	
	
}
