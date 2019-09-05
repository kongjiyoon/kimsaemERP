<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#allchk").on("click",function(){
				//id로 해도 좋고 name으로 해도 좋아요 - allchk가 체크되면 
				if($('input:checkbox[name="allchk"]').is(":checked")==true){
					//mylist로 정의된 모든 체크 박스에 대해서 작업을 처리하겠다는 의미 - each는 동일한 컴포넌트에
					//대한 반복작업을 할 때 사용하는 jquery명령문 - mylist라는 이름으로 정의된 체크박스에 동일작업
					$('input:checkbox[name="mylist"]').each(function() {
					    //현재 작업 중인 체크박스의 체크값을 true  
						this.checked = true; //checked 처리 
					      if(this.checked){//checked 처리된 항목의 값
					            alert(this.value); 
					      }
					 });

				}
			})
			
		
		})
	</script>
</head>
<body>
	<form name="myform"> 
		<input type="checkbox" name="allchk" id="allchk"/>전체선택
		<c:forEach var="i" begin="1" end="1">
			<input type="checkbox" name="mylist" value="check${i }"/>check${i }
		</c:forEach>
	</form>
</body>
</html>