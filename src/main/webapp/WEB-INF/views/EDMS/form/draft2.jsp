<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>




 <c:import url="../../temp/head.jsp"></c:import>


<style>

.infotable{
	 border: 0px solid rgb(0, 0, 0);
	 width: 800px; 
	 font-family: malgun gothic, dotum, arial, tahoma; 
	 margin-top: 1px; 
	 border-collapse: collapse;"
}

.userTable{
	border: 1px solid rgb(0, 0, 0);
	 font-family: &quot;
	 malgun gothic&quot;, 
	 dotum, arial, tahoma; 
	 margin-top: 3px; 
	 border-collapse: collapse;
	 width: 800px;

}

.userTdG{
	background: rgb(221, 221, 221); 
	padding: 5px; 
	border: 1px solid black; 
	height: 18px; 
	text-align: center; 
	color: rgb(0, 0, 0); 
	font-size: 12px; 
	font-weight: bold; 
	vertical-align: middle;


}
.userTdW{
	background: rgb(255, 255, 255); 
	padding: 5px; 
	border: 1px solid black; 
	height: 18px; 
	text-align: center; 
	color: rgb(0, 0, 0); 
	font-size: 12px; 
	font-weight: bold; 
	vertical-align: middle;
}
.contentsTable{
	border: 2px solid; 
	width: 800px; 
	font-family: &quot;
	malgun gothic&quot;, dotum, arial, tahoma; 
	margin-top: 10px; 
	border-collapse: collapse; 
	height: auto;


}

.applineG{
	background: rgb(221, 221, 221);
	border: 1px solid black; 
	padding: 1px; 
	height: 10px; 
	text-align: center; 
	color: rgb(0, 0, 0); 
	font-size: 12px; 
	vertical-align: middle;"
}

.applineW{
	background: rgb(255, 255, 255);
	border: 1px solid black; 	
	width : 80px;
	height: 50px;	
	text-align: center; 
	color: rgb(0, 0, 0); 
	font-size: 15px; 
	vertical-align: middle;
	
}

.appTable{
	 border: 0px solid rgb(0, 0, 0);	 
	 font-family: malgun gothic, dotum, arial, tahoma; 
	 margin-top: 1px; 
	 border-collapse: collapse;"
	 }


</style>






<div style="position: absolute; left: 30%">

<span style="font-family: &quot;맑은 고딕&quot;; font-size: 10pt; line-height: normal; margin-top: 0px; margin-bottom: 0px;">

<span style="font-family: &quot;맑은 고딕&quot;; font-size: 10pt; line-height: normal; margin-top: 0px; margin-bottom: 0px;"> 
  
<div class="row " >

	 <div class="col-5 text-center align-self-center">
		<h1>휴가신청서</h1>
	</div>
	<!--<div class="col-7" >
	<div class="row justify-content-end">
	<div class="col-auto ps-0 pe-0">
		<div class="border p-2 fs-5">직급</div>
		<div class="border p-2 fs-5">이름</div>
		<div class="border p-2 fs-5">날짜</div>
	</div>
	<div class="col-auto ps-0 pe-0">
		<div class="border p-2 fs-5">직급</div>
		<div class="border p-2 fs-5">이름</div>
		<div class="border p-2 fs-5">날짜</div>
	</div>
	<div class="col-auto ps-0 pe-0">
		<div class="border p-2 fs-5">직급</div>
		<div class="border p-2 fs-5">이름</div>
		<div class="border p-2 fs-5">날짜</div>
	</div>
	<div class="col-auto ps-0 pe-0">
		<div class="border p-2 fs-5">직급</div>
		<div class="border p-2 fs-5">이름</div>
		<div class="border p-2 fs-5">날짜</div>
	</div>
	<div class="col-auto ps-0 pe-0">
		<div class="border p-2 fs-5">직급</div>
		<div class="border p-2 fs-5">이름</div>
		<div class="border p-2 fs-5">날짜</div>
	</div>
	<div class="col-auto ps-0">
		<div class="border p-2 fs-5">직급</div>
		<div class="border p-2 fs-5">이름</div>
		<div class="border p-2 fs-5">날짜</div>
	</div>
	</div>
	</div> -->
	<div class="col-7">
		 <table class="appTable" style="float: right;">
			<tr >
				<td class="applineG" >
					<p>직급</p>
				</td>
			</tr>
			<tr>			
				<td class="applineW" >
					<p>이름이다</p>				
				</td>				
			</tr>
			<tr>			 
				<td class="applineG" >
					<p>날짜</p>				
				</td>	
		</table> 
	</div>
</div>


				
<table class="userTable" ><!-- User --> 
      <colgroup> 
       <col width="60"> 
       <col width="140">       
       <col width="60"> 
       <col width="140"> 
      </colgroup> 
      
	<tbody>
		<tr>
			<td class="userTdG">
				
 문서번호 
			</td>
			<td class="userTdW">	
			
			</td>
			<td class="userTdG">				
 문서번호 
			</td>
			<td class="userTdW">	
			
			</td>
		</tr>
		<tr style="height: 32px;">
			<td class="userTdG">
				
 부&nbsp;&nbsp;&nbsp;서
			</td>
			<td class="userTdW">	
			</td>
				<td class="userTdG">
 부&nbsp;&nbsp;&nbsp;서
			</td>
			<td class="userTdW">	
			</td>
		</tr>
		<tr>
			<td class="userTdG">	
기&nbsp;안&nbsp;일
			</td>
			<td class="userTdW">	
			</td>
			<td class="userTdG">
기&nbsp;안&nbsp;일
			</td>
			<td class="userTdW">		
			</td>
		</tr>		
	</tbody>
</table>
 
 
<table class="contentsTable" >
	<colgroup> 
   <col width="116"> 
   <col width="660"> 
  </colgroup> 
  
	<tbody>
		<tr>
			<td class="userTdG">	
참&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;조
			</td>
			<td class="userTdW">		
			</td>
		</tr>
		<tr>
			<td class="userTdG">		
제&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;목
			</td>
			<td class="userTdW">	
			</td>
		</tr>
		<tr>
			<td class="userTdG" colspan="2">
상&nbsp;&nbsp;세&nbsp;&nbsp;내&nbsp;&nbsp;용
			</td>
		</tr>
		<tr>
			<td class="userTdW" colspan="2">			
				<span  style="width: 100%; font-family: &quot;malgun gothic&quot;, dotum, arial, tahoma; font-size: 9pt; line-height: normal; margin-top: 0px; margin-bottom: 0px;">
					<span class="comp_editor" style="width: 100%; font-family: &quot;malgun gothic&quot;, dotum, arial, tahoma; font-size: 11pt; line-height: 200px; margin-top: 0px; margin-bottom: 0px;">
						
					</span>	
				
			
				</span> 
			<br>				
				
			    
			</td>
		</tr>
	</tbody>
</table>
</table>
			    

<table class="contentsTable" >
	<colgroup> 
	   <col width="116"> 
	   <col width="660"> 
	 </colgroup> 
  
	<tbody>
		<tr>
			<td class="userTdG">	
				참&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;조
			</td>
			<td class="userTdW">		
			
			</td>
		</tr>
	
	</tbody>

</table>



</span></span>
<p style="font-family: &quot;맑은 고딕&quot;; font-size: 10pt; line-height: 20px; margin-top: 0px; margin-bottom: 0px;"><br></p>

</div>




<!-- include libraries(jQuery, bootstrap) -->
 <script src="/assets/vendor/libs/jquery/jquery.js"></script>
 <script src="/assets/vendor/js/bootstrap.js"></script>
 <script src="/assets/vendor/libs/perfect-scrollbar/perfect-scrollbar.js"></script>



