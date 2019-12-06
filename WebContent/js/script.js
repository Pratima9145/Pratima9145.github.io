// Include truYum form validation functions here
function validation() {
	var a = document.forms["menuform"]["txtName"].value;
	if(a=="") {
		alert("Name is required");
		return false;
	}
	if((a.length < 2) || (a.length > 65)) {
		alert("The name should have 2 to 65 characters");
		document.forms["menuform"]["txtName"].select();
		return false;
	}
	if(/[^a-zA-Z]/.test(a)) {
		alert("The name should be alphabet");
		return false;
	}
	var b = document.forms["menuform"]["txtPrice"].value;
	if(b=="") {
		alert("Price is required");
		document.forms["menuform"]["txtPrice"].focus();
		return false;
	}
	if(/[^0-9]/.test(b)) {
		alert("The price has to be a number");
		return false;
	}
	var c = document.forms["menuform"]["launch"].value;
	if(c=="") {
		alert("Date of launch is required");
		document.forms["menus"]["launch"].focus();
		return false;
	}
	var d = document.forms["menuform"]["category"].value;
	if(d=="") {
		alert("category is required");
		return false;
	}
	alert("Details submitted successfully");
}
		