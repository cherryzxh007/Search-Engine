function getLogin() {
	useremail = document.forms[0].useremail.value;
	pw = document.forms[0].pw.value;
	
	if (useremail.length > 0 && pw.length > 0) {
		document.forms[0].submit();
	}
	else {
		alert("Enter email and password");
	}
}

function getRegister() {
	useremail = document.forms[0].useremail.value;
	pw = document.forms[0].pw.value;
	repw = document.forms[0].repw.value;
	firstname = document.forms[0].firstname.value;
	lastname = document.forms[0].lastname.value;
	
	if (useremail.length > 0 && pw.length > 0 && repw.length > 0 && firstname.length > 0 && lastname.length > 0) {
		if (pw != repw) {
			alert("Entered password do not matched");
		}
		else {
			document.forms[0].submit();
		}
	}
	else {
		alert("Please complete all fields");
	}
}

function changePW() {
	
	oldpw = document.forms[0].oldpw.value;
	newpw = document.forms[0].newpw.value;
	newpw2 = document.forms[0].newpw2.value;
	
	if (oldpw.length > 0 && newpw.length > 0 && newpw2.length > 0) {
		if (newpw != newpw2) {
			alert("Entered password do not matched");
		}
		else {
			document.forms[0].submit();
		}
	}
	else {
		alert("Please complete all fields");
	}
}

function cleanHistory() {
	
	query = document.forms[0].clearqueryhistory.checked;
	visited = document.forms[0].clearvisitedpage.checked;
	
	if (query == 1 || visited == 1) {
		document.forms[0].submit();
	}
	else {
		alert("Please select any input or click the icon to cancel");
	}
	
}

function crawl() {
	
	url = document.forms[0].seedurl.value;
	
	if (url.length > 0) {
		if (isURL(url)) {
			document.forms[0].submit();
		}
		else {
			alert("It is not a valid URL");
		}
	}
	else {
		alert("Please complete all fields");
	}
	
}

function isURL(str) {
	var regex = /http:\/\/(\w+:{0,1}\w*@)?(\S+)(:[0-9]+)?(\/|\/([\w#!:.?+=&%@!\-\/]))?/
	return regex.test(str);
}

function changeNum() {
	
	num = document.forms[0].num.value;
	
	if (num.length > 0) {
		document.forms[0].submit();
	}
	else {
		alert("Please enter a number");
	}
	
}