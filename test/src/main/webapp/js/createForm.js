function validate(f){ // 유효성 검사
	// 아이디 8~12 글자 이내
	var subject=f.subject.value;
	subject=subject.replace(/^\s+|\s+$/gm,'');
	if(subject.length==0) {
		alert("최소 한글자는 입력해주세요!!");
		f.subject.focus();
		return;
	}

	f.submit(); // <input type="submit">과 동일 기능
}