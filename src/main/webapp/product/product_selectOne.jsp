<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:import url="/include/top.jsp" />
<script type="text/javascript">
function listK() {
	alert("상품목록보기");
	location.href = "${path}/productSelectAll.do";
}
function delK(productId){
	alert("상품을 삭제합니다.")
	location.href = "${path}/productDelete.do?productId="+productId;
}
</script>
<section>
<br>
<div align=center>
<h2>쇼핑몰 상품 상세 보기</h2>
<form action="${path}/cart.do" method=post>
<input type = hidden name = productId value ="${m.productId}">
<input type = hidden name = custNo value ="${session.custno}">

<table border=1 width=600 height=300>
<tr><td align="center" width =100px>상품번호</td>  
   <td>&emsp;${m.productId} </td>
   <td rowspan=4><img src ="${path}/product/files/${m.productImgStr}" width = 200px height=200px></td>
   </tr>
<tr><td align="center">상품이름</td>  
   <td> &emsp;${m.productName} </td></tr> 
<tr><td align="center">상품가격</td>  
   <td>&emsp;${m.productPrice} </td></tr>
<tr><td align="center">상품설명</td>  
   <td>&emsp;<textarea cols=35  rows=6 name=productDesc >${m.productDesc}  </textarea> </td></tr>
<tr><td align="center">구매수량</td>  
   <td><input type=number name=amount min=1 max=5> </td></tr>
<tr><td align="center">등록날짜</td>  
   <td colspan = 2>&emsp;
   <fmt:formatDate pattern="MM-dd" value="${m.productDate}" var="productDate"></fmt:formatDate>
    ${productDate}</td>
    </tr>
<tr><td colspan=3  align="center"> 
	<input  type=submit value="상품구매">&emsp;
    <input  type=button onclick="listK()" value="목록보기">&emsp;
    <input  type=button onclick="delK('${m.productId}')" value="삭제하기">
   </td></tr>
</table>
</form>
</div>
<br>

</section>

<c:import url="/include/bottom.jsp" />
