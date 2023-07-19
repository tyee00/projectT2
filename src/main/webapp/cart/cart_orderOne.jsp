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
<tr align= left>
<td colspan=4>
주문코드 : ${li[0].money_idx}<br>
구매자 : ${li[0].custName}<br>
전화번호 : ${li[0].phone}<br>
주소 : ${li[0].address}<br>
</td>
</tr>   
<tr align=center>
	<td>번호</td>
	<td>상품코드</td>
	<td>상품이름</td>
	<td>수량</td>
  </tr>
  <c:forEach items="${li}" var="c">
  
  <tr>
	<td align=center>${c.idx}</td>
	<td align=center>${c.productId}</td>
	<td align=center>${c.productName}</td>
	<td align=center>${c.amount}</td>
	<td align=center>${c.amount}</td>
  </tr>
  </c:forEach>
<tr align= left>
<td colspan=4>
배송비 : ${li[0].baesongbi}<br>
구매자 : ${li[0].totalPrice}<br>
결제 금액 : ${li[0].totalPrice + li[0].baesongbi}<br>
주문날짜 : <fmt:formatDate pattern="yyyy년MM월dd일" value="${li[0].getDate}"></fmt:formatDate><br>

</td>
</tr> 
</table>

</form>
</div>
<br>

</section>

<c:import url="/include/bottom.jsp" />