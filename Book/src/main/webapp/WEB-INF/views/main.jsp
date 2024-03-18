<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>도서목록 조회/예약</title>
</head>
<body>
  <h3>도서 목록 검색</h3>
  <form action="book/search" method="POST">
    검색어 입력:
    <input type="text" name="keyword">
    <button>검색</button>
  </form>
  <ul>
    <li><a href="book/sellectAll">도서 전체 조회</a></li>
  </ul>

</body>
</html>