<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/common.css">

<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<title>이정석:TODO</title>
</head>
<body>
	<%@include file="../common/menu/upperMenu.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<div id="item-list" class="list-group" style="margin-top: 10px;">

					<div class="todolist not-done">
						<ul class="list-group" id="todoListBody">
							<li class="list-group-item list-group-item-success">초대</li>
						</ul>
						<input type="text" class="form-control add-todo" id="readerId" placeholder="Search friend to share"> 
						<input type="hidden" id="todoId" value="${todoId}">
						<button id="shareButton" class="btn btn-success">Search	friend's Id</button>
					</div>

					<div id="item-list" class="list-group" style="margin-top: 10px;">
						<div class="todolist not-done">
							<ul class="list-group" id="sharedUserListBody">
								<li class="list-group-item list-group-item-info">공유된 사람들</li>
								<c:forEach items="${sharedUserList}" var="user">
									<li class="list-group-item list-group-item">
										<a href="#">${user.userId}(${user.userName}) ${user.userBirth}</a>
										<div style="float: right;">
											<a href="/todo/share/delete?readerId=${user.userId}&todoId=${todoId}&writerId=${writerId}" class="btn btn-default" aria-label="Right Align"> 
												<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
											</a>
										</div>
									</li>
								</c:forEach>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="/js/findUserToShare.js"></script>
</body>
</html>