
public class Zombie extends Unit {
	
	private int Hp;
	private int Damage;
	
	public Zombie(int hp, int damage) {
		this.Hp = hp;
		this.Damage = damage;
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

	public void Attack(Unit unit1, Unit unit2) {
		System.out.println(unit1.name + " attacks " + unit2.name + " for " + this.Damage + " damage");
	}
	
	public int TakeDamage(int damage) {
		System.out.println(this.name + " takes " + damage + " damage and has " + (this.Hp - damage) + " hp left");
		return this.Hp = this.Hp - damage;
	}
	
	
}
