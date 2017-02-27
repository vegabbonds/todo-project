<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form id="tag_create_form" action="/tag/create">
	<div class="modal fade" id="createTagForm">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<div style="float: right;">
						<button type="button" class="close" aria-label="Right Align" data-dismiss="modal">
							<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
						</button>
					</div>
					<h4 class="modal-title">Create New Tag</h4>
				</div>

				<div class="modal-body">
					<div class="form-group">
						<label for="inputdefault">Tag Name</label> 
						<input class="form-control" id="tagName" name="tagName" type="text">
					</div>
				</div>

				<div class="modal-footer">
					<button type="submit" class="btn btn-default" aria-label="Right Align">
						<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
					</button>
				</div>
				
			</div>
		</div>
	</div>
</form>