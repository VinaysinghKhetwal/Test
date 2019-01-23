<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="jquery.js"></script>
<script type="text/javascript">
	//dasdas hua bhai huaaaa
	function onSubmit() {
		var name = $('#name').val();
		var fullname = $('#fullname').val();
		var password = $('#password').val();
		var confirmpassword = $('#confirmpassword').val()
		var emailid = $('#emailid').val();
		var radio = $('input[name="gender"]:checked')[0];
		var contactno = $('#contactno').val();
		var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

		if (name != "" && fullname != "" && password != ""
				&& confirmpassword != "" && emailid != "" && contactno != "" && radio != undefined) {
			if (re.test(emailid.toLowerCase())) {
				if (password == confirmpassword) {
					
						document.loginform.action = "./add.action";
						document.loginform.method = "post";
						document.loginform.submit();

				} else {
					alert('Password Should be Match');
				}

			} else {
				alert('Please Enter Valid Email Address');
			}

		} else {
			alert('Please Enter Mandtory Fields');
		}
	}
</script>
</head>
<body>
	<form name="loginform">
		<input type="text" name="name" id="name"> <input type="text"
			name="fullname" id="fullname"> <input type="text"
			name="password" id="password"> <input type="text"
			name="confirmpassword" id="confirmpassword"> <input
			type="text" name="emailid" id="emailid"> <input type="radio"
			name="gender" value="Male" required>Male <input type="radio"
			name="gender" value="Female">Female <input type="submit"
			value="submit" onclick="onSubmit()">
	</form>
</body>
</html>
