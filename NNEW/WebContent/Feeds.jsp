<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="nicEdit.js"></script>
 <script type="text/javascript">
	bkLib.onDomLoaded(function() { nicEditors.allTextAreas() });
</script>
<!-- <script src="https://cloud.tinymce.com/stable/tinymce.min.js"></script>
  <script>tinymce.init({ selector:'textarea' });</script> -->
</head>
<body onload="myFunction()">

<textarea rows="4" cols="40" id="textArea" name="area1" style="width: 100%;">
</textarea>
<input id="submit" type="button" value="submit">
<hr>
<div id="display"></div>
</body>
<script src="jquery.js"></script>
<script type="text/javascript">
	
	function myFunction()
	{
		$.ajax({
			type : 'GET',
			url : 'getFeed',
			dataType : 'json',
			contentType : "application/json",
			success : function(data) {
				populate(data);
			}
		});
	}

	$('#submit').off().on(
			'click',
			function() {
				
				var ob = {};
				var nicE = new nicEditors.findEditor('textArea');
				var question = nicE.getContent();
				//ob['textArea'] = document.getElementById('textArea').value;
			//	var tiny = tinyMCE.get('textArea').getContent();
				ob['textArea'] = question;
				
				$.ajax({
					type : 'GET',
					url : 'feed',
					data : ob,
					dataType : 'json',
					contentType : "application/json",
					success : function(data) {
						populate(data);
					}
				});
			})
			
	function populate(data)
	{
		$('#textArea').val('');
		$('#display').empty();
		
		$.each(data.empList,function(i,j){
								
				$('#display').append('<div>'+j.textArea+'</div>')
		})
	}
</script>
</html>