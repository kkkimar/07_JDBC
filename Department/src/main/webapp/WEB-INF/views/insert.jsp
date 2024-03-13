<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>부서 추가 페이지</title>
</head>
<body>
  
  <h1>부서 추가 페이지</h1>
  <%-- 주소에서 절대/상대 경로

    주소 형태 : http://IP주소(도메인):POTR/요청주소

    ex) 현재 페이지 주소 : http://localhost/department/insert (GET방식)

    절대 경로 : PORT 번호 뒤에 "/"부터 요청하려는 주소를 모두 작성
                /department/insert

    상대 경로 : 주소 제일 마지막 경로부터 원하는 요청 주소까지를 작성
                insert 
   --%>
  
  <%-- 상대 경로 방식으로 주소 작성 --%>
  <form action="insert" method="POST">
  
    <div>
      부서 코드(DEPT_ID) : <input type="text" name = "deptId">
    </div>

    <div>
      부서 이름(DEPT_TITLE) : <input type="text" name = "deptTitle">
    </div>

    <div>
      지역 코드(LOCATION_ID) : <input type="text" name = "locationId">
    </div>
  
    <%-- button의 type 기본값은 submit --%>
    <button type="submit">추가하기</button>
  </form>

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


  <hr><hr><hr>

  <h1>여러 부서 한 번에 추가 하기</h1>
  <form action="/department/multiInsert" method="post" name="multiInsertForm">
    
    <button type="button" id="addBtn">입력 추가</button>

    <table>
      <thead>
        <tr>
          <th>부서 코드</th>
          <th>부서명</th>
           <th>지역 코드</th>
          <th>삭제버튼</th>
        </tr>
      </thead>

      <tbody id="tbody">
        <tr>
          <td>
            <input type="text" name="deptId">
          </td>
           <td>            <input type="text" name="deptTitle">
          </td>
          <td>
            <input type="text" name="locationId">
          </td>
          <th>
            <button type="button" class="remove-btn">삭제</button>
          </th>
        </tr>
      </tbody>
    </table>

    <button>부서 추가 하기</button>
  </form>














<script src="/resources/js/insert.js"></script>
</body>
</html>