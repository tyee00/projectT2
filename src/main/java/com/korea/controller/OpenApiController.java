package com.korea.controller;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.korea.k2.openApi.CompanyService;
import com.korea.k2.openApi.CompanyVO;
import com.korea.k2.openApi.EvSearchVO;

@Controller
public class OpenApiController {
	
	   @Autowired
	   private CompanyService  service;
	   
	   
	   @RequestMapping("/EvOpenSelectAllMap.do")
	   String EvOpenSelectAllMap(Model model, EvSearchVO vo) {
		   model.addAttribute("li", service.listEv(vo));
		   
		   return "/openAPI/EvOpenSelectAllMap.jsp";
	   }
	   
	   @RequestMapping("/EvOpenSelectOne.do")
	   String EvOpenSelectOne(Model model, EvSearchVO vo) {
		   model.addAttribute("m", service.selectOne(vo));
		   return "/openAPI/EvOpenSelectOne.jsp";
	   }
	   
	   @RequestMapping("/OpenSelectOne.do")
	   String OpenSelectOne(Model model, CompanyVO vo) {
		   model.addAttribute("m", service.selectOne(vo));
		   
		   return "/openAPI/OpenSelectOne.jsp";
	   }
	   
	   @RequestMapping("/OpenSelectAllMap.do")
	   String OpenSelectAllMap(Model model, CompanyVO vo) {
		   model.addAttribute("li", service.list(vo));
		   return "/openAPI/OpenSelectAllMap.jsp";
	   }
	   
	   @RequestMapping("/OpenSelectAll.do")
	   String OpenSelectAll(Model model, CompanyVO vo) throws Exception {
		   model.addAttribute("li", service.list(vo));
		   return "/openAPI/OpenSelectAll.jsp";
	   }
	   @RequestMapping("/EvOpenSelectAll.do")
	   String EvOpenSelectAll(Model model, EvSearchVO vo) throws Exception {
		   model.addAttribute("li",service.listEv(vo));
		   return "/openAPI/EvOpenSelectAll.jsp";
	   }
	   
	   
	
	   @RequestMapping("/OpenApiInsert.do")
	   String OpenApiInsert(Model model , CompanyVO vo ) throws Exception {
		   
	        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/6480000/gyeongnamgoodemploycompany/gyeongnamgoodemploycompanylist"); /*URL*/
	        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=9fUhHWkn8J23BGz8obUfEF6zSihn8D%2F0juIFYW5quBlH9Ln9LwBqnYYPTpgVjGFvuOxz1s5Yqpmj6YYxEzanQw%3D%3D"); /*Service Key (일반인증키)*/
	        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지 번호*/
	        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("25", "UTF-8")); /*한 페이지 결과 수 (최소 10, 최대 9999)*/
	        urlBuilder.append("&" + URLEncoder.encode("returnType","UTF-8") + "=" + URLEncoder.encode("xml", "UTF-8")); /*상태갱신 조회 범위(분) (기본값 5, 최소 1, 최대 10)*/
	        URL url = new URL(urlBuilder.toString());
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Content-type", "application/json");
	        System.out.println("Response code: " + conn.getResponseCode());
	        BufferedReader rd;
	        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
	            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        } else {
	            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
	        }
	        StringBuilder sb = new StringBuilder();
	        String line;
	        while ((line = rd.readLine()) != null) {
	            sb.append(line);
	        }
	        rd.close();
	        conn.disconnect();

	        // XML 데이터 읽어 오기 
	        System.out.println(sb.toString());
   
	        Node data1 = null;   
	        Node data2 = null;   
	        Node data3 = null;
	        Node data4 = null;
	        Node data5 = null;
	        Node data6 = null;
	        
	        try {
	         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	         DocumentBuilder dBuilder=dbFactory.newDocumentBuilder();
	         FileOutputStream output = new FileOutputStream("./ApiExplorer");
	         output.write(sb.toString().getBytes("UTF-8"));  // 전체 데이터 읽어 오기 
	         output.close();

	         Document doc = dBuilder.parse("./ApiExplorer");
	         doc.getDocumentElement().normalize();
	         Element body =(Element) doc.getElementsByTagName("body").item(0);
	         Element items =(Element) body.getElementsByTagName("items").item(0);

	         
	         // service.deleteAll();
	         
	         for(int i=0 ; i<=24 ; i++ ) {
	         Element item =(Element) items.getElementsByTagName("item").item(i);
	          
	         // 필요한 데이터 값 추출하기 
	         data1 = item.getElementsByTagName("rdnmadr").item(0); // 주소 
	         data2 = item.getElementsByTagName("entrprsNm").item(0); // 회사명
	         data3 = item.getElementsByTagName("rprsntvNm").item(0); // 회사대표
	         data4 = item.getElementsByTagName("mainGoods").item(0); // 주력상품
	         data5 = item.getElementsByTagName("latitude").item(0);  // 위도
	         data6 = item.getElementsByTagName("logitude").item(0);  // 경도 

	         String strData1 = data1.getChildNodes().item(0).getNodeValue();
	         String strData2 = data2.getChildNodes().item(0).getNodeValue();
	         String strData3 = data3.getChildNodes().item(0).getNodeValue();
	         String strData4 = data4.getChildNodes().item(0).getNodeValue();
	         String strData5 = data5.getChildNodes().item(0).getNodeValue();
	         String strData6 = data6.getChildNodes().item(0).getNodeValue();
	         
	         System.out.println( strData1 + " " + strData2 + " " + strData3 + " "  + strData4 + " " + strData5 + " " + strData6 );
        
	         vo.setRdnmadr(strData1);
	         vo.setEntrprsNm(strData2);
	         vo.setRprsntvNm(strData3);
	         vo.setMainGoods(strData4);
	         vo.setLatitude(strData5);
	         vo.setLogitude(strData6);
	         
	         service.insert(vo);        
	         
	         }         

	        } catch (Exception e) {
	         e.printStackTrace();
	        }
	        
	      return "/index.jsp";        
    }
	

	   @RequestMapping("/EvInsert.do")
	   String EvInsert(Model model , EvSearchVO vo ) throws Exception {
		   
	        StringBuilder urlBuilder = new StringBuilder("http://openapi.kepco.co.kr/service/EvInfoServiceV2/getEvSearchList"); /*URL*/
	        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=9fUhHWkn8J23BGz8obUfEF6zSihn8D%2F0juIFYW5quBlH9Ln9LwBqnYYPTpgVjGFvuOxz1s5Yqpmj6YYxEzanQw%3D%3D"); /*Service Key (일반인증키)*/
	        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("4", "UTF-8")); /*페이지 번호*/
	        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("396", "UTF-8")); /*한 페이지 결과 수 (최소 10, 최대 9999)*/
	        urlBuilder.append("&" + URLEncoder.encode("returnType","UTF-8") + "=" + URLEncoder.encode("xml", "UTF-8")); /*상태갱신 조회 범위(분) (기본값 5, 최소 1, 최대 10)*/
	        URL url = new URL(urlBuilder.toString());
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Content-type", "application/json");
	        System.out.println("Response code: " + conn.getResponseCode());
	        BufferedReader rd;
	        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
	            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        } else {
	            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
	        }
	        StringBuilder sb = new StringBuilder();
	        String line;
	        while ((line = rd.readLine()) != null) {
	            sb.append(line);
	        }
	        rd.close();
	        conn.disconnect();

	        // XML 데이터 읽어 오기 
	        System.out.println(sb.toString());
   
	        Node data1 = null;   
	        Node data2 = null;   
	        Node data3 = null;
	        Node data4 = null;

	        
	        try {
	         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	         DocumentBuilder dBuilder=dbFactory.newDocumentBuilder();
	         FileOutputStream output = new FileOutputStream("./ApiExplorer");
	         output.write(sb.toString().getBytes("UTF-8"));  // 전체 데이터 읽어 오기 
	         output.close();

	         Document doc = dBuilder.parse("./ApiExplorer");
	         doc.getDocumentElement().normalize();
	         Element body =(Element) doc.getElementsByTagName("body").item(0);
	         Element items =(Element) body.getElementsByTagName("items").item(0);

	         
	         // service.deleteAll();
	         
	         for(int i=0 ; i<=395 ; i++ ) {
	         Element item =(Element) items.getElementsByTagName("item").item(i);
	          
	         // 필요한 데이터 값 추출하기 
	         data1 = item.getElementsByTagName("addr").item(0); // 주소 
	         data2 = item.getElementsByTagName("cpNm").item(0); // 회사명
	         data3 = item.getElementsByTagName("cpStat").item(0); // 회사대표
	         data4 = item.getElementsByTagName("csNm").item(0); // 회사대표

	         String strData1 = data1.getChildNodes().item(0).getNodeValue();
	         String strData2 = data2.getChildNodes().item(0).getNodeValue();
	         String strData3 = data3.getChildNodes().item(0).getNodeValue();
	         String strData4 = data4.getChildNodes().item(0).getNodeValue();

	         
	         System.out.println( strData1 + " " + strData2 + " " + strData3 + " " + strData4 );
        
	         vo.setAddr(strData1);
	         vo.setCpNm(strData2);
	         vo.setCpStat(strData3);
	         vo.setCsNm(strData4);
	         
	         service.insertEv(vo);        
	         
	         }         

	        } catch (Exception e) {
	         e.printStackTrace();
	        }
	        
	      return "/index.jsp";        
    }
		  

}
