<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="/css/signUpForm.css">

<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>
<script	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.js"></script>

<title>이정석:TODOe</title>
</head>
<body>
	<div id="fullscreen_bg" class="fullscreen_bg">
		<div class="container">
			<div class="row">
				<div class="col-md-4 col-md-offset-4">
					<div class="panel panel-default">
						<div class="panel-body">
							<div style="float: right;">
								<a href="/user/login/form" aria-label="Right Align"> 
									<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
								</a>
							</div>
							<h3 class="text-center">SIGN UP</h3>							
							<form class="form form-signup" role="form" id="signUpForm" action="/user/signUp/submit" method="post">
								<div class="form-group">
									<div class="input-group">
										<span class="input-group-addon"><span class="glyphicon glyphicon-home"></span></span> 
										<input type="text" class="form-control" placeholder="userId" id="userId" name="userId" /> 
										<input type="text" class="form-control"	id="checkId" name="checkId" value="등록 불가능한 ID입니다." readonly />
										<input type="hidden" id="idChk" value="N" />
									</div>
								</div>

								<div class="form-group">
									<div class="input-group">
										<span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span> 
										<input type="password" class="form-control" placeholder="Password" name="userPassword" />
									</div>
								</div>

								<div class="form-group">
									<div class="input-group">
										<span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span> 
										<input type="text" class="form-control" placeholder="userName" id="userName" name="userName" />
									</div>
								</div>

								<div class="form-group">
									<div class="input-group">
										<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span> 
										<input type="date" class="form-control" placeholder="birthDate"	id="userBirth" name="userBirth" />
									</div>
								</div>

								<div>
									<input type="button" class="btn btn-sm btn-primary btn-block" role="button" value="Submit" onclick="submitCheck();" />
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script src="/js/signUpForm.js"></script>
<script src="/js/validate.js"></script>
</html>