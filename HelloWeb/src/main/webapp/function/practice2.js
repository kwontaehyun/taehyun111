//practice2.js

const num1= 10;

const person1 = {
  fullName: 'Hong',
  age: 20,
  height: 175.3
};
const person2 = {
  fullName: 'Hwang',
  age: 22,
  height: 178.4
};
const person3 = {
  fullName: 'Park',
  age: 25,
  height: 165.3
};

const person4 = person1;
console.log(person4.fullName);

const persons = [person1, person2, person3];

let avgAge = 0;

let sum = 0;
persons.forEach((val) => {
  sum += val.age;
});

avgAge = sum / persons.length;
console.log(avgAge);

let tag = "";

persons.forEach((val, idx) => {
  if(idx == 0){
    tag += '<ul>';
  }
  tag+= `<li> 이름은 ${val.fullName}이고 나이는 ${val.age} 이고, 키는 ${val.height} 입니다.`;
  if(idx == persons.length-1){
    tag+= '</ul>';
  }
});
document.write(tag);

persons.forEach((val) => {
  if(val.height > 170){
    document.write(`<h4>이름은 ${val.fullName}이고 나이는 ${val.age} 이고, 키는 ${val.height} 입니다.</h4>`);
  }
})