package abstracts;

public class Dog extends Animal {

	public Dog()
	{
		super();
	}
	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("멍멍이가 먹습니다.");
	}
	@Override
	public void speak() {
		System.out.println("멍멍멍");
	}
}
