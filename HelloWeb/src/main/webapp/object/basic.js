// ../object/basic.js

const member = {
  memberId: 'user1',
  memberName: 'Hong',
  getMemberName: function(){
    return `회원이름 : ${this.memberName}`;
  },
  setMemberName : function(name) {
    this.memberName = name;
    
  }
}

console.log(member.memberId);
member.setMemberName('Hwang');
console.log(member.getMemberName());
member.memberAge = 20;
delete member.memberAge;

member['memberPoint'] = 1000;

member.grade = () => {
  if(member.memberPoint > 500){
    return 'gold';
  }
  else if(member.memberPoint > 1000){
    return 'platinum';
  }
}
console.log(member);
console.log(member.grade());

class Student{
  constructor(sno, sname){
    this.sno = sno;
    this.sname = sname;
  }

  set MathScore(score){
    this._mathScore = score; //생성자에 선언되지않은 속성 추가
  }
  get MathScore(){
    return this._mathScore; // _mathScore 속성값을 읽어옴.
  }

  getSno(){
    return this.sno;
  }
  setSno(sno){
    this.sno = sno;
  }
}
const s1 = new Student('1111', 'Hong');
const s2 = new Student('2222', 'Hwang');
console.log('학생번호' + s1.getSno());
s1.engScore = 80;
s1._mathScore = 90;
console.log(s1.engScore);
console.log(s1._mathScore);

this.getInfo = function Person(ssn, sname){
  return `주민번호${this.ssn}, 이름 ${this.sname}`;
}

const p1 = new Person('911111-1111111', 'Hong');
const p2 = new Person('971141-1312116', 'Hwang');
const p3 = new Person('111111-1111111', 'Park');

console.log(p1.getInfo());