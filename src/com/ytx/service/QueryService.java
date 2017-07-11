package com.ytx.service;

import java.util.List;
import java.util.Random;

import com.sun.org.apache.bcel.internal.generic.ICONST;
import com.ytx.bean.Command;
import com.ytx.bean.CommandContent;
import com.ytx.bean.Message;
import com.ytx.dao.CommandDao;
import com.ytx.dao.MessageDao;
import com.ytx.util.Iconst;
/**
 * 
 * @author yuantian xin
 * 查询相关的业务功能
 */
public class QueryService {
	
	/**
	 * 根据查询条件通过dao层获取列表内容
	 * @param command 指令
	 * @param description 描述
	 * @return
	 */
	public List<Message> queryMessageList(String command,String description) {
		MessageDao messageDao = new MessageDao();
		return messageDao.queryMessageList(command, description);
		
	}
	
	/**
	 * 通过指令查询自动回复的内容
	 * @param command 指令
	 * @return 自动回复的内容
	 */
	public String queryByCommand(String command) {
		CommandDao commandDao = new CommandDao();
		List<Command> commandList = null;
		if(Iconst.HELP_COMMAND.equals(command)) {
			commandList = commandDao.queryCommandList(null,null);
			StringBuilder result = new StringBuilder();
			for(int i = 0; i < commandList.size(); i++) {
				if(i !=0 ) {
					result.append("<br/>");
				}
				result.append("回复[" + commandList.get(i).getName() + "]可以查看" +commandList.get(i).getDescription());
			}
			return  result.toString();
		}
		commandList = commandDao.queryCommandList(command,null);
		if(commandList.size() > 0) {
			List<CommandContent> contentList = commandList.get(0).getContentList();
			//生成一个0~contentList.size()的随机数，包含0不包含contentList.size()
			int i = new Random().nextInt(contentList.size());
			return contentList.get(i).getContent();
		}
		return Iconst.NO_MATCHING_CONTENT;
	}
}
