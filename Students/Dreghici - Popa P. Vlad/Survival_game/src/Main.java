import java.util.Scanner;	//for scanning input
import java.util.Random;	//for random actions



public class Main {
	
	public static void promptEnter(){
		   System.out.println("Press \"ENTER\" to continue...");
		   Scanner scanner = new Scanner(System.in);
		   scanner.nextLine();
		}
	
	public static void Status(Survivor Player) {
		System.out.println("You are " + Player.getHunger() + "% hungry, " + Player.getThirst() + "% thirsty and have " + Player.getHp() + 
				"% health. Your damage is " + Player.getDamage() + " and your energy " + Player.getEnergy() + "." + " Your sickness is " + Player.getSickness() + "% .");
	}
	
	public static int chance() {
		int chance;
		Random i = new Random();
		chance = i.nextInt(10)+1;
		return chance;
	}
	
	public static int Battle (Survivor Player, Unit unit2, int unitChance) {
		int j=1,chance;
		while(j!=0) {
			chance = chance();
			if(chance>5) {
				Player.Attack(Player, unit2);
				unit2.TakeDamage(unit2,Player.getDamage());
			}
			else {
				System.out.println(Player.getName() + " misses!");
			}
			if(unit2.getHp()<=0){
				System.out.println("\n" + unit2.getName() + " is dead!");
				return 1;
			}
			chance = chance();
			if(chance>unitChance) {
				unit2.Attack(unit2, Player);
				Player.TakeDamage(Player,unit2.getDamage());
			}
			else {
				System.out.println(unit2.getName() + " misses!");
			}
			if(unit2.getHp()<=0){
				System.out.println("\n" + unit2.getName() + " is dead!");
				break;
			}
			if(Player.getHp()<=0) {
				System.out.println("\n" + Player.getName() + " is dead!");
				return 0;
			}
			promptEnter();
		}
		return 2;
	}
	
	public static void Scavenge(Survivor Player) {
		int i,j=1,action,combat,equip;
		
		System.out.println("You chose to scavenge the surroundings...\n");
		promptEnter();
		Random random = new Random();
		i = random.nextInt(5)+1;
		switch(i) {
		case 1: {
			System.out.println("You come across and abandoned building. When you look inside you see a WALKER and a table with 2 water bottles and a baseball bat.\n"
					+ "How do you proceed?");
			Walker walker1 = new Walker();
			System.out.println("1: Attack \n2: Run\n");
			action = new Scanner(System.in).nextInt();
			if(action == 2) {
				System.out.println("You run away! You lose 10 energy. Coward...");
				Player.LoseEnergy(10);
			}
				
			else {
				System.out.println("You chose to attack the " + walker1.getName() + "!");
				combat = Battle(Player,walker1,6);
				if(combat == 0){
					break;
				}
				else if(combat == 1) {
					System.out.println("You drink the two water bottles! Your thirst increases with 10 and your HP with 5!\n"
							+ "The damage of the baseball bat is 20. Do you want to equip it?\n1: Yes 2: No");
					equip = new Scanner(System.in).nextInt();
					if(equip == 1) {
						Player.setDamage(20);
						System.out.println("Your damage is now 20!");
					}
					Player.increaseThirst(10);
					Player.increaseHp(5);
				}
			}
			break;
		}
		case 2:{
			
			Walker walker2 = new Walker();
			System.out.println("You are attacked by a walker! You can only fight him!");
			promptEnter();
			combat = Battle(Player,walker2,6);
			break;
		}
		case 3:{
			System.out.println("You come across and old market. You find a can of beans and a water bottle!");
			System.out.println("Your hunger increases with 10, your thirst with 5 and you HP with 10!");
			Player.increaseHunger(10);
			Player.increaseThirst(5);
			Player.increaseHp(10);
			
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
				System.out.println("You chose to attack the " + tank1.getName() + "!");
				combat = Battle(Player,tank1,2);
				if(combat == 0) {
					break;
				}
				else if(combat == 1){
					System.out.println("You gather as many supplies as you can and you run away. You got 3 cans of beans and 5 water bottles!\n"
							+ "Your hunger,thirst and hp increase with 30!");
					Player.increaseThirst(30);
					Player.increaseHunger(30);
					Player.increaseHp(30);
				}
				
			}
			break;
		}
		
		case 5: {
			System.out.println("You reach an old gas station. When you peek inside you see a lone bandit. How do you proceed?");
			Unit bandit1 = new Bandit();
			System.out.println("1: Attack \n2: Run\n");
			action = new Scanner(System.in).nextInt();
			if(action == 2) {
				System.out.println("You run away! You lose 10 energy. Coward...");
				Player.LoseEnergy(10);
			}
				
			else {
				System.out.println("You chose to attack the " + bandit1.getName() + "!");
				combat = Battle(Player,bandit1,4);
				if(combat == 0) {
					break;
				}
				else if(combat == 1){
					System.out.println("You start looting the bandits body. You find two watter bottles, a can of beans and a rusty knife!");
					System.out.println("Your hunger, thirst and HP increases with 20!\nThe damage of the rusty knife is 30! Do you want to equip it?\n1: Yes 2: No");
					equip = new Scanner(System.in).nextInt();
					if(equip == 1) {
						Player.setDamage(30);
						System.out.println("Your damage is now 30!");
					}
					Player.increaseThirst(20);
					Player.increaseHunger(20);
					Player.increaseHp(20);
				}
			}
		
			break;
		}
		
		
		}

	}

	public static void LookForSupplies(Survivor Player) {
		int i,j=1,action,combat;
		
		System.out.println("You chose to look around for supplies...\n");
		promptEnter();
		Random random = new Random();
		i = random.nextInt(5)+1;
		switch(i) {
		case 1: {
			System.out.println("As you walk across the wasteland you find an old house. When you look through the window you don't see any movement.\n"
					+ "The house looks like it was already looted, but there still might be some supplies inside. Do you want to enter?\n1: Yes 2: No");
			action = new Scanner(System.in).nextInt();
			if(action == 1) {
				System.out.println("You slowly enter the house. Everywhere you look there is dust. It looks like someone was already here.\n"
						+ "As you search the house you find a corpse. The smell sickens you...\nYou manage to find 2 water bottles and a can of beans. Your hunger,thirst and HP increase with 10.\n");
				promptEnter();
				System.out.println("As you try to leave the house you hear a voice behind you whispering 'Goodbye!' and after that you hear a gunshot");
				Player.setHp(0);
			}
			
			break;
		}
		
		case 2: {
			System.out.println("You encounter a road. As you keep walking on the road you reach an old gas station. The place looks empty. Do you want to look inside?\n"
					+ "1: Yes 2: No");
			action = new Scanner(System.in).nextInt();
			if(action == 1) {
				System.out.println("You enter the gas station and you start looting. You only find a can of corn and 2 bandages.\n"
						+ "Your hunger increases with 10 and your HP with 20. You leave the place");
				Player.increaseHunger(10);
				Player.increaseHp(20);
			}
			break;
		}
		
		case 3: {
			Unit walker1 = new Walker();
			Unit walker2 = new Walker();
			
			System.out.println("As you walk through the valley of the shadow of death you see a hospital. It looks like the place is swarmed with zombies. How do you proceed?\n"
					+ "1: Try to loot 2: Run away");
			action = new Scanner(System.in).nextInt();
			if(action == 2) {
				System.out.println("You run away! You lose 10 energy. Coward...");
				Player.LoseEnergy(10);
			}
			else if(action == 1) {
				System.out.println("You decide to loot. As you aproach the hospital a walker attacks you! It's too late to run now!");
				combat = Battle(Player,walker1,6);
				if(combat == 0){
					break;
				}
				System.out.println("After you kill the walker you run inside to see what you can find. You come across 3 bandages, 2 water bottles and an antidote\n"
						+ "Your HP increases with 30, your sickness is reduced by 10 and you thirst is increased by 20!");
				Player.increaseHp(30);
				Player.setSickness(Player.getSickness()-10);
				Player.increaseThirst(20);
				
				promptEnter();
				System.out.println("You quickly try to run away. As you leave, another walker attacks you!");
				combat = Battle(Player,walker2,6);
				if(combat == 0){
					break;
				}
				System.out.println("You made it out alive!");
				
			}
			
			break;
		}
		
		case 4: {
			System.out.println("You endlessly walk in circles without finding anything. Your hunger, thirst and energy are decreased by 10");
			Player.setEnergy(Player.getEnergy() - 10);
			Player.setHunger(Player.getHunger() - 10);
			Player.setThirst(Player.getThirst() - 10);
			
			break;
		}
		
		case 5: {
			System.out.println("You stubmle across a scrapyard. Do you want to look around?\n1: Yes 2: No");
			action = new Scanner(System.in).nextInt();
			if(action == 1) {
				System.out.println("As you look around you find nothing but dust and sand among the abandoned cars. You decide to leave...");
			}
			break;
		}
		
		}
		
	}

	public static void Hunt(Survivor Player) {
		int i,j=1,action,combat,chance;
		
		System.out.println("You chose to go hunting...\n");
		promptEnter();
		Random random = new Random();
		i = random.nextInt(3)+1;
		switch(i) {
		case 1:{
			System.out.println("As you walk through the wasteland you see a wild boar. It looks like the boar did not spot you yet. How do you proceed?\n"
					+ "1: Sneak upon it and try to kill him\n2: Run for it and hope you get him");
			action = new Scanner(System.in).nextInt();
			if(action == 1) {
				System.out.println("You carefully aproach the boar...");
				promptEnter();
				chance = chance();
				if(chance>3) {
					System.out.println("You succesfully kill the boar. You gather all the meat you can and eat it. Your hunger increases with 40 but you become sick. +30 sickness");
					Player.increaseHunger(40);
					Player.setSickness(Player.getSickness() + 30);
				}
				else {
					System.out.println("You scared the boar and it ran awway!");
					promptEnter();
				}
			}
			else if(action == 2) {
				System.out.println("You rush for the boar!");
				promptEnter();
				chance = chance();
				if(chance >7) {
					System.out.println("You succesfully kill the boar. You gather all the meat you can and eat it. Your hunger increases with 40 but you become sick. +30 sickness");
					Player.increaseHunger(40);
					Player.setSickness(Player.getSickness() + 30);
				}
				else {
					System.out.println("You scared the boar and it ran away!");
					promptEnter();
				}
			}
			
			break;
		}
		
		case 2:{
			System.out.println("You reach a forest. As you look through the trees you spot a wild deer. How do you proceed?\n"
					+ "1: Sneak and try to kill it\n2: Run for it and hope you kill it");
			action = new Scanner(System.in).nextInt();
			if(action == 1) {
				System.out.println("You sneak through the trees in atempt to kill it.");
				promptEnter();
				chance = chance();
				if(chance>8) {
					System.out.println("You succesfully reach the deer and kill it! You cut as much meat as you can carry. Your hunger increases with 50 but you get sick. +30 sickness");
					Player.setSickness(Player.getSickness() + 30);
					Player.increaseHunger(50);
				}
				else {
					System.out.println("You scare the deer! It runs away.");
				}
			if(action == 2) {
				System.out.println("You run for the deer in hope you kill it!");
				promptEnter();
				chance = chance();
				if(chance == 10) {
					System.out.println("You succesfully reach the deer and kill it! You cut as much meat as you can carry. Your hunger increases with 50 but you get sick. +30 sickness");
					Player.setSickness(Player.getSickness() + 30);
					Player.increaseHunger(50);
				}
				else {
					System.out.println("You scared the deer and it ran away...");
					promptEnter();
					
				}
			}
			}
			
			break;
		}
		
		case 3:{
			Unit tank1 = new TankZombie();
			System.out.println("As you walk through the wasteland you can't see any animals around. You decide to lay down for a couple of seconds.\n");
			promptEnter();
			System.out.println("As you rest you hear a weird sound from behind you. You turn around to see a Tank Zombie\n"
					+ "You start fighting with it!");
			promptEnter();
			combat = Battle(Player,tank1,4);
			if(combat == 0) {
				break;
			}
			else if(combat == 1) {
				System.out.println("After you defeat the Tank Zombie you lay down, exhausted. You lose 10 energy...");
				Player.setEnergy(Player.getEnergy() - 10);
			}
			
			break;
		}
		}
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
		System.out.println("Your character is called " + Player.getName());
		Status(Player);
		promptEnter();
		System.out.println("You have a limited time of 10 days to play! You lose 10 hunger and thirst each day and recover 5 energy. If you are still alive after 10 days you win. Choose wisely...\n");
		
		for(days = 10 ; days > 0 ; days--) {
			System.out.println("What would you like to do?");
			System.out.println("1: Scavenge \n2: Look for supplies \n3: Hunt \n");
			action = new Scanner(System.in).nextInt();
			switch(action) {

				case 1:{
					Scavenge(Player);
					break;
				}
				case 2:{
					LookForSupplies(Player);
					break;
				}
				case 3:{
					Hunt(Player);
					break;
				}
			}
			promptEnter();
			if(Player.getEnergy() <= 0 || Player.getHp() <= 0 || Player.getHunger() <= 0 || Player.getThirst() <= 0 || Player.getSickness() >=100) break;
			System.out.println("\nAs the day passes you lose 10 thirst and hunger and recover 5 energy!");
			Player.LoseStats(10);
			if(Player.getEnergy() <= 0 || Player.getHp() <= 0 || Player.getHunger() <= 0 || Player.getThirst() <= 0 || Player.getSickness() >=100) break;
			Status(Player);
			System.out.println("\nYou have " + (days-1) + " day(s) left..");
			}
		
		if(Player.getEnergy() <= 0 ||Player.getHp() <= 0 || Player.getHunger() <= 0 || Player.getThirst() <= 0 || Player.getSickness() >=100) {
			Status(Player);
			System.out.println("You have died! GAME OVER!");
		}
		else System.out.println("You have survived. Congratulations! Have a cookie!");
		
	}

}
