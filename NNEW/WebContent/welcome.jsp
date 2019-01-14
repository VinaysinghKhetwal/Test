<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sx" uri="/struts-dojo-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="jquery.js"></script>
<script type="text/javascript">
	function edit(id) {
		$('#editId_'+id).addClass('hide');
		$('#idTextStruts_'+id).addClass('hide');
		$('#updateId_'+id).removeClass('hide');
		$('#idTextHTML_'+id).removeClass('hide');
			var name =$('#idTextStruts_'+id).text();
		$('#idTextHTML_'+id).children().val(name);
	}
	
	/* function update()
	{
		document.hibernate.action ="./update.action";
		document.hibernate.method = "post";
		document.loginform.submit();
	} */
	
</script>
<style type="text/css">
.hide {
	display: none;
}

.show {
	display: block;
}
</style>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border="2">
		<thead>
			<th>Action
			<th>Name</th>
		<tbody>
			<s:iterator value="empList">
				<tr>
					<td id="editId_<s:property value="id"/>"><a onclick="edit(<s:property value="id"/>)">Edit</a> | <a href="delete.action?id=<s:property value="id"/>">Delete</a>
					</td>
					<form name="hibernate" action="update">
					<td id="updateId_<s:property value="id"/>" class="hide"><input type="submit" value="Update"></input></td>
					<s:hidden name="id"></s:hidden>
					<td id="idTextStruts_<s:property value="id"/>"><s:property value="name"></s:property></td>
					<td id="idTextHTML_<s:property value="id"/>"  class="hide"><input type="text" name="name"/></td>
					</form>
			</s:iterator>
		</tbody>
	</table>

</body>
</html>