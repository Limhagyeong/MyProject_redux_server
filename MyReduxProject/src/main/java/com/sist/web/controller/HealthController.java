package com.sist.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.dao.HealthDAO;
import com.sist.web.entity.Healthcenter;

@RestController
@CrossOrigin(origins = "*")
public class HealthController {
	@Autowired
	private HealthDAO hDao;
	
	@GetMapping("/health/list_redux")
	public Map healthcenter(int page,int type,String title)
	{
		if(title=="")
		{
			int rowSize=12;
			int start=(page*rowSize)-rowSize;
			List<Healthcenter> hList=hDao.healthListData(start, type);
			final int BLOCK=10;
			int totalpage=hDao.healthTotalpage(type);
			int startpage=((page-1)/BLOCK*BLOCK)+1;
			int endpage=((page-1)/BLOCK*BLOCK)+BLOCK;
			if(endpage>totalpage)
				 endpage=totalpage;
			Map map=new HashMap();
			map.put("hList", hList);
			map.put("curpage", page);
			map.put("totalpage", totalpage);
			map.put("startpage", startpage);
			map.put("endpage", endpage);
			
			return map;
		}
		else
		{
			int rowSize=12;
			int start=(page*rowSize)-rowSize;
			List<Healthcenter> hList=hDao.healthFindData(start, type, title);
			final int BLOCK=10;
			int totalpage=hDao.healthFindTotalpage(type, title);
			int startpage=((page-1)/BLOCK*BLOCK)+1;
			int endpage=((page-1)/BLOCK*BLOCK)+BLOCK;
			if(endpage>totalpage)
				 endpage=totalpage;
			Map map=new HashMap();
			map.put("hList", hList);
			map.put("curpage", page);
			map.put("totalpage", totalpage);
			map.put("startpage", startpage);
			map.put("endpage", endpage);
			System.out.println(type);
			System.out.println(title);
			return map;
		}
		
	}
	
	@GetMapping("/health/detail_redux")
	public Healthcenter healthDetail(int no)
	{
		if(no!=0)
		{
			Healthcenter vo=hDao.findByNo(no);
			vo.setHit(vo.getHit() + 1);
		    hDao.save(vo); 
		    vo=hDao.findByNo(no);
		}

		Healthcenter vo=hDao.findByNo(no);

		return vo;
				
	}
	
	@GetMapping("/health/main_redux")
	public List<Healthcenter> healthmain()
	{
		
		List<Healthcenter> list=hDao.healthMainData();
		return list;
		
	}
}
