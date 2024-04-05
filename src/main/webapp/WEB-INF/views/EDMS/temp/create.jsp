<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>




 <c:import url="../temp/head.jsp"></c:import>


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
	 margin-top: 1px; 
	 border-collapse: collapse; width: 800px;

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


.addbtn{
	background: rgb(221, 221, 221); 
	padding: 5px; 
	border: 1px solid black; 	 
	text-align: center; 
	color: rgb(0, 0, 0); 
	font-size: 12px; 
	font-weight: bold; 
	vertical-align: middle;
	writing-mode: vertical-lr;

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

.addlist{

	width: 800px; 
	font-family: &quot;
	malgun gothic&quot;, dotum, arial, tahoma; 
	margin-top: 10px; 
	border-collapse: collapse; 
	height: auto;


}



</style>





    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>




<div style="position: absolute; left: 30%">

<span style="font-family: &quot;맑은 고딕&quot;; font-size: 10pt; line-height: normal; margin-top: 0px; margin-bottom: 0px;">

<span style="font-family: &quot;맑은 고딕&quot;; font-size: 10pt; line-height: normal; margin-top: 0px; margin-bottom: 0px;"> 
  
<div class="row ">

	<div class="col-12 text-center align-self-center">
		<h1>휴가신청서</h1>
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
 
 
 <div class="addlist">
 
<!--  <button class="btn border color-dark" style="background-color: #DDDDDD">
 	결제선 추가
 
 </button>
  -->
  <button class="addbtn" data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-whatever="@mdo"  id="addBtn">
 	결제선 <br> 추가
 
 </button>
 
 
 
 </div>
 
 
<table class="contentsTable" >
	<colgroup> 
   <col width="140"> 
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
				 <div id="summernote"></div>
			    
			</td>
		</tr>
	</tbody>
</table>

<table class="contentsTable" >
	<colgroup> 
	   <col width="140"> 
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





<!-- modal  -->
	<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
		<div class="modal-header">
			<h5 class="modal-title" id="exampleModalLabel">New message</h5>
			<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		</div>
		<div class="modal-body">
			<form>
			<div class="mb-3">
				<label for="recipient-name" class="col-form-label">Recipient:</label>
				<input type="text" class="form-control" id="recipient-name">
			</div>
			<div class="mb-3">
				<label for="message-text" class="col-form-label">Message:</label>
				<textarea class="form-control" id="message-text"></textarea>
			</div>
			</form>
		</div>
		<div class="modal-footer">
			<button id="addBtn"  type="button" class="btn btn-primary">Send message</button>
			<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
		</div>
		</div>
	</div>
	</div>

    <script>
      $('#summernote').summernote({
        placeholder: 'Hello stand alone ui',
        tabsize: 2,
        height: 120,
        toolbar: [
          ['style', ['style']],
          ['font', ['bold', 'underline', 'clear']],
          ['color', ['color']],
          ['para', ['ul', 'ol', 'paragraph']],
          ['table', ['table']],
          ['insert', ['link', 'picture', 'video']],
          ['view', ['fullscreen', 'codeview', 'help']]
        ]
      });
    </script>





<script>
	const addbtn = document.getElementById("addBtn"); //모달 여는 버튼
	const appBtn = document.getElementById("appBtn"); //모달 확인버튼
	const myModal = document.getElementById('myModal')
	const myInput = document.getElementById('myInput')

	

	let temp = ``;

	
	모달 불러오는 함수
	addbtn.addEventListener('shown.bs.modal',function(){		
		
		myInput.focus()		

	})

	
	appBtn.addEventListener('click',()=>{
		
		
		
	})
	
	



</script>







<!-- include libraries(jQuery, bootstrap) -->
 <script src="/assets/vendor/libs/jquery/jquery.js"></script>
 <script src="/assets/vendor/js/bootstrap.js"></script>
 <script src="/assets/vendor/libs/perfect-scrollbar/perfect-scrollbar.js"></script>



