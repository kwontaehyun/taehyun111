package abstracts;


public class AnimalExample {

	public static void main(String[] args) {
//		Animal animal = new Animal(); // 인스턴스를 생성불가.
		Animal animal = null;
		animal = new Dog();
		animal.setName("das");
		animal.eat();
		animal.speak();
		System.out.println(animal.getName());
		
		animal = new Cat();
		animal.eat();
		animal.speak();
		
	}

}
