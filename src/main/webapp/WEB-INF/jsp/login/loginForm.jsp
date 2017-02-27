<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/loginForm.css">	

<script	src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>
<script	src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.js"></script>
	
<title>이정석:TODO</title>
</head>
<body>
	<div class="container">
		<div class="card card-container">
			<img id="profile-img" class="profile-img-card" src="//ssl.gstatic.com/accounts/ui/avatar_2x.png" />
			<p id="profile-name" class="profile-name-card"></p>
			
			<form id="login_form" action="/user/login/submit" class="form-signin" method="post">
				<span id="reauth-email" class="reauth-email"></span> 
				<input type="text" id="userId" name="userId" class="form-control" placeholder="User Id" required autofocus> 
				<input type="password" id="userPassword" name="userPassword" class="form-control" placeholder="Password" required>
				<button class="btn btn-lg btn-primary btn-block btn-signin"	type="submit">Sign in</button>
			</form>

			<a href="/user/signUp/form" class="forgot-password"> Do you want to join? </a>
		</div>
	</div>
</body>
<script src="/js/validate.js"></script>
</html>