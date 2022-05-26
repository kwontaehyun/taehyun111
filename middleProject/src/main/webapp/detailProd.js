/**
 * 
 */

let allBtn = document.querySelectorAll('#page');
console.log(allBtn)

function getParam(sname) {
   let params = location.search.substr(location.search.indexOf("?") + 1);
   let sval = "";
   params = params.split("&");
   for (let i = 0; i < params.length; i++) {
      temp = params[i].split("=");
      if ([temp[0]] == sname) { sval = temp[1]; }
   }
   return sval;
}

let proDuctNum = getParam("proDuctNum");

allBtn.forEach(function pageing(val, idx) {
   
   val.innerHTML = idx + 1;
   val.addEventListener('click', function() {

      location.href = `http://192.168.0.8/middleProject/detailProduct.do?proDuctNum=${proDuctNum}&firstPage=${1 + 5 * (allBtn.length-1-idx)}&lastPage=${(allBtn.length-idx) * 5}`
   });
});  