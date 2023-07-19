<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="/include/top.jsp" />

<section>
<br>
<div align=center>
<h2>방명록 보기</h2>

<table border=1 width=650>
<tr>
<td>rownum</td><td>rnum</td><td>title</td><td>writer</td><td>date_for</td>
</tr>
<c:forEach items="${li}" var="m">
<tr>
<td>${m.rownum}</td><td>${m.rnum}</td><td>${m.title}</td><td>${m.writer}</td><td>${m.date_for}</td>
</tr>
</c:forEach>

</table>


</div>
<br>

</section>

<c:import url="/include/bottom.jsp" />
