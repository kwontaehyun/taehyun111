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

const persons = [person1, person2, person3];
const newPersons = persons.map((val,idx) => {
  let newObj = {};
  newObj.index = idx;
  newObj.fName = val.fullName;
  newObj.age = val.age;
  newObj.height = val.height;
  return newObj;
});

console.log(newPersons);

let tag = "";

let array = ['순번', '이름', '나이', '키'];

//함수정의문
let tableList = (personAry) => {
  document.write(`<table border = 1>`);
  for(let person of personAry){ //line 생성

    if(person.index == 0){
      for(let ary in array){
        document.write(`<th>${array[ary]}</th>`);
      }  
    }

    document.write(`<tr>`);
    for(let field in person){
      document.write(`<td>${person[field]}</td>`);
    }
    document.write(`</tr>`);
  }
  //함수실행
  document.write(`</table>`);
}

tableList(newPersons);