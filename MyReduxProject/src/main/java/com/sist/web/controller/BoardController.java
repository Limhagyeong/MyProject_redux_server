package com.sist.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.dao.BoardDAO;
import com.sist.web.dao.BoardDetailDAO;
import com.sist.web.entity.BoardVO;
import com.sist.web.entity.Myreduxboard;

import java.util.*;
@RestController
@CrossOrigin(origins = "*")
public class BoardController {
@Autowired
private BoardDAO bDao;
@Autowired
private BoardDetailDAO bdDao;

@GetMapping("/board/list_reduxboard")
public Map boardListData(int page)
{
	int rowsize=10;
	int start=(page*rowsize)-rowsize;
	List<BoardVO> blist=bDao.boardListData(start);
	int count=(int) bDao.count();
	int totalpage=(int)(Math.ceil(count/10.0));
	
	Map map=new HashMap();
	map.put("blist",blist);
	map.put("curpage", page);
	map.put("totalpage", totalpage);
	
	return map;
}

@GetMapping("/board/total_reduxboard")
public String board_total()
{
	int count=(int) bDao.count();
	int totalpage=(int)(Math.ceil(count/10.0));
	return String.valueOf(totalpage);
}

@PostMapping("board/insert_reduxboard")
public String boardInsert(Myreduxboard vo)
{
	String res="";
	try
	{
		bDao.save(vo);
		res="yes";
	}catch(Exception ex)
	{
		res="no";
	}
	return res;
}
@GetMapping("board/detail_reduxboard")
public Myreduxboard boardDetail(int no)
{
	Myreduxboard vo=bdDao.findByNo(no);
	vo.setHit(vo.getHit()+1);
	bdDao.save(vo);
	vo=bdDao.findByNo(no);
	return vo;
}

@GetMapping("board/update_reduxboard")
public Myreduxboard boardUpdate(int no)
{
	Myreduxboard vo=bdDao.findByNo(no);
	return vo;
}
@PostMapping("board/update_ok_reduxboard")
public String boardUpdateOk(Myreduxboard vo)
{
	Myreduxboard dbVO=bdDao.findByNo(vo.getNo());
	String res="";
	if(vo.getPwd().equals(dbVO.getPwd()))
	{
		res="yes";
		vo.setHit(dbVO.getHit());
		bdDao.save(vo);
	}
	else
	{
		res="no";
	}
	
	return res;
}
@PostMapping("board/delete_reduxboard")
public String boardDelete(int no,String pwd)
{
	String res="";
	Myreduxboard vo=bdDao.findByNo(no);
	if(vo.getPwd().equals(pwd))
	{
		res="yes";
		bdDao.delete(vo);
	}
	else
	{
		res="no";
	}
	return res;
}
}
