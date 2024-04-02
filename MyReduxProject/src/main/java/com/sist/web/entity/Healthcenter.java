package com.sist.web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
/*
 * NO int 
TYPE int 
TITLE text 
ADDRESS text 
TIME text 
POSTER text 
PHONE text 
HIT int 
JJIMCOUNT int
=> 1 : 서울 요가 , 2 : 서울 필라테스 , 3 : 인천 요가 4: 인천 필라테스 
 */
@Entity
@Data
public class Healthcenter {
	@Id
	public int no;
	public int hit;
	public String title,address,time,poster,phone;
}
