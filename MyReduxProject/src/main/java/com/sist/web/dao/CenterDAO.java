package com.sist.web.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sist.web.entity.Medicalcenter;



public interface CenterDAO extends JpaRepository<Medicalcenter, Integer>{
	@Query(value =  "SELECT * FROM Medicalcenter ORDER BY cno ASC LIMIT :start,10", nativeQuery = true)
	public List<Medicalcenter> centerListData(@Param("start") int start);
	
	@Query(value =  "SELECT count(*) FROM Medicalcenter", nativeQuery = true)
	public int totalPage();
	
	@Query(value =  "SELECT * FROM Medicalcenter WHERE name LIKE CONCAT ('%',:name,'%') AND centertype LIKE CONCAT ('%',:centertype,'%') ORDER BY cno ASC LIMIT :start,10", nativeQuery = true)
	public List<Medicalcenter> centerFindData(@Param("start") int start,@Param("name") String name,@Param("centertype") String centertype);
	
	@Query(value =  "SELECT count(*) FROM Medicalcenter WHERE name LIKE CONCAT ('%',:name,'%') AND centertype LIKE CONCAT ('%',:centertype,'%')" , nativeQuery = true)
	public int findTotalPage(@Param("name") String name,@Param("centertype") String centertype);
	
	public Medicalcenter findByCno(int cno);
	
}
