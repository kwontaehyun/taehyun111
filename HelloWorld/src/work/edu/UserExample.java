package work.edu;

public class UserExample {

	public static void main(String[] args) {
		User u1 = new User();
		
		u1.setUserId("none");
		u1.setUserGrade("A");
		u1.setUserPhone("010-1234-5678");
		u1.setpoint(1001);
		
		User u2 = new User();
		
		u2.setUserId("ABC");
		u2.setUserGrade("B");
		u2.setUserPhone("010-5678-1234");
		u2.setpoint(10000);
		
		User u3 = new User();
		
		u3.setUserId("DEF");
		u3.setUserGrade("C");
		u3.setUserPhone("010-1541-1633");
		u3.setpoint(500);
		
		User[] user = {u1,u2,u3};
		
		for(int i=0; i<user.length; i++)
		{
			if(user[i].getpoint() > 1000 && user[i].getUserGrade() == "A")
				System.out.println(user[i].getUserInfo());
		}
	}

}
