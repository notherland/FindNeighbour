let form = document.querySelector('.test_form');

let r11 = document.querySelector('.r11');
let r12 = document.querySelector('.r12');
let r13 = document.querySelector('.r13');
let r14 = document.querySelector('.r14');

let r21 = document.querySelector('.r21');
let r22 = document.querySelector('.r22');
let r23 = document.querySelector('.r23');
let r24 = document.querySelector('.r24');

let r31 = document.querySelector('.r31');
let r32 = document.querySelector('.r32');
let r33 = document.querySelector('.r33');
let r34 = document.querySelector('.r34');

let r41 = document.querySelector('.r41');
let r42 = document.querySelector('.r42');

let r51 = document.querySelector('.r51');
let r52 = document.querySelector('.r52');
let r53 = document.querySelector('.r53');

let r61 = document.querySelector('.r61');
let r62 = document.querySelector('.r62');
let r63 = document.querySelector('.r63');

let r71 = document.querySelector('.r71');
let r72 = document.querySelector('.r72');
let r73 = document.querySelector('.r73');

form.onsubmit = function(evt) {
	if ((!r11.checked && !r12.checked && !r13.checked && !r14.checked) || (!r21.checked && !r22.checked && !r23.checked && !r24.checked) || (!r31.checked && !r32.checked && !r33.checked && !r34.checked) || (!r41.checked && !r42.checked) || (!r51.checked && !r52.checked && !r53.checked) || (!r61.checked && !r62.checked && !r63.checked) || (!r71.checked && !r72.checked && !r73.checked)) {
		evt.preventDefault();
		alert('Please, answer all the questions');
	}
};