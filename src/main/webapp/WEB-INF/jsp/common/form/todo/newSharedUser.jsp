<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<li class="list-group-item list-group-item">
	<a href="#">${readerUser.userId}(${readerUser.userName}) ${readerUser.userBirth}</a>
	<div style="float: right;">
		<a href="/todo/share/delete?readerId=${readerUser.userId}&todoId=${sharedTodo.todoId}&writerId=${sharedTodo.writerId}" class="btn btn-default" aria-label="Right Align"> 
			<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
		</a>
	</div>
</li>
