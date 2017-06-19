<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
table, tr, td {
	border: 1px solid black;
}
</style>
<script type="text/javascript">
	var m = '${message}';
	if (m != '') {
		alert(m);
	}
</script>
</head>
<body>
	<!-- List 제목 -->
	<h1>${board}</h1>
	<table>
		<tr>
			<td>NUM</td>
			<td>TITLE</td>
			<td>WRITER</td>
			<td>DATE</td>
			<td>HIT</td>
		</tr>
		<c:forEach items="${list}" var="dto">
			<tr>
				<td>${dto.num}</td>
				<td>
				<c:catch>
				<c:forEach begin="1" end="${dto.depth}">--</c:forEach>
				</c:catch>
				<a href="noticeView?num=${dto.num}">${dto.title}</a></td>
				<td>${dto.writer}</td>
				<td>${dto.reg_date}</td>
				<td>${dto.hit}</td>
			</tr>
		</c:forEach>
	</table>	
	 <c:if test="${makePage.curBlock>1 }">
      <a href="${board }List?curPage=${makePage.startNum-1 }"><<</a>
   </c:if>

   <c:forEach begin="${makePage.startNum }" end="${makePage.lastNum }" var="i">
      <a href="${board }List?curPage=${i }">${i }</a>
   </c:forEach>
   
   <c:if test="${makePage.curBlock < makePage.totalBlock }">
      <a href="${board }List?curPage=${makePage.lastNum+1 }">>></a>
   </c:if>
	<a href="${board}Write">noticeWrite</a>
</body>
</html>