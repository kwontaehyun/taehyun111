package com.edu;

//주민번호 입력 ->  00년 이전은 남자 1 여자 2 이후는 남자 3 여자 4

//-, " " ,or 공백없이 넣는
//getGender() -> 매개값 주민번호 -> 남자이면 남자, 여자이면 여자.

public class IDCheck {

	public String getGender(String IdCheck) {

//		System.out.println(IdCheck.length());
//		System.out.println(IdCheck.charAt(7));
//		if (IdCheck.length() == 13 || IdCheck.length() == 14) {
//			if (IdCheck.charAt(6) == '1' || IdCheck.charAt(6) == '3')
//				return "남자";
//			else if (IdCheck.charAt(7) == '1' || IdCheck.charAt(7) == '3')
//				return "남자";
//			else
//				return "여자";
//		}
		
		IdCheck = IdCheck.replace(" ", "");
		IdCheck = IdCheck.replace("-", "");
		char aaa = IdCheck.charAt(6);
		
		switch(aaa) {
		case '1':
		case '3':
			return "남자";
		case '2':
		case '4':
			return "여자";
		}
		return null;

	}

}
