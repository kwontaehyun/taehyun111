// string/basic2.js

//indexOf(), lastIndexOf() : 찾을 문자열의 위치 리턴 없으면 - 1리턴

let result = '안녕하세요 홍길동입니다, 대구의 홍길동입니다.'.indexOf('홍길동');
console.log(result);
result = '안녕하세요 홍길동입니다, 대구의 홍길동입니다.'.lastIndexOf('홍길동');
console.log(result);
result = '안녕하세요 홍길동입니다, 서울의 홍길동, 부산의 홍길동, 대구의 홍길동입니다.'.indexOf('홍길동', 15);
console.log(result);

let str1 = '안녕하세요 홍길동입니다, 서울의 홍길동, 부산의 홍길동, 대구의 홍길동입니다.';

let position = str1.indexOf('부산');
result = str1.indexOf('홍길동', position);
console.log(result);

//charAt(인덱스) : 해당되는 위치의 값을 리턴
let str2 = str1.charAt(27);
console.log(str2);

//toLowerCase, toUpperCase() : 소,대문자

let str3 = 'Lorem ipsum DOLOR sit amet consectetur dolor';
console.log(str3.toLowerCase())
console.log(str3.toUpperCase())

// includes('찾을 문자열') : true/false
result = str3.toLowerCase().includes('dolor');
console.log(result);
result = str3.includes('dolors');
console.log(result);

// search('찾을 문자열') 추가기능 : search(정규표현식); 찾을 문자열의 인덱스를 반환
//정규표현식 오브젝트 / /(new regExp()), 배열[](new Array(1,2))가 있는데 new는 잘안씀
result = str3.search(/dolor/i);
console.log(result);

// match('찾을 문자열') : 문자열 or null 리턴, object타입
let str4 = 'bad MORING, goodmorning, GOOD AFTERNOON, good evening, and good night';

result = str4.match('good');
result = str4.match(/good\s\w+/gi); // s : 공백. w : 문자하나. +는 한개이상 있다라는 의미
console.log(typeof str4);
console.log(typeof result);
console.log(result);

// replace('찾을 문자열', '바꿀 문자열');
result = str4.replace('good', 'better')
console.log(result);
result = str4.replace(/good/ig, 'better')
console.log(result);
result = str4.replace(/\W/ig, '-') // W :문자 이외에 모두 다, 공백은 문자가아님., i : 대소문자 구분없이, g :전체 찾기
console.log(result);

result = 'morning1 morning12 morning123'.replace(/\D/g,''); // d : 숫자, D : 숫자 이외에 모두.
console.log(result);

let sso = ['970101-1234567', '970102 1234567', '9701031234567', '970104/1234567'];

sso.forEach(num => console.log(num.replace(/\D/g, '')));

//문자열 합치기 : + <- 문자열 연산, concat()
console.log('hello' + ' world');
console.log('hello'.concat(' world', '!!', ' welcome'));
