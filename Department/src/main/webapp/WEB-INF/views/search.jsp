<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>${param.keyword} 검색 결과</title>
</head>
<body>
  <h1>${param.keyword} 검색 결과</h1>

	<%-- el연산자 :empty -> 비어 있거나 null인 경우 true 반환  --%>
	<c:if test="${empty deptList}" >
		<h3>검색 결과가 없습니다</h3>
	</c:if>

	<%-- not empty -> 비어 있지 않거나, null이 아닌 경우 true 반환  --%>
	<c:if test="${not empty deptList}" >
		<table border="1">

			<thead>
				<tr>
					<th>행 번호</th>
					<th>부서 코드 (DEPT_ID)</th>
					<th>부서 명   (DEPT_TITLE)</th>
					<th>지역 코드 (LOCATION_ID)</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${deptList}" var="dept" varStatus="vs">
					
					<tr>
						<%-- vs.count : 현재 반복 횟수 (1부터 시작) --%>
						<td>${vs.count}</td>
						
						<td>${dept.deptId}</td>
						
						<td>${dept.deptTitle}</td>
						
						<td>${dept.locationId}</td>

					</tr>
				
				</c:forEach>
			</tbody>

		</table>

</c:if>



	<%-- session scope로 전달 받은 message가 있으면 alert() 출력 --%>
	<c:if test="${not empty message}" >
		<%-- message: 
			   page ~ application 까지 message 속성이 있는지 확인해서
				 존재하는 scope의 값을 얻어옴
		 --%>
		<script>
			const message = "${message}";
			alert(message);
		</script>

		<%-- session 은 브라우저 종료 또는 만료 시 까지 유지
			-> 현재 페이지에 들어올 때 마다 session의 message가 계속 출력되는
			   문제가 발생함!!
			-> 1회만 message를 출력한 후 제거
		 --%>
		<c:remove var="message" scope="session" />

	</c:if>

</body>
</html>