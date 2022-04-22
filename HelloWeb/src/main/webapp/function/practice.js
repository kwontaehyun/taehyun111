//practice.js

const numbers = [23, 45, 32, 55, 34, 72];

let sum = 0;

// 함수 표현식으로
let evenSum = (val) =>{
  if(val % 2 == 0)
  {
    sum += val
  }
}

numbers.forEach((val) =>{
  if(val % 2 == 0)
  {
    sum += val
  }
});
console.log(`${sum}`);

sum = 0;
let oddSume = (val) =>{
  if(val % 2 != 0)
    sum+= val;
}
numbers.forEach(oddSume);
console.log(sum);
