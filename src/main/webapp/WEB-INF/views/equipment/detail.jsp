<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>


<!-- =========================================================
* Sneat - Bootstrap 5 HTML Admin Template - Pro | v1.0.0
==============================================================

* Product Page: https://themeselection.com/products/sneat-bootstrap-html-admin-template/
* Created by: ThemeSelection
* License: You must have a valid license purchased in order to legally use the theme for your project.
* Copyright ThemeSelection (https://themeselection.com)

=========================================================
 -->
<!-- beautify ignore:start -->
<html
  lang="en"
  class="light-style layout-menu-fixed"
  dir="ltr"
  data-theme="theme-default"
  data-assets-path="/assets/"
  data-template="vertical-menu-template-free"
>
  <head>
    <meta charset="utf-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0"
    />
    <title>Dashboard - Analytics | Sneat - Bootstrap 5 HTML Admin Template - Pro</title>
    <meta name="description" content="" />
    <script src="/assets/vendor/js/helpers.js"></script>
    <script src="/assets/js/config.js"></script>
   <!--link import  -->
    <c:import url="../temp/head.jsp"></c:import>
  </head>

  <body>
    <!-- Layout wrapper -->
    <div class="layout-wrapper layout-content-navbar">
      <div class="layout-container">
        <!-- Menu -->
		<c:import url="../temp/side.jsp"></c:import>
      
        <!-- / Menu -->

        <!-- Layout container -->
        <div class="layout-page">
          <!-- Navbar -->

          <c:import url="../temp/nav.jsp"></c:import>
	
          <!-- / Navbar -->

          <!-- Content wrapper -->
          <div class="content-wrapper">
            <!-- Content -->
            <div class="container-xxl flex-grow-1 container-p-y">
              <h4 class="fw-bold py-3 mb-4">${vo.equipment_name} 상세</h4>
              <div class="row">
			                <!-- Paragraph -->
                <div class="col-lg">
                  <div class="card mb-4">
                    <h5 class="card-header">비품 번호 : ${vo.equipment_num}</h5>
                    <input type="hidden"  id="equipment_num" value="${vo.equipment_num}" >
                    <table class="table table-borderless">
                      <tbody>
                        <tr>
                          <td class="align-middle"><small class="text-light fw-semibold">관리자 사원 번호</small></td>
                          <td class="py-3">
                            <p class="mb-0">${vo.member_id}</p>
                          </td>
                        </tr>
                        <tr>
                          <td class="align-middle"><small class="text-light fw-semibold">구매 날짜</small></td>
                          <td class="py-4">
                            <p class="lead mb-0">${vo.equipment_date}</p>
                          </td>
                        </tr>
                        <tr>
                          <td class="align-middle"><small class="text-light fw-semibold">수량</small></td>
                          <td class="py-4">
                            <p class="lead mb-0">${vo.equipment_ea}</p>
                          </td>
                        </tr>
                        <tr>
                          <td class="align-middle"><small class="text-light fw-semibold">상세 설명</small></td>
                          <td class="py-4">
                            <p class="lead mb-0">${vo.equipment_contents}</p>
                          </td>
                        </tr>                                                
                      </tbody>
                    </table>
                  </div>
                </div>	
	            </div>
					<div class="demo-inline-spacing ml-6">	
						<a class=" btn btn-primary" href="/equipment/update?equipment_num=${vo.equipment_num}">수정</a>
						<form action="/equipment/delete" method="post">
						<input type="hidden" name="equipment_num" value="${vo.equipment_num}">
						<button class="btn btn-danger" id="deleteEquipmentBtn">삭제</button>									
						</form>	
					</div>
          		  </div>		
            <!-- / Content -->
       			   
		<div class="content-backdrop fade"></div>
          </div>
          <!-- Content wrapper -->
        </div>
        <!-- / Layout page -->
      </div>

      <!-- Overlay -->
      <div class="layout-overlay layout-menu-toggle"></div>
    </div>
    <!-- / Layout wrapper -->

    <div class="buy-now">
      <a
        href="https://github.com/dirokim/aka_final.git"
        target="_blank"
        class="btn btn-primary btn-buy-now"
        >git-hub</a
      >
    </div>
	
	<!-- <script>
	const deleteEquipmentBtn = document.getElementById("deleteEquipmentBtn");
  const equipmentNum = document.getElementById("equipment_num").value;	
    deleteEquipmentBtn.addEventListener("click",()=>{
    fetch("/equipment/delete",{
      method:"POST",
      headers: {'Content-type': ' application/x-www-form-urlencoded;charset=utf-8'},
      body:"equipment_num="+equipmentNum
    }).then(result=>result.json())
    .then(result=>{
      result.parse
    })
  })
	</script> -->
	
    <!-- Core JS -->
    <!-- build:js assets/vendor/js/core.js -->
    <script src="/assets/vendor/libs/jquery/jquery.js"></script>
    <script src="/assets/vendor/libs/popper/popper.js"></script>
    <script src="/assets/vendor/js/bootstrap.js"></script>
    <script src="/assets/vendor/libs/perfect-scrollbar/perfect-scrollbar.js"></script>

    <script src="/assets/vendor/js/menu.js"></script>
    <!-- endbuild -->

    <!-- Vendors JS -->
    <script src="/assets/vendor/libs/apex-charts/apexcharts.js"></script>

    <!-- Main JS -->
    <script src="/assets/js/main.js"></script>

    <!-- Page JS -->
    <script src="/assets/js/dashboards-analytics.js"></script>

    <!-- Place this tag in your head or just before your close body tag. -->
    <script async defer src="https://buttons.github.io/buttons.js"></script>
  </body>
</html>
