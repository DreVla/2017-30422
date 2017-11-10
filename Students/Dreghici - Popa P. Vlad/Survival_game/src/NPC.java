
public class NPC extends Unit{

	private int Hp;
	private int Damage;
	
	public NPC(int hp, int damage) {
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
}
