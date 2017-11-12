
public class Zombie extends Unit {
	
	
	
	public Zombie(String name,int hp, int damage) {
		super(name,hp,damage);
	}

	public void Attack(Unit unit1, Unit unit2) {
		System.out.println(unit1.getName() + " attacks " + unit2.getName() + " for " + unit1.getDamage() + " damage");
	}
	
	public void TakeDamage(Unit unit,int damage) {
		System.out.println(unit.getName() + " takes " + damage + " damage and has " + (unit.getHp() - damage) + " hp left");
		unit.setHp(unit.getHp() - damage);
	}
	
	
}
