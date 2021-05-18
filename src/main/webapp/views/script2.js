let form = document.querySelector('.signup_form');
let name = document.querySelector('.name');
let surname = document.querySelector('.surname');
let login = document.querySelector('.login');
let password = document.querySelector('.password');
let phone = document.querySelector('.phone');
let radio1 = document.querySelector('.rad1');
let radio2 = document.querySelector('.rad2');

form.onsubmit = function(evt) {
	if (login.value == '' || password.value == '' || name.value == '' || surname.value == '' || phone.value == '' || (!radio1.checked && !radio2.checked)) {
		evt.preventDefault();
		alert('Please, fill in all the fields');
	}
	
};
