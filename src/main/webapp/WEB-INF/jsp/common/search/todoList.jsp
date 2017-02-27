<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<div id="item-list" class="list-group" style="margin-top: 1px;">

				<ul class="list-group" id="todoListBody">
					<li class="list-group-item list-group-item-success">
						<span style="font-weight: bold">${tag.tagName}</span>
						<div style="float: right;">
							<a href="/todo/form" type="button" class="btn btn-default btn-sm" aria-label="Right Align">
								TODO<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
							</a>
						</div>
					</li>

					<c:forEach items="${todoList}" var="todo">
						<c:if test="${todo.complete == false}">
							<li class="list-group-item list-group-item"	id="todoList${todo.todoId}">
								<a href="/todo/modify/form/${todo.todoId}">${todo.todoName}</a>

								<div style="float: right;">
									<a href="/todo/share/${todo.todoId}" class="btn btn-default btn-sm" aria-label="Right Align"> 
										<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
									</a>
								</div>

								<div style="float: right;">
									<button type="button" class="btn btn-default btn-sm" aria-label="Right Align" onclick="deleteTodo(this)" id="deleteTodo" value="${todo.todoId}">
										<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
									</button>
								</div>
							</li>
						</c:if>
					</c:forEach>
				</ul>
				<%@include file="completedTodoList.jsp"%>
			</div>
		</div>
	</div>
</div>
