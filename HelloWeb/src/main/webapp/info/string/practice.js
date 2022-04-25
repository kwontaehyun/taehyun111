// string/practice.js

let str = 'Lorem, ipsum dolor sit amet consectetur adipisicing elit. Corrupti possimus rem vel, dolorum iusto magni quos nam, aperiam beatae laboriosam fuga pariatur sunt ducimus omnis, qui illo culpa! Cupiditate, ducimus!';

// 단어의 길이가 10개 이상인 값을 ,로 골라내서 ....... 

let result = str.split(' ');

console.log(result);
result = result.filter(val => val.length >= 10).join(',');
