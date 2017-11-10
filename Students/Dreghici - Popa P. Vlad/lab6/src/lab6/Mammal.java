package lab6;

public class Mammal implements Animal,Comparable<Object> {

	public int age;
	public String name;
	
	public Mammal() {

	}
	
	public Mammal(int age, String name) {
		this.age = age;
		this.name = name;
		
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void eat() {
		// TODO Auto-generated method stub
		System.out.println(this.name + " eats");
	}

	public void travel() {
		// TODO Auto-generated method stub
		System.out.println(this.name+ " travels");
	}

	public int compareTo(Mammal arg0) {
		// TODO Auto-generated method stub
		if(age==arg0.age)
			return 0;
		else if(age>arg0.age) return 1;
		else return -1;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
