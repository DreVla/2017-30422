
public class Survivor extends Unit {

	private int Hp;
	private int Damage;
	private int Hunger;
	private int Thirst;
	private int Energy;
	private int Sickness;
	
	public Survivor(String name) {
		this.name = name;
		this.Hp = 100;
		this.Damage = 10;
		this.Hunger = 70;
		this.Thirst = 70;
		this.Energy = 70;
		this.Sickness = 10;
		
	}

	public int getSickness() {
		return Sickness;
	}

	public void setSickness(int sickness) {
		Sickness = sickness;
	}

	public int getEnergy() {
		return Energy;
	}

	public void setEnergy(int energy) {
		Energy = energy;
	}

	public int getHp() {
		return Hp;
	}

	public void setHp(int hp) {
		Hp = hp;
	}

	public int getDamage() {
		return Damage;
	}

	public void setDamage(int damage) {
		Damage = damage;
	}

	public int getHunger() {
		return Hunger;
	}

	public void increaseHunger(int hunger) {
		this.Hunger = this.Hunger + hunger;
	}

	public int getThirst() {
		return Thirst;
	}

	public void increaseThirst(int thirst) {
		this.Thirst = this.Thirst + thirst;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void LoseEnergy(int value) {
		this.Energy = this.Energy - value;
	}
	
	public void LoseStats(int value) {
		this.Hunger = this.Hunger - value;
		this.Thirst = this.Thirst - value;
	}
	
	public void Attack(Unit unit1, Unit unit2) {
		System.out.println(unit1.name + " attacks " + unit2.name + " for " + this.Damage + " damage");
	}
	
	public int TakeDamage(int damage) {
		System.out.println(this.name + " takes " +damage + " damage and has " + (this.Hp - damage) + " hp left");
		return this.Hp = this.Hp - damage;
	}
}
