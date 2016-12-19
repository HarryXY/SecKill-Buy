<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="common/tag.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!DOCTYPE html>
<html>
   <head>
      <title>SecKill List</title>
      <%@include file="common/head.jsp" %>
   </head>
   <body>
   		<!-- page display part(BootStrap) -->	 
   		<div class="container">
   			<div class="panel panel-default">
   				<div class="panel-heading text-center">
   					<h2>SecKill List</h2>
   				</div>
   				<div class="panel-body">
	   				<table class="table table-hover">
	   					<thead>
	   						<tr>
	   							<th>Product</th>
	   							<th>Number</th>
	   							<th>Start Time</th>
	   							<th>End Time</th>
	   							<th>Create Time</th>
	   							<th>Detail Page</th>
	   						</tr>
	   					</thead>
	   					<tbody>
	   						<c:forEach var="sk" items="${list}">
	   							<tr>
	   								<td>${sk.name}</td>
	   								<td>${sk.number}</td>
	   								<td>
	   									<fmt:formatDate value="${sk.startTime }" pattern="yyyy-MM-dd HH:mm:ss"/>
	   								</td>
	   								<td>
	   									<fmt:formatDate value="${sk.endTime }" pattern="yyyy-MM-dd HH:mm:ss"/>
	   								</td>
	   								<td>
	   									<fmt:formatDate value="${sk.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/>
	   								</td>
	   								<td>
	   									<a class="btn btn-info" href="/seckill/seckill/${sk.seckillId}/detail" target="_blank">Link</a>
	   								</td>
	   							</tr>
	   						</c:forEach>
	   					</tbody>
	   				</table>
   				</div>
   			</div>   			
   		</div>   	

   </body>
   	<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
	<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
	 
	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</html>