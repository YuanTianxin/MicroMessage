<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();

String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>内容列表页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="<%=basePath%>resources/js/common/jquery-1.7.js"></script>
	<script type="text/javascript" src="<%=basePath%>resources/js/back/list.js"></script>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>resources/css/list.css">
	

  </head>
  
  <body style="background: #e1e9eb;">
  	<form action="<%=basePath%>List.action"  id="mainForm" method="post">
  		
  		<input id="deleteOne" type="hidden" name="id"  />
  		
  		<div class="right">
  			<div class="current">当前位置: <a href="javascript:void(0)" style="color:#6E6E6E;">内容管理</a></div>
  			<div class="rightCont" >
  				<p class="g_title fix">内容列表  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a class="btn03" href="#">新增
  				</a>&nbsp;&nbsp;&nbsp;&nbsp;<a class="btn03"  href="javascript:deleteBatch('<%=basePath%>')">删除</a>
  				<table class="tab1">
  					<tbody>
  						<tr>
  							<td width="90" aligh="right">指令名称： </td>
  							<td>
  								<input name="command" type="text" class="allInput" value="${command}"/> &nbsp;&nbsp;
  							</td>
  							<td width="90" align="right">描述： </td>
  							<td>
  								<input name="description" type="text" class="allInput" value="${description}"/> 
  							</td>
  							<td width="85" align="right" >
  								<input type="submit" class="tabSub" value="查询">
  							</td>
  						</tr>
  					</tbody>
  				</table>
  			</div>
  		</div>
  		<div class="zixun_fix">
  			<table class="tab2" width="100%">
  				<tbody>
  					<tr class="lid">
  						<td><input type="checkbox" id="selectAll" onclick=""/></td>
  						<td>序号</td>
  						<td>指令名称</td>
  						<td>描述</td>
  						<td>操作</td>
  					</tr>
  					
  					<c:forEach items="${messageList}" var="message" varStatus="status">
  						<tr <c:if test="${status.index % 2 !=0 }">style='background-color:#ECF6EE;'</c:if>>
  							<td><input   type="checkbox"  name="id" value="${message.id}"/></td>
  							<td>${status.index + 1}</td>
  							<td>${message.command}</td>
  							<td>${message.description}</td>
  							<td>
  								<a href="#">修改</a>&nbsp;&nbsp;&nbsp;
  								<%-- <a href="${basePath}DeleteOne.action?id=${message.id}">删除</a> --%>
  								<a href="javascript:deleteOne('<%=basePath%>',${message.id})">删除</a>
							</td>
							
  						</tr>
  					</c:forEach>
  				
  				</tbody>
  			</table>
  		</div>
  		
  	</form>
    
  </body>
</html>
