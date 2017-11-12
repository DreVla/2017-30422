
public class Survivor extends Unit {

	private int Hunger;
	private int Thirst;
	private int Energy;
	private int Sickness;
	
	public Survivor(String name) {
		super(name,100,10);
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

	public int getHunger() {
		return Hunger;
	}

	public void setHunger(int hunger) {
		Hunger = hunger;
	}

	public void setThirst(int thirst) {
		Thirst = thirst;
	}

	public void increaseHunger(int hunger) {
		if(this.Hunger < 100 - hunger) this.Hunger = this.Hunger + hunger;
	}

	public int getThirst() {
		return Thirst;
	}

	public void increaseThirst(int thirst) {
		if(this.Thirst < 100 - thirst ) this.Thirst = this.Thirst + thirst;
	}

	public void LoseEnergy(int value) {
		this.Energy = this.Energy - value;
	}
	
	public void increaseHp(int hp) {
		if(this.getHp() < 100 - hp) this.setHp(this.getHp() + hp);
	}
	
	public void LoseStats(int value) {
		this.Hunger = this.Hunger - value;
		this.Thirst = this.Thirst - value;
		this.Energy = this.Energy + 5;
	}
	public void increaseSickness(int value) {
		this.Sickness = this.Sickness + value;
	}
	
	public void Attack(Unit unit1, Unit unit2) {
		System.out.println(unit1.getName() + " attacks " + unit2.getName() + " for " + unit1.getDamage() + " damage");
	}
	
	public void TakeDamage(Unit unit,int damage) {
		System.out.println(unit.getName() + " takes " + damage + " damage and has " + (unit.getHp() - damage) + " hp left");
		unit.setHp(unit.getHp() - damage);
	}
}
