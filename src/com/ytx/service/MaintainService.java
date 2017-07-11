package com.ytx.service;

import java.util.ArrayList;
import java.util.List;

import com.ytx.dao.MessageDao;

/**
 * 
 * @author yuantian xin
 * 维护相关的业务功能
 */
public class MaintainService {
	/**
	 * 单条删除
	 * @param id 
	 */
	public void deleteOne(String id) {
		if(id != null && !"".equals(id.trim())){
		MessageDao messageDao = new MessageDao();
		messageDao.deleteOne(Integer.valueOf(id));
		}
	}
	
	
	/**
	 * 批量删除
	 * @param ids 根据id
	 */
	public void deleteBatch(String[]  ids) {
		MessageDao messageDao = new MessageDao();
		List<Integer> idList = new ArrayList<Integer>();
		for(String id : ids) {
			idList.add(Integer.valueOf(id));
		}
		messageDao.deleteBatch(idList);
	}
	
}
