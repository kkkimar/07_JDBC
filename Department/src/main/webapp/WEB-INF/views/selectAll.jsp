<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
    
<%-- JSTL Core ���̺귯�� �߰� --%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>��ü �μ� ��ȸ</title>
</head>
<body>

	<h1>��ü �μ� ��ȸ</h1>
	
	<table border="1">
	
		<thead>
			<tr>
				<th>�� ��ȣ</th>
				<th>�μ� �ڵ�(DEPT_ID)</th>
				<th>�μ� ��(DEPT_TITLE)</th>
				<th>���� �ڵ�(LOCATION_ID)</th>
			</tr>
		</thead>
		
		<tbody>
		
			<c:forEach items="${deptList}" var="dept" varStatus="vs">
				<tr>
					<%-- vs.count : ���� �ݺ� Ƚ�� (1���� ����) --%>
					<td>${vs.count}</td>
					<td>${dept.deptId}</td>
					<td>${dept.deptTitle}</td>
					<td>${dept.locationId}</td>
				</tr>
			</c:forEach>
		
		</tbody>
	
	</table>

</body>
</html>