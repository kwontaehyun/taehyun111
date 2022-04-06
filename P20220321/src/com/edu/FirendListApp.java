package com.edu;

public class FirendListApp {
	public static void main(String[] args)
	{
		Friend[] friends = new Friend[10];
		
		Friend f1 = new Friend();
		
		f1.setName("권태현");
		f1.setAge(25);
		f1.setHeight(189.1);
		f1.setWeight(68.9);
		f1.setPhone("010-2323-9845");
		
		UnivFriend f2 = new UnivFriend("서현일", 29, 178.3, 69.2, "010-1111-2222");
		f2.setUniversity("대구대");
		f2.setMajor("컴퓨터공학과");
		
		ComFriend f3 = new ComFriend("최규완", 29, 179.3, 75.2, "010-1341-7349", "naver", "지도app개발연구원");
		
		friends[0] = f1;
		friends[1] = f2;
		friends[2] = f3;
		
		Friend f4 = new Friend();
		
		f4.setName("권태현");
		f4.setAge(25);
		f4.setHeight(189.1);
		f4.setWeight(68.9);
		f4.setPhone("010-2323-9845");
		
		UnivFriend f5 = new UnivFriend("서현", 290, 1878.3, 690.2, "010-1212-3333");
		f5.setUniversity("대구대");
		f5.setMajor("컴퓨터공학과");
		
		ComFriend f6 = new ComFriend("최규완", 29, 179.3, 75.2, "010-1341-7349", "naver", "지도app개발연구원");
		
		friends[0] = f1;
		friends[1] = f2;
		friends[2] = f3;
		friends[3] = f4;
		friends[4] = f5;
		friends[5] = f6;

		for(int i=0; i<friends.length; i++)
		{
			if(friends[i] instanceof UnivFriend)
				System.out.println(friends[i].toString());
		}
		

//		for(int i=0; i<friends.length; i++)
//			if(friends[i] != null)
//				System.out.println(friends[i].toString());
//		
//		
		Friend friend = (Friend) f2; // UnivFriend; getUniversity, getMajor
		friend = f1; //
		UnivFriend uni = null;
		if(friend instanceof UnivFriend) { // friend 참조변수값이 UnivFriend의 인스턴스인지 확인하고,
			uni = (UnivFriend)friend; // Casting 해야함.
			uni.getUniversity(); // 부모클래스의 참조변수 => 자식클래스의 참조변수 할당가능.
		}
		//학교친구만 출력
		
		
	}

}
