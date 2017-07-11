package com.ytx.bean;

/**
 * 指令对应的内容
 * @author yuantian xin
 *
 */
public class CommandContent {
	
	/**
	 * 列表内容id
	 */
	private String id;
	
	/**
	 * 列表内容
	 */
	private String content;
	
	/**
	 * 对应指令的id
	 */
	private String commandId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCommandId() {
		return commandId;
	}

	public void setCommandId(String commandId) {
		this.commandId = commandId;
	}

	
	
}
