<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<div id="item-list" class="list-group" style="margin-top: 1px;">
				<ul class="list-group">
					<li class="list-group-item list-group-item-info"><span style="font-weight: bold">${tag.tagName}</span></li>

					<c:forEach items="${todoList}" var="todo">
						<c:if test="${todo.complete == false}">
							<li class="list-group-item list-group-item"	id="todoList${todo.todoId}">
								<a href="/todo/share/view?todoId=${todo.todoId}&tagName=${tag.tagName}">${todo.todoName}</a>
							</li>
						</c:if>
					</c:forEach>
				</ul>
				<%@include file="completedSharedTodoList.jsp"%>
			</div>
		</div>
	</div>
</div>
