<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
<style>
* {
   margin: 0;
   padding: 0;
   font-family: 'Noto Sans KR';
}

.list{
  margin: 0 auto;
  padding:20px;
  width:500px;
  height:825px;
}

header h3 {
 text-align : center;
 margin: 80px 0px 40px 0px;
 height: 60px;
 font-weight: bold;
}


form tr  {
 margin : 15px;
 padding : 15px;
}

table {
border-spacing : 0;
margin:0;
padding:0;
border:0;
width:100%
}

form tr th span {
 margin : 15px;
 padding : 15px;
 display:inline-block;
  text-align:left;
 padding: 0 20px 0px 10px;
}

.list table td {
 padding: 6px 0;
 position:relative;
}
</style>
</head>

<body>
    <div class="list">
        <header>
        <h3>내정보 보기</h3>
    </header>
        <form action="" name="myFrm">
            <table>
                <tr>
                    <th><span>이메일</span></th>
                    <td> ${info.email }</td>
                </tr>
                <tr>
                    <th><span>성별</span></th>
                    <td> ${info.gender } </td>
                </tr>
                <tr>
                    <th><span>생년월일</span></th>
                    <td>${info.jumin }</td>
                </tr>
                <tr>
                    <th><span>휴대폰번호</span></th>
                    <td>${info.phone }</td>
                </tr>
                <tr>
                    <th><span>주소</span></th>
                    <td> ${info.address } </td>
                </tr>
            </table>
    </form>
        </div>
</body>

</html>