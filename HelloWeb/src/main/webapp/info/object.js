//object.js

//object타입은
// key : value로 저장가능.

let member1 = {
  fullName: 'Hong',
  age: 20,
  score: 80
};

let member2 = {
  fullName: 'Hwang',
  age : 22,
  score: 88
}

let member3 = {
  fullName: 'Park',
  age: 25,
  score: 92
}

member1.fullName = '홍';

console.log(member1.fullName);
console.log(member2.age);

const members = [member1, member2, member3];
// 홍의 나이는 20이고, 점수는 80입니다.
document.write('<ul>');
for(let men of members)
{
  // let memberVari = "<li>" + men.fullName + "의 나이는 " + men.age +"이고, 점수는 " +men.score + "점 입니다. </li>";
  document.write(`<li> ${men.fullName} 의 나이는 ${men.age}이고, 점수는 ${men.score} 점 입니다. </li>`);
}
document.write('</ul>');
let welcome = 
`안녕하세요.
반갑습니다`;
console.log(welcome);

