//basic.js
//함수선언식으로 정의.
function sum(num1, num2){
  console.log(num1,num2);
  return num1 + num2;
}

let result = sum(10,20);
console.log(result);

//2. 함수표현식 정의.
let myfnc = function(val1, val2){
  var myVal = 10;
  return val1+ val2+ myVal;
}

console.log(myfnc);
result = myfnc(10,20);
console.log(result);

let mysum = myfnc;
result = mysum(20,30);
console.log(result);

const person = {
  fullName : 'Hong',
  age : 20,
  height : 175.3
};

const person1 = {
  fullName : 'Hwang',
  age : 22,
  height : 178.4
};

const person2={
  fullName : 'Park',
  age : 25,
  height : 165.3
};

//함수표현식 myinfo.
let myInfo = function(obj){
  var info = `${obj.fullName}이고 나이는 ${obj.age}살 이고, 키는 ${obj.height}`;
  return info;
}
result = myInfo(person);
console.log(result);

//배열 활용 출력.
const persons = [person, person1, person2];

for(let per of persons){
  let result = myInfo(per);
  console.log(result);
}

console.clear();
// 자바스크립트에서 문자열, 숫자, boolean, 배열 => 매개값으로 사용.
// 함수를 매개변수로 사용가능.


// persons.forEach(function (val, ind, ary){
//   // console.log(val, ind, ary);
//   console.log(val);
// });

let funcParam = (val, ind, ary) => { //화살표함수
  // console.log(val, ind, ary);
  console.log(myInfo(val));
};
persons.forEach(funcParam);
//메소드의 매개값으로 활용되는 함수 => 콜백함수.














