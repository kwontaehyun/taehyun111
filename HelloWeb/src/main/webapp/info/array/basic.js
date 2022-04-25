// array.basic.js

// 배열선언 : [], new Array();
let arr = [1, 2];
let newAry = [3,4,5,6];
// 추가 : push , unshift
// push -> 마지막인덱스, unshift -> 첫번째인덱스
arr.push(3);
arr.unshift(4);
console.log(arr.toString());

// 제거 : pop -> 마지막인덱스, shift -> 첫번째 인덱스
arr.pop();
arr.shift();
console.log(arr.toString());

// forEach
newAry.forEach(val => {
  arr.push(val);
});

arr.shift();
arr.pop();

console.log(arr.toString());

// splice(위치, 크기, 대체 값) : 추가, 수정, 삭제 
arr.splice(1, 1, 8, 9)
console.log(arr.toString());
arr.splice(1, 2) // 안적으면 삭제
console.log(arr.toString());

newAry.forEach(val => {
  arr.splice(arr.length, val.length-1, val);
});
console.log(arr.toString());

let names = [];
let anonym = 'Lorem, ipsum dolor sit amet consectetur adipisicing elit. Corrupti possimus rem vel, dolorum iusto magni quos nam, aperiam beatae laboriosam fuga pariatur sunt ducimus omnis, qui illo culpa! Cupiditate, ducimus!'
anonym.split(' ').forEach(val =>{
  names.push(val);
});
console.log(names);

// forEach() : 반환 X
// map() : 각요소 => mapping작업( 다른 형태 반환);
// filter() : return 조건을 만족하는 값만 반환해서 새로운 배열.

let result = names.map( val => {
  return val.toUpperCase();
}); //새로운 배열
console.log(result);

result = result.filter(val => {
  return val.length >= 10;
});
console.log(result);

result = names.map(val => val.toUpperCase()).filter(val => val.length >= 10); // chain rules
console.log(result);
