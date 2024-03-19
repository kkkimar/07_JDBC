<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>도서 상세 페이지</title>
</head>
<body>
  <h1>책 제목 : ${bookList.bookTitle}</h1>

  <table border="1">
    <tr>
      <th>번호</th>
      <td>${bookList.bookNo}</td>
    </tr>

    <tr>
      <th>예약하기</th>
      <td>
        <%-- data-* 속성
          - 데이터에 대한 확장성을 고려하여 설계된 속성
          - js에서 요소.dataset 을 이용해 해당 값을 얻어갈 수 있음
        --%>
        <c:if test="${bookList.bookReservation == 'Y'}" >
          <button type = "button" id = "reservation-btn" data-book-no = "${bookList.bookNo}">${bookList.bookReservation}</button>
        </c:if>
        <c:if test="${bookList.bookReservation == 'N'}" >
          <button type = "button" id = "reservation-btn" data-book-no = "${bookList.bookNo}" disabled>${bookList.bookReservation}</button>
        </c:if>
      </td>
    </tr>

    <tr>
      <th>내용</th>
      <td class="todo-content">${bookList.bookInto}</td>
    </tr>
  </table>

  <button id="gotoList">목록조회</button>

  <script src="/resources/js/bookList.js"></script>
</body>
</html>