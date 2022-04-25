// dom/basic.js

//DOM : 생성, 속성, 삭제, 부모-자식 관계 설정
//addEventListener('이벤트 이름', '실행할 이벤트 핸들러')
document.addEventListener('DOMContentLoaded', function(){
  let h3Tag = document.getElementsByTagName('h3'); // HTMLCOllection
  console.log(h3Tag);
  h3Tag[1].innerHTML = 'content changed';

  let first = document.getElementById('first'); //요소
  console.log(first);
  first.innerHTML = 'Git Changed';
  
  let second = document.getElementById('first');
  second.innerHTML = '사과';

  //css의 선택자 h3 > dev
  let list = document.querySelectorAll('ul>li');
  console.log(list);
  list[1].style.backgroundColor = 'yellow';

  //DOM 생성.
  let newList = document.createElement('li'); // <li>
  newList.innerHTML = 'Mango'
  console.log(newList);

  // ul 하위요소 <li>Mango</li>
  let ulTag = document.querySelector('ul');
  ulTag.appendChild(newList);
}); // document <- body영여, 이벤트 => 입력, 마우스움직임, 앤터. 등등 

