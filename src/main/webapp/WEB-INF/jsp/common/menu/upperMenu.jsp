<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<nav class="navbar navbar-default" role="navigation">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> 
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span>
			</button>
			<a href="/tag/search" class="navbar-brand" href="#">TODO</a>
		</div>

		<div class="navbar-collapse collapse" id="navbar-collapse-1">
			<ul class="nav navbar-nav navbar-right">
				<li>
					<a href="/tag/search">Tag
						<button type="button" class="btn btn-default" aria-label="Right Align">
							<span class="glyphicon glyphicon-tag" aria-hidden="true"></span>
						</button>
					</a>
				</li>
				<li>
					<a href="/todo/search/all">TODO
						<button type="button" class="btn btn-default" aria-label="Right Align">
							<span class="glyphicon glyphicon-paperclip" aria-hidden="true"></span>
						</button>
					</a>
				</li>
				<li><a href="/user/login/logout">로그아웃</a></li>
			</ul>
		</div>
	</div>
</nav>