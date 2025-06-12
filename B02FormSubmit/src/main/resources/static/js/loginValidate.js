/**
 * 
 */
function formValidate(frm){
	if(frm.id.value==''){
        alert("아이디를 입력해주세요.");
        frm.id.focus();
        return false;
	}
	//패스워드 입력 확인
	 if(frm.passwd.value==''){
       alert("패스워드를 입력해주세요.");
	   frm.passwd.focus();
	   return false;
   }
}
