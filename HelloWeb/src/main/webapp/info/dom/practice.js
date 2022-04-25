//dom/practice.js

document.addEventListener('DOMContentLoaded', function(){
  let btn = document.querySelector('button'); // 버튼 찾아오는거
  btn.addEventListener('click', function(){
    //입력값 1, 입력값 2
    let name = document.getElementById('userName').value;
    let age = document.getElementById('userAge').value;
  
    if(!name || !age){
      alert('비워두지마세요');
      return;
    }

    let span1 = document.createElement('span'); // <span><span>
    span1.innerHTML = name;
    let span2 = document.createElement('span');
    span2.innerHTML = age;
    let div1 = document.createElement('div');
    div1.appendChild(span1); // <div><span></span></div>
    div1.appendChild(span2); // <div><span></span><span></span></div>
    
    document.getElementById('show').appendChild(div1);
  
  });
})

