
public class Unit {

	private String name;
	private int Hp;
	private int Damage;

	public Unit(String name,int hp, int damage) {
		this.name = name;
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
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void Attack(Unit unit1, Unit unit2) {
		System.out.println(unit1.getName() + " attacks " + unit2.getName() + " for " + unit1.getDamage() + " damage");
	}
	
	public void TakeDamage(Unit unit,int damage) {
		System.out.println(unit.getName() + " takes " + damage + " damage and has " + (unit.getHp() - damage) + " hp left");
		unit.setHp(unit.getHp() - damage);
	}
		
		
}
