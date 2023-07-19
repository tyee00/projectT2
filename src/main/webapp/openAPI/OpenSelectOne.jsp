<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>  


<c:import url="/include/top.jsp" />
<section>
 <br>
 <div align="center">
<table border = 1>
<tr>
<td>idx</td><td>${m.idx }</td>
</tr>

<tr>
<td>rdnmadr</td><td>${m.rdnmadr }</td>
</tr>

<tr>
<td>logitude</td><td>${m.logitude }</td>
</tr>

<tr>
<td>entrprsNm</td><td>${m.entrprsNm }</td>
</tr>

<tr>
<td>rprsntvNm</td><td>${m.rprsntvNm }</td>
</tr>

<tr>
<td>latitude</td><td>${m.latitude }</td>
</tr>

<tr>
<td>mainGoods</td><td>${m.mainGoods }</td>
</tr>
<tr>
<td colspan =2 >
<div id="map" style="width:500px;height:400px;"></div>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=${key}"></script>
	<script>
		var container = document.getElementById('map');
		var options = {
			center: new kakao.maps.LatLng(${m.latitude}, ${m.logitude}),
			level: 3
		};

		var map = new kakao.maps.Map(container, options);
		
		// 마커가 표시될 위치입니다 
		var markerPosition  = new kakao.maps.LatLng(${m.latitude}, ${m.logitude}); 

		// 마커를 생성합니다
		var marker = new kakao.maps.Marker({
		    position: markerPosition
		});
		marker.setMap(map);
	</script>
</td>
</tr>

</table>
 
 
 
 
 
 </div>
 <br>
</section>
<c:import url="/include/bottom.jsp" />