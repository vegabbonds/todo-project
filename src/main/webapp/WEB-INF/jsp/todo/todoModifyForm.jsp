<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

<link rel="stylesheet" href="/css/datePicker.css">
<link rel="stylesheet" href="/css/todoForm.css">
<link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>
<script	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.js"></script>

<title>이정석:TODO</title>
</head>
<body>
	<%@include file="../common/menu/upperMenu.jsp"%>
	<form id="todo_modify_form" action="/todo/modify" id="signupform"
		class="form-horizontal" role="form">
		<div class="container">
			<div id="signupbox" style="margin-top: 50px"
				class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
				<div class="panel panel-info">
					<div class="panel-heading">
						<div class="panel-title">
							Modify TODO
							<div style="float: right;">
								<a href="/tag/search" aria-label="Right Align"> 
									<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
								</a>
							</div>
						</div>

					</div>
					<div class="panel-body">

						<div class="form-group">
							<label for="email" class="col-md-3 control-label">Todo
								Name</label>
							<div class="col-md-9">
								<input type="text" class="form-control" name="todoName"	placeholder="Todo Name" value="${todo.todoName}" required />
							</div>
						</div>

						<div class="form-group">
							<label for="fulltname" class="col-md-3 control-label">Start	Date</label>
							<div class="col-md-9">
								<input type="text" class="form-control" id="startDate" name="startDate" placeholder="Start Date" value="${todo.startDate}" />
							</div>
						</div>
						<div class="form-group">
							<label for="fulltname" class="col-md-3 control-label">End Date</label>
							<div class="col-md-9">
								<input type="text" class="form-control" id="endDate" name="endDate" value="${todo.endDate}" placeholder="End Date">
							</div>
						</div>

						<div class="form-group">
							<label for="fulltname" class="col-md-3 control-label">Todo status</label>

							<c:if test="${todo.complete == false}">
								<div class="col-md-9">
									<div class="form-control" class="checkbox checkbox-primary">
										<input id="completeStatus" name="complete" value="1" type="checkbox"> 
										<input type="hidden" id="complete" name="complete" value="false">
										<label for="checkbox2">완료 </label>
									</div>
								</div>
							</c:if>

							<c:if test="${todo.complete == true}">
								<div class="col-md-9">
									<div class="form-control" class="checkbox checkbox-primary">
										<input id="completeStatus" name="completeStatus" type="checkbox" value="1" checked> 
										<input type="hidden" id="complete" name="complete" value="true">
										<label for="checkbox2"> 완료 </label>
									</div>
								</div>
							</c:if>

						</div>

						<div class="form-group">
							<label for="fulltname" class="col-md-3 control-label">Tag</label>
							<div class="col-md-9">
								<div class="dropdown">
									<select id="tagId" name="tagId"
										class="dropdown-select-version select">
										<c:forEach items="${tagList}" var="tag">
											<c:if test="${tag.tagId == todo.tagId}">
												<option value="${tag.tagId}" selected="selected">${tag.tagName}</option>
											</c:if>
											<c:if test="${tag.tagId != todo.tagId}">
												<option value="${tag.tagId}">${tag.tagName}</option>
											</c:if>
										</c:forEach>
									</select>
								</div>
							</div>
						</div>

						<div class="form-group">
							<!-- Button -->
							<div class="col-md-offset-3 col-md-9">
								<button id="modify_submit_button" type="button"
									class="btn btn-info">
									<i class="icon-hand-right"></i>수정
								</button>
							</div>
						</div>
						<input type="hidden" name="todoId" value="${todo.todoId}">
					</div>
				</div>
			</div>
		</div>
	</form>
	<script src="/js/datePicker.js"></script>
	<script src="/js/todoForm.js"></script>
	<script src="/js/validate.js"></script>
</body>
</html>
