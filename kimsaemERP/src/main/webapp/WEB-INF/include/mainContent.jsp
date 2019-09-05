<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="/kimsaemERP/common/css/main.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
/* Remove the navbar's default margin-bottom and rounded borders */
.navbar {
	margin-bottom: 0;
	border-radius: 0;
}

</style>
<script type="text/javascript">
	$(document).ready(function() {
		//id속성이 boardCategory로 정의된 모든 li에 익명의 함수를 적용하겠다는 의미
		$("#boardCategory>li").each(function(){
			$(this).click(function(){
				//alert("선택됨")
				//alert($("#boardMain").outerWidth())
				//alert($("#boardMain").outerHeight())
				//현재 작업 중인 객체가 click되면 ajax를 요청할 수 있도록 처리
				category = $(this).text();
				//alert(category);
				$("#boardCategory>li").removeAttr("class")
				$(this).attr("class","active");
				$.ajax({
					url:"/kimsaemERP/board/ajax_boardlist.do",
					type:"get",
					data:{
						"category":category	},
					success:function(data){
			//c:\> imp 사용자/패스워드 file='d:\dumpfile.dmp' tables = tablename ignore = y
						//alert(data[0].title+","+data[0].write_date);
						mydata="";//조회한 json객체안의 모든 데이터를 꺼내서 추가할 변수
						for(i=0;i<data.length;i++){
							mydata = mydata +
							"<tr><td class='boardContent' style=''><a href='/kimsaemERP/board/user/read.do?board_no="+data[i].board_no+"&state=READ'>"
							+data[i].title+
							"</a></td><td class='boardDate' style=''>"
							+data[i].write_date+"</td></tr>"
						}
						//alert(mydata);
						$("#mydatalist").empty();
						$("#mydatalist").append(mydata);
					},
					error:function(a,b,c){//ajax실패시 원인(에러메시지)
						alert(c);
					}
					
				});
			})
		})
	})
</script>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-sm-7">
				<div id="myCarousel" class="carousel slide" data-ride="carousel"
					style="width: 600px; height: 300px">
					<!-- Indicators -->
					<ol class="carousel-indicators">
						<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
						<li data-target="#myCarousel" data-slide-to="1"></li>
						<li data-target="#myCarousel" data-slide-to="2"></li>
						<li data-target="#myCarousel" data-slide-to="3"></li>
					</ol>

					<!-- Wrapper for slides -->
					<div class="carousel-inner" role="listbox">
						<div class="item active">
							<img src="/kimsaemERP/images/ktds1.jpg" alt="Image"
								style="width: 600px; height: 300px">

						</div>

						<div class="item">
							<img src="/kimsaemERP/images/ktds2.jpg" alt="Image"
								style="width: 800px; height: 300px">

						</div>
						<div class="item">
							<img src="/kimsaemERP/images/ktds3.jpg" alt="Image"
								style="width: 600px; height: 300px">

						</div>

						<div class="item">
							<img src="/kimsaemERP/images/ktds4.jpg" alt="Image"
								style="width: 800px; height: 300px">

						</div>
					</div>

					<!-- Left and right controls -->
					<a class="left carousel-control" href="#myCarousel" role="button"
						data-slide="prev"> <span
						class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
						<span class="sr-only">Previous</span>
					</a> <a class="right carousel-control" href="#myCarousel" role="button"
						data-slide="next"> <span
						class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
						<span class="sr-only">Next</span>
					</a>
				</div>
			</div>
			<div class="col-sm-5">
				<div class="panel panel-primary"
					style="border-color: #edeef1; height: 300px; width: 450px">
					<div class="panel-footer">커뮤니티</div>
					<div class="panel-body">
						<ul class="nav nav-tabs" id="boardCategory">
							<li class="active"><a href="#">게시판</a></li>
							<li><a href="#">사내소식</a></li>
							<li><a href="#">경조사</a></li>
						</ul>
						<div id="boardMain" style="padding-top: 20px; padding-left: 10px;width: 450px;height: 150px">
							<table id="mydatalist">
							<c:forEach var="board" items="${boardlist}">
								<tr>
									<td class="boardContent" style=""><a href="/kimsaemERP/board/read.do?board_no=${board.board_no}&state=READ">${board.title }</a></td>
									<td class="boardDate" style="">${board.write_date }</td>
								</tr>
							</c:forEach>
							<!--	<tr>
									<td class="boardContent" style="">kimsaemkimsaemERP ver1.0출시</td>
									<td class="boardDate" style="">2019.08.12</td>
								</tr>
								<tr class="boardRow">
									<td class="boardContent">사옥 이전날짜 확정</td>
									<td class="boardDate">2019.08.11</td>
								</tr>
								<tr class="boardRow">
									<td class="boardContent">보안의 날 참석 인원 확정</td>
									<td class="boardDate">2019.08.11</td>
								</tr>
								 <tr class="boardRow">
									<td class="boardContent" >2차 프로젝트 발표 날짜 확정 통보</td>
									<td class="boardDate">2018.07.10</td>
								</tr> -->
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
		<hr />
		<div class="row main-row">
			<div class="col-sm-3">
				<div class="panel panel-primary"
					style="border-color: #edeef1; height: 300px">
					<div class="panel-footer">News</div>
					<div class="panel-body"></div>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="panel panel-primary"
					style="border-color: #edeef1; height: 300px">
					<div class="panel-footer">회사소식</div>
					<div class="panel-body"></div>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="panel panel-primary"
					style="border-color: #edeef1; height: 300px">
					<div class="panel-footer">회사소식</div>
					<div class="panel-body"></div>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="panel panel-primary"
					style="border-color: #edeef1; height: 300px">
					<div class="panel-footer">회사소식</div>
					<div class="panel-body"></div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>