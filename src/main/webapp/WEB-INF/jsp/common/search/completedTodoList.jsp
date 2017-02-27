<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div style="text-align: center; margin: 0 auto;">
	<h2 class="jquery-on-container">
		<a class="js-open-target" data-target=".closed-content">
			<button class="btn btn-lg btn-info">
				<span>완료한 할 일</span>
			</button>
		</a>
	</h2>
</div>

<div class="closed-content">
	<c:forEach items="${todoList}" var="todo">
		<c:if test="${todo.complete == true}">
			<li class="list-group-item list-group-item" id="todoList${todo.todoId}">
				<a href="/todo/modify/form/${todo.todoId}">${todo.todoName}</a>	
				<div style="float: right;">
					<button type="button" class="btn btn-default btn-sm" aria-label="Right Align" onclick="deleteCompleteTodo(this)" id="deleteTodo" value="${todo.todoId}">
						<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
					</button>
				</div>
			</li>
		</c:if>
	</c:forEach>
</div>