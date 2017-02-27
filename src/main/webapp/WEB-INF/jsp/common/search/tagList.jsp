<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<div id="item-list" class="list-group" style="margin-top: 1px;">

				<ul class="list-group">
					<li class="list-group-item list-group-item-success"><span
						style="font-weight: bold">Tag List</span>
						<div style="float: right;">
							<a href="/todo/form" type="button" class="btn btn-default btn-sm" aria-label="Right Align">
							TODO<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
							</a>
						</div>
					</li>

					<li class="list-group-item list-group-item-warning">
						<a href="/todo/search?tagId=0&tagName=미분류태그">미분류태그</a>
					</li>

					<c:forEach items="${tagList}" var="tag">
						<c:if test="${tag.writer == true}">
							<li class="list-group-item list-group-item">
								<a href="/todo/search?tagId=${tag.tagId}&tagName=${tag.tagName}">${tag.tagName}</a>
								
								<div style="float: right;">
									<button type="button" class="btn btn-default btn-sm"
										aria-label="Right Align" value="${tag.tagId}"
										onclick="getTagModifyForm(this)">
										<span class="glyphicon glyphicon-scissors" aria-hidden="true"></span>
									</button>
								</div>

								<div style="float: right;">
									<a href="/tag/delete/${tag.tagId}" type="button"
										class="btn btn-default btn-sm" aria-label="Right Align"> <span
										class="glyphicon glyphicon-trash" aria-hidden="true"></span>
									</a>
								</div>
							</li>
						</c:if>
					</c:forEach>

					<li class="list-group-item list-group-item-item">
						<div style="text-align:center">
							<button type="button" class="btn btn-info" aria-label="Right Align" data-target="#createTagForm" data-toggle="modal">
								<i class="icon-hand-right"></i>태그추가
							</button>
						</div>
					</li>
				</ul>

			</div>
		</div>
	</div>
</div>