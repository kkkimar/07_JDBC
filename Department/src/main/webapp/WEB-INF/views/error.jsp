<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Error Page</title>
</head>
<body>
  <h1>${errorMessage}</h1>

  <button onclick="history.back()">뒤로가기</button>
  <button onclick="location.href='/'">메인 페이지</button>
</body>
</html>