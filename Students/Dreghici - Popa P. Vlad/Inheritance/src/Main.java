import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Creep creep0 = new Creep();
		Creep creep1 = new Melee_Creep();
		Creep creep2 = new Ranged_Creep();
		
		System.out.println(creep1.getDamage());
		System.out.println(creep2.getDamage());
		
		//creep1.Attack(creep2);
		Unit rc = new Creep();
		System.out.println(rc instanceof Unit);
		
		System.out.println("Press 1 to attack");
		Scanner fromKeyboard = new Scanner(System.in);
		int command = fromKeyboard.nextInt();
		int i;
		for(i=0;i<5;i++)
			if(command == 1)
			{
				creep1.Attack(creep2);
				creep2.TakeDamage(creep1.getDamage());
				if(creep2.getHp()<=0) {
					System.out.println("Ranged creep is dead!");
					break;
				}
				System.out.println("Ranged creep has " + creep2.getHp() + " hp left");
			}
		
		for(i=0;i<5;i++)
			if(command == 1)
			{
				creep2.Attack(creep1);
				creep1.TakeDamage(creep2.getDamage());
				if(creep1.getHp()<=0) {
					System.out.println("Melee creep is dead!");
					break;
				}
				System.out.println("Melee creep has " + creep1.getHp() + " hp left");
			}
	}

}
