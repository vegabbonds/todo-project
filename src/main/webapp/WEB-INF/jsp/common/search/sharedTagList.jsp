<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<div id="item-list" class="list-group" style="margin-top: 1px;">
				<ul class="list-group">
					<li class="list-group-item list-group-item-info"><span style="font-weight: bold">Shared Tag List</span></li>
					<li class="list-group-item list-group-item-warning"><a href="/todo/share/search?tagId=0&tagName=미분류태그">미분류태그</a></li>
					<c:forEach items="${tagList}" var="tag">
						<c:if test="${tag.writer == false}">
							<li class="list-group-item list-group-item">
								<a href="/todo/share/search?tagId=${tag.tagId}&tagName=${tag.tagName}">${tag.tagName}</a>
							</li>
						</c:if>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
</div>
