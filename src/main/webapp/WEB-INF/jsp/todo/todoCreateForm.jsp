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
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

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
	<div class="container">
		<div id="signupbox" style="margin-top: 50px"
			class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">
						Create New TODO
						<div style="float: right;">
							<a href="/tag/search" aria-label="Right Align"> 
								<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
							</a>
						</div>
					</div>

				</div>
				<div class="panel-body">
					<form id="todo_create_form" action="/todo/create" id="signupform" class="form-horizontal" role="form" method="post">

						<div class="form-group">
							<label for="email" class="col-md-3 control-label">Todo Name</label>
							<div class="col-md-9">
								<input type="text" class="form-control" name="todoName"	placeholder="Todo Name" />
							</div>
						</div>

						<div class="form-group">
							<label for="fulltname" class="col-md-3 control-label">Start	Date</label>
							<div class="col-md-9">
								<input type="text" class="form-control" id="startDate" name="startDate" placeholder="Start Date">
							</div>
						</div>
						<div class="form-group">
							<label for="fulltname" class="col-md-3 control-label">End Date</label>
							<div class="col-md-9">
								<input type="text" class="form-control" id="endDate" name="endDate" placeholder="End Date">
							</div>
						</div>

						<div class="form-group">
							<label for="fulltname" class="col-md-3 control-label">Tag</label>
							<div class="col-md-9">
								<div class="dropdown">
									<select id="tagId" name="tagId" class="dropdown-select-version select">
										<c:forEach items="${tagList}" var="tag">
											<option value="${tag.tagId}">${tag.tagName}</option>
										</c:forEach>
									</select>
								</div>
							</div>
						</div>

						<div class="form-group">
							<!-- Button -->
							<div class="col-md-offset-3 col-md-9">
								<button type="submit" class="btn btn-info"><i class="icon-hand-right"></i>Create</button>
							</div>
						</div>

					</form>
				</div>
			</div>
		</div>
	</div>
	<script src="/js/datePicker.js"></script>
	<script src="/js/todoForm.js"></script>
	<script src="/js/validate.js"></script>
</body>
</html>
