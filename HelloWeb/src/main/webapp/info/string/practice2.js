// string/practice2.js

let sso = ['970101-1234567', '970102 1234567', '9701032234567', '970104/1234567'];
// function checkGender(ssn) {
//   for (let i of ssn) {
//     i = i.replace(/\D/gi, '').charAt(6);
//     console.log(i);
//     if (i == '1' || i == '3') {
//       console.log('남자');
//     } else if (i == 2 || i == 4) {
//       console.log('여자');
//     } else {
//       return '?'
//     }
//   }
// }
// checkGender(sso);
function checkGender(ssn) {
  ssn.forEach(val => {
    val = val.replace(/\D/gi, '').charAt(6);
    console.log(val);
    if(val == 1 || val == 3){
       console.log('남자');
    }
    else if(val == 2 || val == 4){
      return '여자';
    }
  });
  
  console.log(result);
}
checkGender(sso);

