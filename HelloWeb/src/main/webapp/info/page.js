// page.js
console.log(member1);

let field = 'fullName';
let field2 = 'age';
let field3 = 'score';
console.log(member1.fullName);
console.log(member2['fullName']);
console.log(member3[field]);

//배열 요소를 반복적으로 for.. of
for(let member of members){
  console.log(`이름은 ${member[field]}이고, 나이는 ${member[field2]}, 점수는 ${member[field3]} 입니다.`);
}

//오브젝트의 속성(필드)을 반복적으로 for..in
for(let field in member1){
  console.log(`${field} => ${member1[field]}`);
}

//각 배열요소의 각 필드를 출력.

field = ['fullName', 'score', 'age'];

document.write(`<table border = '1'>`);
for(let fld in field){
  document.write(`<th>${field[fld]}</th>`);
}
for(let member of members){ 
  document.write(`<tr>`);
  for(let field in member)
  {
    document.write(`<td>${member[field]}</td>`);
  }
  document.write(`</tr>`);
}
document.write(`</table>`);

