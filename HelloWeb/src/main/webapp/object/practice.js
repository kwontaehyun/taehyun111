// ../object/practice.js

const jsonObj =
  `[{"id":1,"first_name":"Lori","last_name":"Ryrie","email":"lryrie0@addtoany.com","gender":"Female","ip_address":"202.134.39.196"},
{"id":2,"first_name":"Gennifer","last_name":"Boniface","email":"gboniface1@npr.org","gender":"Female","ip_address":"238.76.28.253"},
{"id":3,"first_name":"Ginger","last_name":"Puddin","email":"gpuddin2@nationalgeographic.com","gender":"Polygender","ip_address":"65.127.129.203"},
{"id":4,"first_name":"Mahmud","last_name":"Adamczewski","email":"madamczewski3@feedburner.com","gender":"Male","ip_address":"54.198.143.117"},
{"id":5,"first_name":"Mandi","last_name":"Caldero","email":"mcaldero4@hao123.com","gender":"Bigender","ip_address":"101.157.197.31"},
{"id":6,"first_name":"Jeno","last_name":"Billington","email":"jbillington5@bravesites.com","gender":"Male","ip_address":"236.40.13.178"},
{"id":7,"first_name":"Louie","last_name":"Tunn","email":"ltunn6@apache.org","gender":"Male","ip_address":"72.251.56.234"},
{"id":8,"first_name":"Reinald","last_name":"Bester","email":"rbester7@npr.org","gender":"Male","ip_address":"228.36.106.72"},
{"id":9,"first_name":"Josias","last_name":"Skirrow","email":"jskirrow8@gnu.org","gender":"Male","ip_address":"208.23.55.113"},
{"id":10,"first_name":"Auguste","last_name":"Levings","email":"alevings9@imageshack.us","gender":"Female","ip_address":"5.161.15.173"},
{"id":11,"first_name":"Duane","last_name":"Sunnex","email":"dsunnexa@wunderground.com","gender":"Male","ip_address":"141.34.153.81"},
{"id":12,"first_name":"Leona","last_name":"Killingworth","email":"lkillingworthb@cloudflare.com","gender":"Female","ip_address":"254.216.141.147"},
{"id":13,"first_name":"Foss","last_name":"Bellenger","email":"fbellengerc@bbb.org","gender":"Male","ip_address":"40.202.102.149"},
{"id":14,"first_name":"Twyla","last_name":"Ericssen","email":"tericssend@tiny.cc","gender":"Female","ip_address":"116.242.0.238"},
{"id":15,"first_name":"Lisetta","last_name":"De Biasio","email":"ldebiasioe@thetimes.co.uk","gender":"Female","ip_address":"165.107.147.236"}]`;

const objAry = JSON.parse(jsonObj);

let tableTag = "";
let aryfield = ['id', 'first_name', 'last_name', 'email', 'gender', 'ip_address'];
// function showTable(objAry){
//   tableTag += `<table border = 1>`
//   for(let aryfld in aryfield){
//     tableTag += `<th>${aryfield[aryfld]}</th>`;
//   }
//   for(let ary of objAry){
//     tableTag += '<tr>'
//     for(let field in ary){
//       tableTag += `<td>${ary[field]}</td>`;
//     }
//     tableTag += '</tr>'
//   }
//   tableTag += `</table>`
// }

function showTable(ary) {

  tableTag += '<table border = 1>';
  tableTag += createHead();
  tableTag += createBody(ary);
  tableTag += '</table>';
}

function createHead() {
  let headTag = "";
  headTag += `<thread><tr>`;
  aryfield.forEach(function (val) {
    headTag += `<th>${val}</th>`;
  });
  headTag += `</tr></thead>`;
  console.log(headTag);
  return headTag;
}

function createBody(ary) {
  let bodyTag = "";
  bodyTag += "<tbody>";

  ary.forEach(function (val, idx){
    bodyTag += `<tr style = background-color:${idx%2==0?'yellow':'green'}>`;
    aryfield.forEach(function(field){
      bodyTag += `<td>${val[field]}</td>`;
    });
    bodyTag += "</tr>";
  })
  bodyTag += "</tbody>";
  return bodyTag;
}
showTable(objAry);
document.write(tableTag);