<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 

<!DOCTYPE html>

<head>
	<link rel="stylesheet" href="/assets/vendor/fonts/boxicons.css" />
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jstree/3.2.1/themes/default/style.min.css" />
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script> 	
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
	

</head>


 <c:import url="../temp/head.jsp"></c:import>
 <c:import url="/js/edms/form.css"></c:import>




    
	

<style>

.display-flex {
	display: flex;
}


#department-box {
	height: 430px;
	width: 200px;
	border: 1px solid #D9D9D9;
	margin-right: 20px;
}

#department-box>button {
	justify-content: center;
	background-color: white;
}

/*--main-color-lt:#BDDFFF;  밝은 하늘색 버튼 
  --main-color-bl:#96C1E8;  하늘색 버튼 
  --main-color-dk:#5F90CB;  어두운 하늘색 버튼 */
#department-box>button:hover {
	color: #96C1E8;
}

#people-box {
	height: 430px;
	width: 350px;
	border: 1px solid #D9D9D9;
}


/*	        .modalBox button {
          display: block;
          width: 80px;
          margin: 0 auto;
        }
*/


#first-arrow,
#second-arrow,
#three-arrow,
#four-arrow {
	height: 10px;
	width: 10px;
	background-color: white;
	margin-right: 30px;
	margin-left: 10px;
}

#first-arrow {
	margin-top: 60px;
	margin-bottom: 30px;
}

#second-arrow {
	margin-bottom: 170px;
}

#three-arrow {
	margin-bottom: 30px;
}

#line-box {
	height: 200px;
	width: 350px;
	border: 1px solid #D9D9D9;
	margin-bottom: 30px;
}

#refer-box {
	height: 200px;
	width: 350px;
	border: 1px solid #D9D9D9;
}

#add-remove {
	display: flex;
	flex-direction: column;
}

#add-remove button {
	padding: 0px;
}


#line-box-text {
	/* 결재선 글씨 */
	margin: 10px;
	font-weight: bold;
	font-size: 20px;
}

#refer-box-text {
	/* 참조선 글씨 */
	margin: 10px;
	font-weight: bold;
	font-size: 20px;
}

#close-button {
	margin-top: 20px;
	margin-left: 750px;
	width: 100px;
	height: 40px;
	background-color: #D9D9D9;
}

#regist-button {
	margin-top: 20px;
	margin-left: 10px;
	width: 100px;
	height: 40px;

}


#people-box {
	font-size: 15px;
}


#approveAssign{
	margin-left: 30px;
}

#fileClickId{
	border: 1px solid  #D9D9D9;
	background-color: white;
}

#fileClickId:hover{
	color:  #D9D9D9;
}

#cStyle{
	width: 500px;
	line-height: 100px;
	font-size: 30px;
	text-align: center;
	color: green;
}

#rStyle{
	width: 500px;
	line-height: 100px;
	font-size: 30px;
	text-align: center;
	color: red;
}

#wStyle{
	width: 500px;
	line-height: 100px;
	font-size: 30px;
	text-align: center;
	color: var(--main-color-lt);
}

#pStyle{
	width: 500px;
	line-height: 100px;
	font-size: 30px;
	text-align: center;
	color: aqua;
}

#pencil{
	width: 30px;
	height: 30px;
	margin-left: 630px;
}

#pencilFont{
	font-size: 15px;
	
}


</style>


<form id="formelem">


<div style="position: absolute; left: 30%">

<span style="font-family: &quot;맑은 고딕&quot;; font-size: 10pt; line-height: normal; margin-top: 0px; margin-bottom: 0px;">

<span style="font-family: &quot;맑은 고딕&quot;; font-size: 10pt; line-height: normal; margin-top: 0px; margin-bottom: 0px;"> 
  
<div class="row">

	 <div class="col-6 text-center align-self-center">
		<h1>기안서</h1>
	</div>
	
	<div class="col-6">
	 
	
	   <button class="addLineBtn" type="button" data-bs-toggle="modal" data-bs-target="#largeModal" data-bs-whatever="@mdo"  id="addLineBtn">
 				결제선 <br> 추가 
 		</button>
 

		<div id="appLine" class="appTable" style=" float: right;">
			
			
			<!--  <div class="col-auto ps-0 pe-0">
				<div class="applineG">직급</div>
				<div class="applineW">1</div>
				<div class="applineG">날짜</div>
			</div>			
			 <div class="col-auto ps-0 pe-0">
				<div class="applineG">직급</div>
				<div class="applineW">2</div>
				<div class="applineG">날짜</div>
			</div>			
			 <div class="col-auto ps-0 pe-0">
				<div class="applineG">직급</div>
				<div class="applineW">3</div>
				<div class="applineG">날짜</div>
			</div>			
		
		 -->
			
			<c:set var="listLength" value="${fn:length(list)}" />
			<c:forEach items="${list}" var="list" begin="0" end="${listLength -1}">		
				
				<div class="col-auto ps-0 pe-0">
					<div class="applineG">${list.POSITION_NAME}</div>
					<div class="applineW">${list.USERNAME}</div>
					<div class="applineG"></div>
				</div> 
			
			</c:forEach>
 			
			
		</div>
		
		
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
				문서종류 
			</td>
			<td class="userTdW">	
				<input type="text" name="edmsFromNo" value="1">
			</td>
			<td class="userTdG">				
 				기&nbsp;안&nbsp;일
			</td>
			<td class="userTdW">	
				<span>기&nbsp;안&nbsp;일</span>
			</td>
		</tr>
		<tr style="height: 32px;">
			<td class="userTdG">
				
 				작&nbsp;성&nbsp;자
			</td>
			<td class="userTdW">	
				<input type="text" name="edmsCreator" value="666">
			</td>
				<td class="userTdG">
				사&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;번
			</td>
			<td class="userTdW">	
				<span>사번</span>
			</td>
		</tr>
		<tr>
			<td class="userTdG">	
				부&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;서
			</td>
			<td class="userTdW">	
			</td>
			<td class="userTdG">
				직&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;급
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
		<!-- <tr>
			<td class="userTdG">	
				참&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;조
			</td>
			<td class="userTdW">		
				<input>
			</td>
		</tr> -->
		<tr>
			<td class="userTdG">		
				제&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;목
			</td>
			<td class="userTdW">	
				<input name="edmsTitle">
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
				 <textarea id="summernote" name="edmsContent"></textarea>	
				
			
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
			<td class="userTdG" style="height: auto;">	
				첨&nbsp;&nbsp;부&nbsp;&nbsp;파&nbsp;&nbsp;일
			</td>
			<td class="userTdW" style="height: auto;">		
				<div id="fileUploadList" style="float: left;">
				</div>
				 <input type="file" id="file" name="file" multiple="multiple">
			</td>
		</tr>
	
	</tbody>

</table>

<br>
<div style="float: right;">
<button type="submit" class="btn btn-success" id="applyBtn">제출</button>
<button type="button" class="btn btn-warning">임시저장</button>
</div>


</span></span>
<p style="font-family: &quot;맑은 고딕&quot;; font-size: 10pt; line-height: 20px; margin-top: 0px; margin-bottom: 0px;"><br></p>

</div>

</form>




<!-- modal  -->
	<div class="modal fade" id="largeModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg">
		<div class="modal-content" >
		<div class="modal-header">
			<h5 class="modal-title" id="largeModal">New message</h5>
			<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		</div>
		<div class="modal-body" style="display: flex;">			
 			
			<div id="people-box" style="overflow:scroll;">
			  <div id="jstree">



				
			  </div>
			  <input id="schName" value="">
		    </div>
		    
			<div id="add-remove">
				<span id="first-arrow">
				    <button type="button" style="width: 30px; height: 30px; background-color:white; border:0;">
			  			<img src="/img/arrow/right.svg" height="30px" width="30px" onclick="applyOn();" >
					</button>
				</span>
			
				<span id="second-arrow">
						<button type="button" style="width: 30px; height: 30px; background-color:white; border:0;">
						    <img src="/img/arrow/left.svg" height="30px" width="30px" onclick="applyOff();" >
						</button>
				</span>
			
				<span id="three-arrow">
					<button type="button"style="width: 30px; height: 30px; background-color:white; border:0;">
					  <img src="/img/arrow/right.svg" height="30px" width="30px" onclick="referOn();" >
					</button>
				</span>
				
				<span id="four-arrow">
					<button type="button"  style="width: 30px; height: 30px; background-color:white; border:0;">
					  <img src="/img/arrow/left.svg" height="30px" width="30px" onclick="referOff();" >
					</button>
				</span>	
			</div>
		    
		    <div id="line-refer-box">
		    		<div id="line-box">
		    			<p id="line-box-text">결재선</p>
		    		</div>
		    		
		    		<div id="refer-box">
		    			<p id="refer-box-text">참조선</p>
	
		    		</div>
		    </div>
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
        height: 400,
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
<!-- include libraries(jQuery, bootstrap) -->


<script src="/assets/vendor/libs/jquery/jquery.js"></script>
<script src="/assets/vendor/js/bootstrap.js"></script>
<script src="/assets/vendor/libs/perfect-scrollbar/perfect-scrollbar.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jstree/3.2.1/jstree.min.js"></script>

<script>

	const addLineBtn = document.getElementById("addLineBtn"); //모달 여는 버튼
	const addBtn = document.getElementById("addBtn"); //모달 확인버튼
	const myModal = document.getElementById('myModal');
	const myInput = document.getElementById('myInput');
	const applyBtn = document.getElementById('applyBtn');
	const formelem = document.getElementById('formelem');
	const jstree = document.getElementById('jstree_demo_div');
	

	
	//모달 불러오는 함수

	addLineBtn.addEventListener('click', e=>{
		console.log("1qewqeq");
		fSch();
		
	})

	addLineBtn.addEventListener('shown.bs.modal',function(){		
		myInput.focus()	
	});

	
	//파일 업로드
	
	// const dataTranster = new DataTransfer()
	
	
	
	// let files= [];
	
	// inputFile.onchange=()=>{			
	// 	/* files.push(inputFile.files); */
	// 	/* fileUploadList.innerText =+ files[0].name; */
			
	// 	Array.from(files)
	//     .filter(file => file.lastModified != removeTargetId)
	//     .forEach(file => {
	//         dataTranster.items.add(file);
	//     });

	// 	document.querySelector('#file-input').files = dataTranster.files;
	// 	console.log( dataTranster.files);
		
	// }
	
	let ar = new Array();
	
	ar.push("a");
	ar.push("b");

	applyBtn.addEventListener('click',function(e){	
		e.preventDefault();
		if(confirm('제출하시겠습니까??')){			
			let formData = new FormData(formelem);
			
			//배열생성후 formdata에 값 추가
			ar.forEach((vlaue, index) => {
				
				formData.append("ar",vlaue);

			})
			for(const key of formData.keys()){

				console.log(key);
			}

			fetch("apply",{
				method: "POST",						
				body: formData				
				}).then(response => response.json())
				.then(response=>check(response));							
			}else{
				alert("놉");
			}		
	})
	
		// applyBtn.addEventListener('click', function(e){
		// 	e.preventDefault;
		// 	formelem.setAttribute("action","apply");
		// 	formelem.setAttribute("method","post");
		// 	formelem.setAttribute("enctype","multipart/form-data");
		// 	formelem.submit();

		// })


	function check(result){

		console.log(result.edmsTitle)
		console.log(result);
		alert(result.result);

	}

	
	//JsTree
	
	// $(function () { $('#jstree_demo_div').jstree(); });

	
	// $('#jstree_demo_div').on("changed.jstree", function (e, data) {
	// 	  console.log(data.selected);
	// 	});
	
	// $('button').on('click', function () {
	// 	  $('#jstree').jstree(true).select_node('child_node_1');
	// 	  $('#jstree').jstree('select_node', 'child_node_1');
	// 	  $.jstree.reference('#jstree').select_node('child_node_1');
	// 	});
	



// jstree 초기화 함수

    
	let jsonAr =[  { "id" : "S1", "parent" : "#", "text" : "SI 사업부", "icon" : "glyphicon glyphicon-home" },
    { "id" : "S2", "parent" : "#", "text" : "솔루션 사업부","alias":"ㅋㅋㅋ" , "icon" : "glyphicon glyphicon-home"  },
    { "id" : "S3", "parent" : "#", "text" : "AI 사업부", "icon" : "glyphicon glyphicon-home"  },
    { "id" : "S11", "parent" : "S1", "text" : "공공SI" , "icon" : "glyphicon glyphicon-picture"},
    { "id" : "S12", "parent" : "S1", "text" : "일반SI", "icon" : "glyphicon glyphicon-picture" },
    { "id" : "S21", "parent" : "S2", "text" : "그룹웨어" ,"icon" : "glyphicon glyphicon-picture" },
    { "id" : "S22", "parent" : "S2", "text" : "MES" , "icon" : "glyphicon glyphicon-picture"},
    { "id" : "S23", "parent" : "S2", "text" : "ERP", "icon" : "glyphicon glyphicon-picture" },
    { "id" : "S31", "parent" : "S3", "text" : "이미지처리" , "icon" : "glyphicon glyphicon-picture"},
    { "id" : "S32", "parent" : "S3", "text" : "음성처리" , "icon" : "glyphicon glyphicon-picture"},
    { "id" : "S33", "parent" : "S3", "text" : "자연어처리" , "icon" : "glyphicon glyphicon-picture"},
    { "id" : "J01", "parent" : "S11", "text" : "송불곰" , "icon": "glyphicon glyphicon-user" },
    { "id" : "J02", "parent" : "S31", "text" : "강사자" , "icon": "glyphicon glyphicon-user"},
    { "id" : "J03", "parent" : "S22", "text" : "송호랑", "icon": "glyphicon glyphicon-user" },
    { "id" : "J04", "parent" : "S32", "text" : "이늑대" , "icon": "glyphicon glyphicon-user"},
    { "id" : "J05", "parent" : "S33", "text" : "감여우", "icon": "glyphicon glyphicon-user" },
    { "id" : "J06", "parent" : "S12", "text" : "공수달" , "icon": "glyphicon glyphicon-user"},
    { "id" : "J07", "parent" : "S23", "text" : "황악어" , "icon": "glyphicon glyphicon-user"},
    { "id" : "J08", "parent" : "S22", "text" : "홍문어" , "icon": "glyphicon glyphicon-user"}]


	function fSch() {
            console.log("껌색할께영");
            $('#jstree').jstree(true).search($("#schName").val());
        }

        //중요 속성, original, icon, state
        // root node는 parent를 #

        //Default 설정 바꾸깅, 아래를 주석 처리해보면 모양이 어케 바뀔깡?
        $.jstree.defaults.core.themes.variant = "large";

        //맹글기, 옵션없이(디폴트 옵션으로, 요렇게는 잘 안씀)
        //$("#jstree").jstree();   // creates an instance
        //$('#tree2').jstree(true); // get an existing instance (will not create new instance)

        //일반적으로 요렇게만 사용해도 충분!
        $("#jstree").jstree({
            "plugins": ["search","wholerow","types" ],
			"check_callback": true,  // 요거이 없으면, create_node 안먹음
            'core': {
                'data':{
                    "url": 'api/chart',
					'dataType':'json' // ajax로 요청할 URL
                    } 
				// 'data' : jsonAr,
				},
			"types":{
				"member" :{
					"icon" : "bx bx-user" 
				},
				"dept" : {
					"icon" : "bx bxs-building"
				}

			}
                   
                
            
        });


        /* 보통은 위 방식으로 충분하지만, 좀더 세밀한 제어를 하고 싶다면, 
           직접 ajax구현 및 데이터 조작후 callback함수 cb를 이용하여 data세팅
        $("#jstree").jstree({
            "plugins": ["search"],
            'core': {
                'data': function (obj, cb) {
                    console.log("ck1:", obj,this);

                    let xhr = new XMLHttpRequest();
                    xhr.open("get", "alldata.json", true);
                    xhr.onreadystatechange = function () {
                        if (xhr.readyState == 4 && xhr.status == 200) {
                            console.log(xhr.responseText);
                            cb.call(obj, JSON.parse(xhr.responseText));
                            $('#jstree').jstree(true)
                        }
                    }
                    xhr.send();
                },
               "check_callback": true  // 요거이 없으면, create_node 안먹음
            }
        });
        */



        //이벤트
        $('#jstree').on("changed.jstree", function (e, data) {
            console.log(data.selected);
        });

        // Node 열렸을 땡
        let isAdded = false;
        $('#jstree').on("open_node.jstree", function (e, data) {
            console.log("open되었을땡", data.node);

            // 자식 NODE 맹글기, NODE ID S22(MES)가 열렷을 때
            // 한번만 김지은 추가하는 예제, 메소드 리스트에서 create_node검색
            if (!isAdded && data.node.id == 'S22') {
                let myNode = {
                    "text": "김지은",
                    "id": "J09",
                    "whoisshe": "actress",
                    "isBestFriend": "Y",
                    "icon": "glyphicon glyphicon-user"
                };
                let myCallBack = () => {
                    alert("추가했어용");
                }
                // NODE 추가
                $('#jstree').jstree(true).create_node('S22', myNode, "last", myCallBack);
                isAdded = true;
            }

        });

        // Node 선택했을 땡
        $('#jstree').on("select_node.jstree", function (e, data) {
            console.log("select했을땡", data.node);
        });

		

    





</script>







