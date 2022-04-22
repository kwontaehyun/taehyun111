//variable.js

var maName = '권태현'; //string
var yourName; // undefined
maName = 100; // number
maName = true; // boolean
maName = null; // object

console.log(typeof yourName);
var yourName = "홍길동";
console.log(typeof yourName);

//전역변수(스크립트), 지역변수(함수안에서 선언되어지는 변수)

function checkInfo() {
  let maName = 'LeeChangho';
  console.log(maName);
}
checkInfo();
console.log(maName);

// ES6 (ES2015) => let, const
// let 블럭레벨 변수선언.
function info() {
  let maName = 'Hong';
  console.log(maName);
}
info();

{
  let maName = 'Hong';
  console.log(maName);
}
{
  let maName = 'Hwang';
  console.log(maName);
}

const otherName = 'Hong';
otherName = 'Hwang';

//var, let => 변수선언
//const = >상수선언
