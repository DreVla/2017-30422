
public class Ranged_Creep extends Creep {

	public Ranged_Creep() {
		super(20,60);
		System.out.println("Ranged_Creep");
	}
	@Override // <- This is an annotaion
	public void Attack(Unit unit) {
		System.out.println("Ranged creep attacks unit for 20hp");
	}

}
