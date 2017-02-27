<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div style="text-align: center; margin: 0 auto;">
	<h2 class="jquery-on-container">
		<a class="js-open-target" data-target=".complete-todo">
			<button class="btn btn-lg btn-info">
				<span>완료한 할 일</span>
			</button>
		</a>
	</h2>
</div>

<div class="complete-todo">
	<c:forEach items="${todoList}" var="todo">
		<c:if test="${todo.complete == true}">
			<li class="list-group-item list-group-item">
			<a href="/todo/share/view?todoId=${todo.todoId}&tagName=${tag.tagName}">${todo.todoName}</a></li>
		</c:if>
	</c:forEach>
</div>