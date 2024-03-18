<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>도서 목록 검색 결과</title>
</head>
<body>
  <h3>${param.keyword} 검색 결과</h3>
  <table border="1">
		<thead>
				<tr>
					<th>도서 번호</th>
					<th>책 제목</th>
					<th>예약 가능 (Y/N)</th>
				</tr>
			</thead>

      <tbody>
         <c:forEach items="${bookList}" var="book">
        <tr>
          <td>${book.bookNo}</td>
          <td>${book.bookTitle}</td>
          <td>${book.bookReservation}</td>
        </tr>
      </c:forEach>
    </tbody>
  
    <button id="gotoMain">목록으로</button>
  </table>


  <script src="/resources/js/bookList.js"></script>
  
  <c:if test="${not empty message}">
    <script>
      alert("${message}");
    </script>

    <c:remove var="message" />
  </c:if>

</body>
</html>