<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="/include/top.jsp" />
<script>
function delk(cartId){
	alert(cartId);
	location.href = "${path}/cartDelete.do?cartId="+cartId;
}
function delAll(custNo){
	alert(custNo);
	location.href = "${path}/cartDeleteAll.do?custNo="+custNo;
}
</script>
<section>
<br>
<div align=center>
<h2>장바구니 목록 보기</h2>
<form method=post name = f1>
<c:if test="${not empty li}">
<table border=1 width=650>
<tr>
<th>장바구니ID</th><th>상품코드</th><th>상품이름</th>
<th>상품가격</th><th>구매수량</th><th>상품이미지</th>
<th>삭제</th>
</tr>   
  <c:forEach items="${li}" var="c">
  <input type="hidden" name="cartId" value="${c.cartId}" />
  
  <input type = hidden name = custno value = "${session.custno}">
  <input type = hidden name = productId value = "${c.productId}">
  <input type = hidden name = productName value = "${c.productName}">
  
  <c:set var="totalPrice" value="${c.productPrice * c.amount + totalPrice}" />
   <tr>
   <td>${c.cartId }</td>
   <td>${c.productId }</td>
   <td>${c.productName }</td>
   <td><fmt:formatNumber pattern="#,###" value="${c.productPrice }"></fmt:formatNumber> </td>
   <td><input type = text name = amount value = "${c.amount}"></td>
   <td><img src="${path}/product/files/${c.productImgStr}" width = 50px height = 50px></td>
   <td><input type=button onclick="delk('${c.cartId}')" value="삭제"></td>
   </tr>
  
   </c:forEach>
   
<tr>
<td colspan = 7>
장바구니 합계 : <fmt:formatNumber pattern="#,###" value ="${totalPrice}"></fmt:formatNumber>
<c:choose>
<c:when test="${totalPrice >= 30000}">배송비 무료<br>총결제금액 : <fmt:formatNumber pattern="#,###" value ="${totalPrice}"></fmt:formatNumber>
<input type = hidden name = baesongbi value = '0'>
</c:when>
<c:when test="${totalPrice < 30000}">배송비 3,000원 추가<br>총결제금액 : <fmt:formatNumber pattern="#,###" value ="${totalPrice+3000}"></fmt:formatNumber>
<input type = hidden name = baesongbi value = '3000'>
</c:when>
</c:choose>
</td>
</tr>

<tr>

<td colspan = 7 align=center>
<input type=hidden name =totalPrice value="${totalPrice}">
<input type= submit onclick="javascript: form.action='${path}/cartOrder.do'" value="주문하기">
<input type= submit onclick="javascript: form.action='${path}/cartUpdate.do'" value="수정하기">
<input type= button value="전체삭제" onclick="delAll('${session.custno}')">
</td>
</tr>

</table>
</c:if>
</form>
</div>
<br>

</section>

<c:import url="/include/bottom.jsp" />
