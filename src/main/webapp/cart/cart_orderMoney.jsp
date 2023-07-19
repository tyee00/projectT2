<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="/include/top.jsp" />

<section>
<br>
<div align=center>
<h2>주문서 목록 보기</h2>
<form method=post name = f1>

<table border=1 width=650>
<tr>
<th>순번</th><th>구매자코드</th><th>배송비</th>
<th>주문금액</th><th>날짜</th>
</tr>   
  <c:forEach items="${li}" var="c">
  <tr>
<td><a href = "${path}/orderOne.do?idx=${c.idx}">${c.idx}</a></td><td>${c.custNo}</td><td>${c.baesongbi}</td>
<td>${c.totalPrice}</td><td><fmt:formatDate pattern="yyyyMMdd" value="${c.getDate}"></fmt:formatDate></td>
  </tr>
  </c:forEach>
   

</table>

</form>
</div>
<br>

</section>

<c:import url="/include/bottom.jsp" />
