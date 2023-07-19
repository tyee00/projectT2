<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="/include/top.jsp" />

<section>
<br>
<div align=center>
<h2>쇼핑몰 목록 보기</h2>

<table border=1 width=650 height=350>
<tr>
<td align="center">상품번호</td>
<td align="center">상품이름</td>
<td align="center">상품가격</td>
<td align="center">상품설명</td> 
<td align="center">사진첨부</td>   
</tr> 

   
  <c:forEach items="${li}" var="m">
   <tr>
   <td> &emsp;<a href="${path}/productSelectOne.do?productId=${m.productId}">${m.productId}</a></td>
   <td> &emsp;${m.productName}</td>
   <td><fmt:formatNumber value="${m.productPrice}" pattern="#,###"/> &emsp; </td>
   <td>&emsp;${m.productDesc}</td>
   <td>&emsp;<img src="${path}/product/files/${m.productImgStr}" width=50 height= 50></td>
   </tr>
   </c:forEach>
</table>

</div>
<br>

</section>

<c:import url="/include/bottom.jsp" />
