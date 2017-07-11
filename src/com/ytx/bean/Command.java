package com.ytx.bean;

import java.util.List;

/**
 * 与指令表对应的实体类
 * @author yuantian xin
 *
 */
public class Command {
	/**
	 * 指令ID
	 */
	private String id;
	
	/**
	 * 指令名称
	 */
	private String name;
	
	/**
	 * 指令描述
	 */
	private String description;
	 
	/**
	 * 一条指令对应的多条内容
	 */
	private List<CommandContent> contentList;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<CommandContent> getContentList() {
		return contentList;
	}

	public void setContentList(List<CommandContent> contentList) {
		this.contentList = contentList;
	}
	
	
}
