
public class Creep extends Unit{
	
	private int damage;
	private int hp;
	
	public Creep() {
		System.out.println("Creep");
	}
	 
	public Creep(int damage,int hp) {
		this.damage = damage;
		this.hp = hp;
	}
	
	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public void Attack(Unit unit) {
		System.out.println("Creep attacks Unit");
	}
	
	public void TakeDamage(int damage) {
		this.hp = hp - damage;
	}
	
}
