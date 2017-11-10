package lab6;
import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Mammal Dog = new Mammal();
		int age;
		System.out.println("Insert mammal Age");
		Scanner var = new Scanner(System.in);
		age = var.nextInt();
		Dog.setAge(age);
		String name;
		System.out.println("Insert mammal name");
		Scanner string = new Scanner(System.in);
		name = string.nextLine();
		Dog.setName(name);
		System.out.println("Your mammal is " + Dog.getAge() + " years old and is called " + Dog.getName());
		Dog.eat();
		Dog.travel();
		
		
	}

}
