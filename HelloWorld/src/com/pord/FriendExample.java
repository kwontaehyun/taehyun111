package com.pord;

public class FriendExample {
	public static void main(String[] args) {
		//친구의 정보 (이름, 전화번호, 이메일, 키 ,몸무게)
		Friend f1 = new Friend();
		f1.friendName = "권태현";
		f1.friendPhone = "010-7221-3915";
		f1.eMail = "abc@email.com";
		f1.height = 123.4;
		f1.weight = 56.7;

		Friend f2 = new Friend();
		f2.friendName = "태현";
		f2.friendPhone = "010-1234-5678";
		f2.eMail = "def@email.com";
		f2.height = 321;
		f2.weight = 65.4;
		
		Friend f3 = new Friend();
		f3.friendName = "현";
		f3.friendPhone = "010-1234";
		f3.eMail = "ght@email.com";
		f3.height = 154;
		f3.weight = 45.4;
		
		Friend[] friends = {f1, f2, f3};
		System.out.println(f1);
		System.out.println(f2);
	
		for(int i =0; i<friends.length; i++)
		{
			if(friends[i].height < 170)
			{
				System.out.println("이름 : " + friends[i].friendName);
				System.out.println("전화번호 : " + friends[i].friendPhone);
				System.out.println("==================================");
			}
		}
	}
}
