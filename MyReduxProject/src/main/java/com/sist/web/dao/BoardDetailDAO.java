package com.sist.web.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sist.web.entity.Myreduxboard;

public interface BoardDetailDAO extends JpaRepository<Myreduxboard, Integer>{
	public Myreduxboard findByNo(int no);
}
