	function allCheck(){
		var allChk = document.getElementById("allAgree");
		var chk1 = document.getElementById("agree1");
		var chk2 = document.getElementById("agree2");
		var chk3 = document.getElementById("agree3");
		if(allChk.checked == true){
			// check할 때 동작
			chk1.checked = true;
			chk2.checked = true;
			chk3.checked = true;
		} else{
			chk1.checked = false;
			chk2.checked = false;
			chk3.checked = false;
		}
	}
	function chkCheck(){
		var chk1 = document.getElementById("agree1");
		var chk2 = document.getElementById("agree2");
		if(chk1.checked != true || chk2.checked != true){
			alert("필수 약관에 동의해주세요")
		} else if(!idCheck()){
			alert("아이디를 입력해주세요")
		} else if(!pwCheck()){
			
		} else if(!nameCheck()){
			alert("이름을 입력하세요")
		} else if(!telCheck()){
			alert("전화번호를 입력해주세요")
		} else if(!emailCheck()){
			alert("이메일을 입력해주세요")
		} else if(!addressCheck()){
			alert("주소를 입력해주세요")
		} else {
			var fo = document.getElementById("fo");
			fo.submit();	
		}
	}
	function idCheck(){
		var id = document.getElementById("id");
		if(id.value == false){
			return false;
		} else {
			return true;
		}
	}
	function pwCheck(){
		var pw = document.getElementById("pw");
		var pwChk = document.getElementById("pwChk");
		if(pw.value == false){
			alert("비밀번호를 입력해주세요")
			return false
		}
		if(pw.value != pwChk.value){
			alert("비밀번호가 일치하지 않습니다")
			return false;
		} else {
			return true;
		}
	}
	function nameCheck(){
		var name = document.getElementById("name");
		if(name.value == false){
			return false;
		} else{
			return true;
		}
	}
	function telCheck(){
		var tel = document.getElementById("m_tel");
		if(tel.value == false){
			return false;
		} else {
			return true;
		}
	}
	function addressCheck(){
		var address1 = document.getElementById("m_address");
		var address2 = document.getElementById("m_address2");
		if(address1.value == false || address2.value == false){
			return false;
		} else {
			address1.value += "/" + address2.value;
			return true;
		}
	}
	function emailCheck(){
		var email = document.getElementById("email");
		if(email.value == false){
			return false;
		} else {
			return true;
		}
	}
	function pwEqualsCheck(){
		var pw = document.getElementById("pw").value;
		var pwChk = document.getElementById("pwChk").value;
		if(pw == pwChk){
			document.getElementById("pwCheckView").innerHTML = "일치";
			document.getElementById("pwCheckView").style = "color:green";
		} else{
			document.getElementById("pwCheckView").innerHTML = "일치하지 않습니다";
			document.getElementById("pwCheckView").style = "color:red";
		}
	}
	function dbIdCheck(){
		var id = document.getElementById("id").value;
		var dbIdCheckView = document.getElementById("dbIdCheckView");
		$.ajax({
			url : "dbIdCheck",
			data : "id=" + id,
			type : "GET",
			success : function(cnt){
				dbIdCheckView.innerHTML = cnt;
			},
			error : function(){
				alert("실패")
			}
		});
	}