// ../object/practice2.js
//달력만들기.
let year = 2022;
let month = 4;
let calTable = "";

showCalendar(year, month);
function showCalendar(year, month) {
  calTable = "<table border = 1>";
  calTable += "<tr>";
  showInfo();
  calTable += "</tr>";
  for (let i = 1; i < getFirstDay(year, month); i++) {
    calTable += `<td></td>`;
  }

  for (let i = 1; i <= getLastDate(year, month); i++) {
    let color = ""
    if (i % 6 == 0) {
      color = 'red';
    } else if (i % 5 == 0) {
      color = 'orange';
    } else if (i % 4 == 0) {
      color = 'yellow';
    } else if (i % 3 == 0) {
      color = 'green';
    } else if (i % 2 == 0) {
      color = 'blue';
    } else if (i % 1 == 0) {
      color = 'navy';
    } else {
      color = 'purple';
    }
    calTable += `<td style = "background : ${color}; font-size: 17px; font-weight : bold; text-align : center; color : white">${i}</td>`;
    if ((i + getFirstDay(year, month) - 1) % 7 == 0) {
      calTable += "</tr>";
      calTable += "<tr>";
    }
  }
  calTable += "</table>";
  document.write(calTable);
}

function showInfo() {
  let days = ['일', '월', '화', '수', '목', '금', '토']
  calTable += `<caption>${year}년 ${month}월 달력</caption>`
  for (let a in days) {
    let color = ""
    if (a == 0) {
      color = 'red';
    } else if (a == 1) {
      color = 'orange';
    } else if (a == 2) {
      color = 'yellow';
    } else if (a == 3) {
      color = 'green';
    } else if (a == 4) {
      color = 'blue';
    } else if (a == 5) {
      color = 'navy';
    } else if (a == 6) {
      color = 'purple';
    }
    calTable += `<th style = "background:${color}; color:white; font-size:20px;" >${days[a]}</th>`;
  }
}

function getLastDate(year, month) {
  switch (month) {
    case 1:
      return 31;
    case 2:
      return 28;
    case 3:
      return 31;
    case 4:
      return 30;
    case 5:
      return 31;
    case 6:
      return 30;
    case 7:
      return 31;
    case 8:
      return 31;
    case 9:
      return 30;
    case 10:
      return 31;
    case 11:
      return 30;
    case 12:
      return 31;
  }
}

function getFirstDay(year, month) {
  switch (month) {
    case 1:
      return 7;
    case 2:
      return 3;
    case 3:
      return 3;
    case 4:
      return 6;
    case 5:
      return 1;
    case 6:
      return 4;
    case 7:
      return 6;
    case 8:
      return 2;
    case 9:
      return 5;
    case 10:
      return 7;
    case 11:
      return 3;
    case 12:
      return 5;
  }
}

