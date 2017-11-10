import java.util.Scanner;	//for scanning input
import java.util.Random;	//for random actions



public class Main {
	
	public static void promptEnter(){
		   System.out.println("Press \"ENTER\" to continue...");
		   Scanner scanner = new Scanner(System.in);
		   scanner.nextLine();
		}
	
	public static void Status(Survivor Player) {
		System.out.println("You are " + Player.getHunger() + "% hungry, " + Player.getThirst() + "% thirsty and have " + Player.getHp() + "% health. Your damage is " + Player.getDamage() + " and your energy " + Player.getEnergy() + "." + " Your sickness is " + Player.getSickness() + "% .");
	}
	
	public static void Scavenge(Survivor Player) {
		int i,j=1,action;
		
		System.out.println("You chose to scavenge the surroundings...\n");
		promptEnter();
		Random random = new Random();
		i = random.nextInt(4)+1;
		switch(i) {
		case 1: {
			System.out.println("You come across and abandoned building. When you look inside you see a WALKER and a table with 2 water bottles. How do you proceed?");
			Walker walker1 = new Walker();
			System.out.println("1: Attack \n2:Run\n");
			action = new Scanner(System.in).nextInt();
			if(action == 2) {
				System.out.println("You run away! You lose 10 energy. Coward...");
				Player.LoseEnergy(10);
			}
				
			else {
				while(j!=0) {
				System.out.println("You attack the Walker!\n");
				Player.Attack(Player, walker1);
				walker1.TakeDamage(Player.getDamage());
				if(walker1.getHp()<=0){
					System.out.println("\nWalker is dead!");
					System.out.println("You drink the two water bottles! Your thirst increases with 10!");
					Player.increaseThirst(10);
					break;
				}
				walker1.Attack(walker1, Player);
				Player.TakeDamage(walker1.getDamage());
				if(Player.getHp()<=0) {
					System.out.println("\n" + Player.name + " is dead!");
					break;
				}
				promptEnter();
			}
			}
			break;
		}
		case 2:{
			Walker walker2 = new Walker();
			System.out.println("You are attacked by a walker! You can only fight him!");
			promptEnter();
			while(j!=0) {
				System.out.println("Walker attacks you!\n");
				walker2.Attack(walker2, Player);
				Player.TakeDamage(walker2.getDamage());
				Player.Attack(Player, walker2);
				walker2.TakeDamage(Player.getDamage());
				if(walker2.getHp()<=0){
					System.out.println("\nWalker is dead!");
					break;
				}
				else if(Player.getHp()<=0) {
					System.out.println("\n" + Player.name + " is dead!");
					break;
				}
				promptEnter();	
			}
			break;
		}
		case 3:{
			System.out.println("You come across and old market. You find a can of beans and a water bottle!");
			System.out.println("Your hunger increases with 10 and your thirst with 5");
			Player.increaseHunger(10);
			Player.increaseThirst(5);
			promptEnter();
			break;
		}
		case 4:{
			System.out.println("You come across and old Pub. Inside is a Tank zombie, but the pub is filled with drinks and food. What do you do?");
			TankZombie tank1 = new TankZombie();
			System.out.println("1: Attack \n2: Run\n");
			action = new Scanner(System.in).nextInt();
			if(action == 2) {
				System.out.println("You run away! You lose 10 energy. Coward...");
				Player.LoseEnergy(10);
			}
			else {
				while(j!=0) {
				System.out.println("You attack the Tank Zombie!\n");
				Player.Attack(Player, tank1);
				tank1.TakeDamage(Player.getDamage());
				tank1.Attack(tank1, Player);
				Player.TakeDamage(tank1.getDamage());
				if(tank1.getHp()<=0){
					System.out.println("\nWalker is dead!");
					System.out.println("You drink the two water bottles! Your thirst increases with 10!");
					Player.increaseThirst(10);
					break;
				}
				else if(Player.getHp()<=0) {
					System.out.println("\n" + Player.name + " is dead!");
					break;
				}
				promptEnter();
			}
			}
			break;
		}
		}

	}

	public static void LookForWater(Survivor Player) {
		int i,j;

	}

	public static void Hunt(Survivor Player) {
		int i,j;
		
		
	}
	

	public static void main(String[] args) {
		int action,i,j,days;
		System.out.println("Press \"ENTER\" to start...");
		   Scanner scanner = new Scanner(System.in);
		   scanner.nextLine();
		String newPlayer;
		System.out.println("Insert a name for your character:");
		newPlayer = new Scanner(System.in).nextLine();
		Survivor Player = new Survivor(newPlayer);
		System.out.println("Your character is called " + Player.getName() +" and is " + Player.getHunger() + "% hungry, " + Player.getThirst() + "% thirsty and has " + Player.getHp() + "% health. Your damage is " + Player.getDamage() + " and your energy " + Player.getEnergy() + "." + " Your sickness is " + Player.getSickness() + "% .");
		promptEnter();
		System.out.println("You have a limited time of 10 days to play! You lose 10 hunger and thirst each day. If you are still alive after 10 days you win. Choose wisely...\n");
		
		for(days = 10 ; days > 0 ; days--) {
			System.out.println("What would you like to do?");
			System.out.println("1: Scavenge \n2: Look for water \n3: Hunt \n");
			action = new Scanner(System.in).nextInt();
			switch(action) {

				case 1: Scavenge(Player);
				case 2: LookForWater(Player);
				case 3: Hunt(Player);
			}
			if(Player.getEnergy() <= 0 || Player.getHp() <= 0 || Player.getHunger() <= 0 || Player.getThirst() <= 0) break;
			System.out.println("\nAs the day passes you lose 10 thirst and hunger!");
			Player.LoseStats(10);
			if(Player.getEnergy() <= 0 || Player.getHp() <= 0 || Player.getHunger() <= 0 || Player.getThirst() <= 0) break;
			Status(Player);
			System.out.println("\nYou have " + (days-1) + " day(s) left..");
			}
		
		if(Player.getEnergy() <= 0 ||Player.getHp() <= 0 || Player.getHunger() <= 0 || Player.getThirst() <= 0) {
			Status(Player);
			System.out.println("You have died! GAME OVER!");
		}
		else System.out.println("You have survived. Congratulations! Have a cookie!");
		
	}

}
