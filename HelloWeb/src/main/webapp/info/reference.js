//reference.js

const names = ['조수연', '황진주', '권가희', '이유빈'];

for(let i =0; i<names.length; i++)
{
  console.log(i+1 + '번째 이름 : ' + names[i]);
}

//enhanced for.
for(let name of names)
{
  console.log(name);
}

var numbers = [23, 44, 38, 12, 56];
for(let num of numbers)
{
  if(num > 40)
    console.log(num);
}

const inputs = [];
var sum = 0, avg = 0;

for(let i=0; i<numbers.length; i++){
  var inputVal = prompt("값을입력하세요");
  console.log(typeof inputVal, inputVal);5
  inputs[i] = parseInt(inputVal);
  sum += inputs[i];
}
//합계를 구하는 , 평균 
avg = sum / numbers.length;
console.log("합계 : " + sum + " 평균 : " + avg);

