// array/basic1.js


// reduce(); map() => 새로운 배열, filter() =>새로운 배열.
// reduce() => 결과값이 지정하는값으로 생성가능.
// string => string, array = > array, number => number

//배열요소의 누적 합
const numbers = [23, 4, 77, 51, 63,34, 62, 92];
let result = numbers.reduce(function (accum, val, idx, ary) {
  accum+=val ;
  console.log(accum,val, idx, ary); // 
  return accum;
}, 0);
console.log(result);

//배열요소의 *2 = 새로운 배열
result = numbers.reduce(function(accum, val){
  accum.unshift(val*2);
  return accum; 
}, [])
console.log(result);

// filter : 50보다 큰 숫자를 가지는 새로운 배열
// reduceRight() -> 오른쪽에서부터 새로운 배열생성.
result = numbers.reduce(function(accum, val){
  if(val > 50)
  {
    accum.push(val);
  }
  return accum;

}, [])
console.log(result);