<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="container-fluid"">
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<c:forEach items="${todoList}" var="type">
				<c:if test="${type.key == 'notComplete'}">
					<div class="jquery-on-container">
						<a class="js-open-target" data-target=".${type.key}">
							<ul class="list-group" id="todoListBody">
								<li class="list-group-item list-group-item-danger"><span style="font-weight: bold">미해결 목록</span></li>
								<div class="${type.key}">
									<c:forEach items="${type.value}" var="todo">
										<c:if test="${userId == todo.writerId}">
											<li class="list-group-item list-group-item"	id="todoList${todo.todoId}">
												<a href="/todo/modify/form/${todo.todoId}">${todo.todoName}</a>
												<span class="label label-default" style="background-color: #00AAAA">${todo.tagName}</span>

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
										<c:if test="${userId != todo.writerId}">
											<li class="list-group-item list-group-item"	id="todoList${todo.todoId}">
												<a href="/todo/share/view?todoId=${todo.todoId}&tagName=${tag.tagName}">${todo.todoName}</a>
												<span class="label label-default" style="background-color: #00AAAA">${todo.tagName}</span>
											</li>
										</c:if>
									</c:forEach>
								</div>
							</ul>
						</a>
					</div>
				</c:if>
			</c:forEach>

			<c:forEach items="${todoList}" var="type">
				<c:if test="${type.key == 'today'}">
					<div class="jquery-on-container">
						<a class="js-open-target" data-target=".${type.key}">
							<ul class="list-group" id="todoListBody${type.key}">
								<li class="list-group-item list-group-item-info"><span style="font-weight: bold">오늘 할 일</span></li>
								<div class="${type.key}">
									<c:forEach items="${type.value}" var="todo">
										<c:if test="${userId == todo.writerId}">
											<li class="list-group-item list-group-item" id="todoList${todo.todoId}">
												<a href="/todo/modify/form/${todo.todoId}">${todo.todoName}</a>
												<span class="label label-default" style="background-color: #00AAAA">${todo.tagName}</span>

												<div style="float: right;">
													<a href="/todo/share/${todo.todoId}" class="btn btn-default btn-sm" aria-label="Right Align">
														<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
													</a>
												</div>

												<div style="float: right;">
													<button type="button" class="btn btn-default btn-sm" aria-label="Right Align" onclick="deleteTodo(this)"
														id="deleteTodo" value="${todo.todoId}">
														<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
													</button>
												</div>
											</li>
										</c:if>
										<c:if test="${userId != todo.writerId}">
											<li class="list-group-item list-group-item"	id="todoList${todo.todoId}">
												<a href="/todo/share/view?todoId=${todo.todoId}&tagName=${tag.tagName}">${todo.todoName}</a>
												<span class="label label-default" style="background-color: #00AAAA">${todo.tagName}</span>
											</li>
										</c:if>
									</c:forEach>
								</div>
							</ul>
						</a>
					</div>
				</c:if>
			</c:forEach>

			<c:forEach items="${todoList}" var="type">
				<c:if test="${type.key == 'withinAWeek'}">
					<div class="jquery-on-container">
						<a class="js-open-target" data-target=".${type.key}">
							<ul class="list-group" id="todoListBody">
								<li class="list-group-item list-group-item-info"><span style="font-weight: bold">일주일 이내 진행중인 일정</span></li>
								<div class="${type.key}">
									<c:forEach items="${type.value}" var="todo">
										<c:if test="${userId == todo.writerId}">
											<li class="list-group-item list-group-item"	id="todoList${todo.todoId}">
												<a href="/todo/modify/form/${todo.todoId}">${todo.todoName}</a>
												<span class="label label-default" style="background-color: #00AAAA">${todo.tagName}</span>

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
										<c:if test="${userId != todo.writerId}">
											<li class="list-group-item list-group-item"	id="todoList${todo.todoId}">
												<a href="/todo/share/view?todoId=${todo.todoId}&tagName=${tag.tagName}">${todo.todoName}</a>
												<span class="label label-default" style="background-color: #00AAAA">${todo.tagName}</span>
											</li>
										</c:if>
									</c:forEach>
								</div>
							</ul>
						</a>
					</div>
				</c:if>
			</c:forEach>

			<c:forEach items="${todoList}" var="type">
				<c:if test="${type.key == 'withinAMonth'}">
					<div class="jquery-on-container">
						<a class="js-open-target" data-target=".${type.key}">
							<ul class="list-group" id="todoListBody">
								<li class="list-group-item list-group-item-info"><span
									style="font-weight: bold">한달 이내 진행중인 일정</span></li>
								<div class="${type.key}">
									<c:forEach items="${type.value}" var="todo">
										<c:if test="${userId == todo.writerId}">
											<li class="list-group-item list-group-item"	id="todoList${todo.todoId}">
												<a href="/todo/modify/form/${todo.todoId}">${todo.todoName}</a>
												<span class="label label-default" style="background-color: #00AAAA">${todo.tagName}</span>

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
										<c:if test="${userId != todo.writerId}">
											<li class="list-group-item list-group-item" id="todoList${todo.todoId}">
												<a href="/todo/share/view?todoId=${todo.todoId}&tagName=${tag.tagName}">${todo.todoName}</a>
												<span class="label label-default" style="background-color: #00AAAA">${todo.tagName}</span>
											</li>
										</c:if>
									</c:forEach>
								</div>
							</ul>
						</a>
					</div>
				</c:if>
			</c:forEach>

			<c:forEach items="${todoList}" var="type">
				<c:if test="${type.key == 'later'}">
					<div class="jquery-on-container">
						<a class="js-open-target" data-target=".${type.key}">
							<ul class="list-group" id="todoListBody">
								<li class="list-group-item list-group-item-info"><span style="font-weight: bold">나중에 할 일</span></li>
								<div class="${type.key}">
									<c:forEach items="${type.value}" var="todo">
										<c:if test="${userId == todo.writerId}">
											<li class="list-group-item list-group-item"	id="todoList${todo.todoId}">
												<a href="/todo/modify/form/${todo.todoId}">${todo.todoName}</a>
												<span class="label label-default" style="background-color: #00AAAA">${todo.tagName}</span>

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
										<c:if test="${userId != todo.writerId}">
											<li class="list-group-item list-group-item"	id="todoList${todo.todoId}">
												<a href="/todo/share/view?todoId=${todo.todoId}&tagName=${tag.tagName}">${todo.todoName}</a>
												<span class="label label-default" style="background-color: #00AAAA">${todo.tagName}</span>
											</li>
										</c:if>
									</c:forEach>
								</div>
							</ul>
						</a>
					</div>
				</c:if>
			</c:forEach>

			<c:forEach items="${todoList}" var="type">
				<c:if test="${type.key == 'complete'}">
					<div class="jquery-on-container">
						<a class="js-open-target" data-target=".${type.key}">
							<ul class="list-group" id="todoListBody">
								<li class="list-group-item list-group-item-success"><span style="font-weight: bold">완료 목록</span></li>
								<div class="${type.key}">
									<c:forEach items="${type.value}" var="todo">
										<c:if test="${userId == todo.writerId}">
											<li class="list-group-item list-group-item"	id="todoList${todo.todoId}">
												<a href="/todo/modify/form/${todo.todoId}">${todo.todoName}</a>
												<span class="label label-default" style="background-color: #00AAAA">${todo.tagName}</span>

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
										<c:if test="${userId != todo.writerId}">
											<li class="list-group-item list-group-item"	id="todoList${todo.todoId}">
												<a href="/todo/share/view?todoId=${todo.todoId}&tagName=${tag.tagName}">${todo.todoName}</a>
												<span class="label label-default" style="background-color: #00AAAA">${todo.tagName}</span>
											</li>
										</c:if>
									</c:forEach>
								</div>
							</ul>
						</a>
					</div>
				</c:if>
			</c:forEach>

		</div>
	</div>
</div>