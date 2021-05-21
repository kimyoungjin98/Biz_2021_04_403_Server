<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

@import url('https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&display=swap');
.jm-font{
		font-family: 'Nanum Pen Script', cursive;
		color: white;
	}

body{
	color: navy;
}

form.V1 {
	width: 80%;
	margin: 10px auto;
}


form.V1 label, form.V1 input, form.V1 textarea{
	display: inline-block;
	padding: 5px;
	margin: 5px;
}

form.V1 label {
	
	width: 150px;
	text-align: right;
	
}

form.V1 input, form.V1 textarea{
	
	width: 300px;
	border: 1px solid #0072ff;
	border-radius: 5px;
}

form.V1 button{
	outline:0;
	border:0;
	width:100px;
	color:white;
	padding:5px;
	font-size:25px;
}

form.V1 fieldset {
	border:5px solid #0072ff;
	border-radius: 20px;
	padding:5px;
	
		
}

form.V1 button:nth-child(2) {
	background-color:#0072ff;
	
}

form.V1 button:nth-child(3) {
	background-color:#0072ff;
	
}

form.V1 button:nth-child(4) {
 	background-color:#0072ff;
}

form.V1 button:hover{
	box-shadow: 1px 1px 1px rgba(0,0,0,0,1);
}


</style>
<script>
document.addEventListener("DOMContentLoaded",function(){
	
	document
	.querySelector("button.btn_save")
	.addEventListener("click",function(ev){
		
		
		
		let dom = document;
		
		let gb_writer 
		= dom.querySelector("input[name='gb_writer']");
		
		let gb_email 
		= dom.querySelector("input[name='gb_email']");
		
		let gb_password
		= dom.querySelector("input[name='gb_password']");
		
		let gb_content
		= dom.querySelector("textarea");
		
		
		
			if(gb_writer.value == ""){
				alert("작성자 이름은 반드시 입력해야 합니다")
				// dom.querySelector("input[name='gb_writer']").focus()
				gb_writer.focus();
				return false;
			}
		
			if(gb_email.value == ""){
				alert("작성자 이메일을 입력하세요")
				gb_email.focus()
				return false;
			}
			
			if(gb_password.value == ""){
				alert("작성자 비밀번호를 입력하세요")
				gb_password.focus()
				return false;
			}
			
			if(gb_content.value == ""){
				alert("작성자 비밀번호를 입력하세요")
				gb_content.focus()
				return false;
			}
			
			alert("저장버튼"
					+ gb_writer.value + "\n"
					+ gb_email.value + "\n"
					+ gb_password.value + "\n"
					+ gb_content.value + "\n")
					
			// 서버로 전송하라
			dom.querySelector("form.V1").submit();
	})
	
})

</script>
</head>
<body>
	<%@ include file="/WEB-INF/views/include_nav.jsp"%>
	<form class="V1" method="POST">
		<fieldset>
	<legend>방명록 쓰기</legend>
			<div>
				<label>작성일자</label> 
				<input name="gb_date" type="date" value="${GB.gb_date}">
			</div>

			<div>
				<label>작성시각</label> 
				<input name="gb_time" type="time" value="${GB.gb_time}">
			</div>

			<div>
				<label>작성자</label> 
				<input name="gb_writer" type="text" value="${GB.gb_writer}">
			</div>

			<div>
				<label>e-mail</label> 
				<input name="gb_email" type="email" value="${GB.gb_email}">
			</div>

			<div>
				<label>비밀번호</label> 
				<input name="gb_password" type="password" >
			</div>
			
			<div>
				<label>내용</label> 
				<textarea name="gb_content" rows="5">${GB.gb_content}</textarea> 
			</div>
			
			<div>
			<label></label>
			<button class="btn_save" type="button">저장</button>
			<button type="reset">다시작성</button>
			<button class="btn_home" type="button">처음으로</button>
			</div>
		</fieldset>
	</form>

</body>
</html>