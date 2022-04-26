document.addEventListener("DOMContentLoaded", function(){
  
  let divTag = document.createElement('div');
  let spanName = document.createElement('span');

  spanName.setAttribute('id','name');
  let name = document.createTextNode('홍길동');
  spanName.appendChild(name);

  let spanAge = document.createElement('span');
  let age = document.createTextNode('20살');
  spanAge.setAttribute('class', 'age')
  
  spanAge.appendChild(age);
  let hypen = document.createTextNode(' - ');

  divTag.appendChild(spanName)
  divTag.appendChild(hypen)
  divTag.appendChild(spanAge)

  let divShow = document.getElementById('show').appendChild(divTag);

})