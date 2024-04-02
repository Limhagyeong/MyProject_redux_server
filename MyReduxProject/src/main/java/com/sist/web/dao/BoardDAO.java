package com.sist.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.sist.web.entity.Myreduxboard;
import com.sist.web.entity.BoardVO;


import java.util.*;
public interface BoardDAO extends JpaRepository<Myreduxboard, Integer>{
	@Query(value =  "SELECT no,subject,name,regdate,hit FROM Myreduxboard ORDER BY no DESC LIMIT :start,10", nativeQuery = true)
	public List<BoardVO> boardListData(@Param("start") int start);
	
	public Myreduxboard findByNo(int no);
}
