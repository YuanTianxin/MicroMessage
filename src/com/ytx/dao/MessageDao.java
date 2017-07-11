package com.ytx.dao;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ytx.bean.Message;
import com.ytx.db.DBAccess;
/**
 * 
 * @author yuantian xin
 * 和Message表相关的数据库操作
 */
public class MessageDao {
	
	/**
	 * 根据查询条件查询消息列表
	 */
	public List<Message> queryMessageList(String command,String description) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		List<Message> messageList = new ArrayList<Message>();
		try {
			sqlSession = dbAccess.getSqlSession();
			Message message = new Message();
			message.setCommand(command);
			message.setDescription(description);
			//通过sqlSession执行SQL语句
			messageList = sqlSession.selectList("Message.queryMessageList",message);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
				sqlSession = null;
			}
		}
		return messageList;
	}
	
	/**
	 * 单条删除
	 * @param id 根据ID来删除数据
	 */
	public void deleteOne(int id) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			sqlSession.delete("Message.deleteOne",id);
			sqlSession.commit();	
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
				sqlSession = null;
			}
		}
		
	}
	
	
	/**
	 * 批量删除
	 * @param ids 根据id
	 */
	public void deleteBatch(List<Integer> ids) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			sqlSession.delete("Message.deleteBatch",ids);
			sqlSession.commit();	
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
				sqlSession = null;
			}
		}
		
	}
	
	
	
	
	
	/**
	 * 根据查询条件查询消息列表
	 * @param command 查询条件之一 指令
	 * @param description  查询条件之二 描述
	 * @return 返回一个List<Message> 类型 里面存放着从数据库中查询出来的列表信息
	 * 
	 * 用原始的JDBC代码写的，但是写的麻烦且不好。
	 */
/*	public List<Message> queryMessageList(String command,String description) {
		
		List<Message> messageList = new ArrayList<Message>();
		
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
		    conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Mybatis","root","2014214081");
		    
		    //多线程用StringBuffer更好，StringBuffer是线程安全的
			StringBuilder sql=new StringBuilder("select ID,COMMAND,DESCRIPTION,CONTENT from MESSAGE where 1=1");
			List<String> paramList = new ArrayList<String>();
			
			if(command != null && !"".equals(command.trim())) {
				sql.append(" and COMMAND=?");
				paramList.add(command);
				
			}
			if(description !=null && !"".equals(description.trim())) {
				sql.append(" and DESCRIPTION like '%' ? '%'");
				paramList.add(description);
			}
			
			
			statement = conn.prepareStatement(sql.toString());
			
			//把缓存在paramList里面的查询条件放进statement中
			for(int i=0;i < paramList.size();i++) {
				statement.setString(i+1, paramList.get(i));
			}
			
			rs = statement.executeQuery();
			while(rs.next()) {
				Message message = new Message();
				message.setId(rs.getString("ID"));
				message.setCommand(rs.getString("COMMAND"));
				message.setDescription(rs.getString("DESCRIPTION"));
				message.setContent(rs.getString("CONTENT"));
				messageList.add(message);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs !=null) {
				try {
					rs.close();
					rs = null;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(statement !=null) {
				try {
					statement.close();
					statement= null;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(conn !=null) {
				try {
					conn.close();
					conn= null;
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
		return messageList;
	}*/
	
}
