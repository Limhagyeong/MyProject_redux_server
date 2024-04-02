package com.sist.web.controller;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.dao.CenterDAO;
import com.sist.web.entity.Medicalcenter;
@RestController
@CrossOrigin(origins = "*")
public class CenterController {
	@Autowired
	private CenterDAO cDao;
	
	@GetMapping("/center/list_redux")
	public Map centerList(int page,String name,String centertype)
	{	
		if(name==null && centertype==null)
		{
		int rowSize=10;
		int start=(page*rowSize)-rowSize;
		List<Medicalcenter> list=cDao.centerListData(start);
		final int BLOCK=10;
		int totalpage=cDao.totalPage();
		int startpage=((page-1)/BLOCK*BLOCK)+1;
		int endpage=((page-1)/BLOCK*BLOCK)+BLOCK;
		if(endpage>totalpage)
			 endpage=totalpage;
		Map map=new HashMap();
		map.put("list", list);
		map.put("curpage", page);
		map.put("totalpage", totalpage);
		map.put("startpage", startpage);
		map.put("endpage", endpage);
		
		return map;
		}
		else
		{
			System.out.println(centertype);
			int rowSize=10;
			int start=(page*rowSize)-rowSize;
			List<Medicalcenter> list=cDao.centerFindData(start, name,centertype);
			final int BLOCK=10;
			int totalpage=cDao.findTotalPage(name,centertype);
			int startpage=((page-1)/BLOCK*BLOCK)+1;
			int endpage=((page-1)/BLOCK*BLOCK)+BLOCK;
			if(endpage>totalpage)
				 endpage=totalpage;
			Map map=new HashMap();
			map.put("list", list);
			map.put("curpage", page);
			map.put("totalpage", totalpage);
			map.put("startpage", startpage);
			map.put("endpage", endpage);
			System.out.println(name);
			return map;
		}
		
	}
	@GetMapping("/center/detail_redux")
	public Medicalcenter centerDetail(int cno)
	{
		return cDao.findByCno(cno);
	}
}

