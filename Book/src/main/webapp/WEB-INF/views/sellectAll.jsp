<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>도서 목록 전체 조회</title>
</head>
<body>
  <h1>도서 목록 전체 조회</h1>
  <hr>

  <table border ="1" style="border-collapse: collapse;">
    <thead>
      <th>도서 번호</th>
      <th>책 제목</th>
      <th>예약 가능</th>
    </thead>
  
    <tbody>
      <c:forEach items="${bookList}" var="book">
        <tr>
          <td>${book.bookNo}</td>
          <td>
            <a href="/book/detail?bookNo=${book.bookNo}">${book.bookTitle}</a>
          </td>
          <td>${book.bookReservation}</td>
        </tr>
      </c:forEach>
   
    </tbody>
  </table>
  <button id="home">메인으로</button>

  <script src="/resources/js/bookList.js"></script>
</body>
</html>