package com.sist.web.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sist.web.entity.Healthcenter;


public interface HealthDAO extends JpaRepository<Healthcenter, Integer>{
	@Query(value =  "SELECT * FROM Healthcenter WHERE type=:type ORDER BY no ASC LIMIT :start,12", nativeQuery = true)
	public List<Healthcenter> healthListData(@Param("start") int start,@Param("type") int type);
	
	@Query(value =  "SELECT CEIL(COUNT(*)/10.0) FROM Healthcenter WHERE type=:type", nativeQuery = true)
	public int healthTotalpage(@Param("type") int type);
	
	@Query(value =  "SELECT * FROM Healthcenter WHERE type=:type AND title LIKE CONCAT ('%',:title,'%') ORDER BY no ASC LIMIT :start,12", nativeQuery = true)
	public List<Healthcenter> healthFindData(@Param("start") int start,@Param("type") int type,@Param("title") String title);
	
	@Query(value =  "SELECT CEIL(COUNT(*)/10.0) FROM Healthcenter WHERE type=:type AND title LIKE CONCAT ('%',:title,'%')", nativeQuery = true)
	public int healthFindTotalpage(@Param("type") int type,@Param("title") String title);
	
	public Healthcenter findByNo(int no);
	
	@Query(value = "SELECT * FROM Healthcenter ORDER BY hit DESC LIMIT 0,6",nativeQuery = true)
	public List<Healthcenter> healthMainData();
}
