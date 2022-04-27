// dom1.js

let data = [{
    studNo: 101,
    studName: '홍길동',
    engScore: 90,
    korScore: 100
  },
  {
    studNo: 102,
    studName: '닭길동',
    engScore: 60,
    korScore: 50
  },
  {
    studNo: 103,
    studName: '갈길동',
    engScore: 50,
    korScore: 70
  },
  {
    studNo: 104,
    studName: '비길동',
    engScore: 70,
    korScore: 80
  }
]

let list = document.getElementById('list');
data.forEach(element => {
  list.appendChild(makeTr(element));

});

//변경버튼 이벤트.
let changeBtn = document.querySelector('input[type = "button"]');
changeBtn.addEventListener('click', function(e){
  let targetTr = document.querySelectorAll('#list>tr');
  console.log(targetTr);
  let sno = document.getElementById('sno').value
  let sname = document.getElementById('sname').value
  let seng = document.getElementById('seng').value
  let skor = document.getElementById('skor').value

  targetTr.forEach(function(tr){
    if(tr.children[0].innerHTML == sno){
      tr.children[1].innerHTML = sname;
      tr.children[2].innerHTML = seng;
      tr.children[3].innerHTML = skor;
    }
    else{
      alert("오류");
      return;
    }
  })
})

function changeCallBack(e){
  e.preventDefault(); // 기본기능 차단
  let sno = document.getElementById('sno').value;
  let searchTr = document.getElementById(`sno_${sno}`);
  if(!sno || !searchTr){
    alert('변경할 아이디를 선택하세요');
    return;
  }
  
  console.log(searchTr);
  searchTr.children[1].innerHTML = document.getElementById('sname').value;
  searchTr.children[2].innerHTML = document.getElementById('seng').value;
  searchTr.children[3].innerHTML = document.getElementById('skor').value;
  
}

function makeTr(student) {
  let tr = document.createElement('tr');
  tr.setAttribute('id', 'sno_' + student.studNo);
  tr.addEventListener('click', function(e){
    // e.stopPropagation(); // 이벤트가 전파되는걸 차단
    // console.log(this); 
    document.getElementById('sno').value = this.children[0].innerHTML; 
    document.getElementById('sname').value = this.children[1].innerHTML
    document.getElementById('seng').value = this.children[2].innerHTML
    document.getElementById('skor').value = this.children[3].innerHTML
  }, false) // true : 상위 요소 - 하위요소. // default 값은 false
  
  for (let field in student) {
    let td = document.createElement('td');
    td.innerHTML = student[field]
    tr.appendChild(td);
  }
  let button = document.createElement('button');
  button.innerHTML = '삭제';

  button.addEventListener('click', function (e) {
    e.stopPropagation(); // 이벤트가 전파되는걸 차단
    // console.log(this);
    e.target.parentElement.remove();
  }, false)
  tr.appendChild(button);
  return tr;
}
