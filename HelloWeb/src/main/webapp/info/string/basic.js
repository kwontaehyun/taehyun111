// string.basic.js
//문자열 vs 문자열 객체

let str1 = '문자열';
console.log(typeof str1);

let str2 = new String('문자열');
console.log(typeof str2)
console.log(str2);

let a = str1.substring(0,2);
console.log(a);
let b = str2.substring(0,2);
console.log(b);

console.log(str1 == str2)
console.log(str1 === str2)

const cal1 = '1 + 2 * 3';  // Strign
const cal2 = new String('1 + 2 * 3'); //object

// eval() : 문자열 => 수식변경
// valueOf() => 오브젝트타입을 문자열로 바꾸는거
console.log(eval(cal1));
console.log(eval(cal2.valueOf()));

// trim() : 좌우 여백잘라내기
// trimStart() : 왼쪽 여백 잘라내기
// trimEnd() : 오른쪽 여백 잘라내기
console.log('         문자열 공백 테스트        '.trim());

// 문자열의 공백을 제거.

let result = ' 문자열 공백 테스트 '.split(' '); // 매개값을 기준으로 문장을 잘라서 배열로만들어줌.
result = result.filter(function (val){
  return val;
});
console.log(result);// filter() // 배열의 각 요소의 true값을 리턴해서 배열 생성
console.log(result.join('')); // 배열 => 문자열 변환.

// 자바스크립트 boolean 값 : null, '', 0, undefined => false;
if(null){
  console.log('false값')
}

// slice, substring, substr(Deprecated) => 문자열 잘라내기

console.log('안녕하세요 반갑습니다'.slice(0,5));//인덱스 기준 0부터 5까지 자르기
console.log('안녕하세요 반갑습니다'.substring(0,5));//인덱스 기준 0부터 5까지 자르기
//substring은 -값 허용 X slice는 가능.
console.log('안녕하세요 반갑습니다'.substr(2,3));

//toString() : 문자열로 변환
let num1 = 123;
console.log(num1.toString());
console.log(typeof num1.toString());

let obj = {
  key: 'Hong',
  value : 15
}
// object 타입은 문자열로 변경이 안됨.
console.log(obj.toString());
//toString으로 사용하려면 키값만 따로 호출해서 toString()
console.log(obj.key.toString());
console.log(obj.value.toString());