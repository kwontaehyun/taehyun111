// document.addEventListener("DOMContentLoaded", function () {
//   let field = [{
//       id: 105,
//       이름: '홍길동',
//       나이: 20
//     },
//     {
//       id: 106,
//       이름: '홍',
//       나이: 22
//     },
//     {
//       id: 107,
//       이름: 'hong',
//       나이: 30
//     }
//   ]

//   let table = document.createElement('table')
//   table.setAttribute('border', 1);
//   let tbody = document.createElement('tbody')
//   let thead = document.createElement('thead')
//   table.appendChild(thead)
//   table.appendChild(tbody)
//   let tr = document.createElement('tr')
//   let btn = document.querySelector('button');


//   for (let i in field[0]) {
//     if (i != 'id') {
//       let th = document.createElement('th');
//       th.innerHTML = i;
//       thead.appendChild(tr);
//       tr.appendChild(th);
//     }
//   }

//   field.forEach((val, idx) => {
//     tr = document.createElement('tr')
//     let td = document.createElement('td')
//     td.innerHTML = val.이름;
//     tbody.appendChild(tr)
//     tr.appendChild(td)
//     td = document.createElement('td')
//     td.innerHTML = val.나이;
//     tr.appendChild(td)

//   });

//   document.getElementById('show').appendChild(table)
//   btn.addEventListener('click', function(){

//     let showDiv = document.getElementById('show');
//     let tableTag = document.createElement('table');
//     tableTag.setAttribute('border', 1);
//     showDiv.appendChild(tableTag);

//     let obj = {}
//     let userName = document.getElementById('userName').value;
//     obj.name = userName;
//     let userAge = document.getElementById('userAge').value;
//     obj.age = userAge;
//     obj.id = 110;
//     document.querySelector('table>tbody').append(makeTr(obj));
//   })

// })

// dom/practice3.js

let users = [{
    id: 101,
    name: "홍길동",
    age: 20
  },
  {
    id: 102,
    name: "김길동",
    age: 22
  },
  {
    id: 103,
    name: "박길동",
    age: 25
  }
]

document.addEventListener('DOMContentLoaded', callbackFunc);

function callbackFunc() {
  let showDiv = document.getElementById('show');
  let tableTag = document.createElement('table');
  tableTag.setAttribute('border', 1);
  showDiv.appendChild(tableTag);

  tableTag.appendChild(makeThead(users[0]));
  tableTag.appendChild(makeTbody(users));

  // 추가 버튼 이벤트
  let btn = document.querySelector('button');
  btn.addEventListener('click', () => {
    // userName, userAge
    let userName = document.getElementById('userName');
    let userAge = document.getElementById('userAge');

    let obj = {};
    obj.name = userName.value;
    obj.age = userAge.value;
    obj.id = 110;

    document.querySelector('table>tbody').append(makeTr(obj));

    userName.value = "";
    userAge.value = "";

  });
}

function makeThead(obj) {
  let thead = document.createElement('thead');
  let tr = document.createElement('tr');
  thead.appendChild(tr);

  for (let field in obj) {
    if (field == "id") {
      continue
    };
    let th = document.createElement('th');
    th.innerHTML = field;
    tr.appendChild(th);
  }
  let th = document.createElement('th');
  th.innerHTML = '삭제';
  tr.appendChild(th);

  return thead;
}

function makeTbody(objAry) {
  let tbody = document.createElement('tbody');

  objAry.forEach((obj) => {
    let tr = makeTr(obj);
    tbody.appendChild(tr);
  });

  return tbody;
}

function makeTr(obj) {
  let tr = document.createElement('tr');

  // name, age 필드 => td생성

  for (field in obj) {
    if (field == "id") {
      tr.setAttribute(field, obj[field]);
    } else {
      let td = document.createElement('td');
      let text = document.createTextNode(obj[field] + `${field=='age'?'살':""}`);
      td.appendChild(text);
      tr.appendChild(td);
    }
  }

  let btn = document.createElement('button');
  btn.innerHTML = '삭제';
  btn.addEventListener('click', function (evnt) {
    console.log(this);
    this.parentElement.parentElement.remove();
  //   // console.log(evnt.target.parentElement.parentElement.remove());
  });

  let td = document.createElement('td');
  td.appendChild(btn);
  tr.appendChild(td);

  return tr;
}