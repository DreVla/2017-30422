
public class Melee_Creep extends Creep{

	public Melee_Creep() {
		super(10,100);
		System.out.println("Melee_Creep");
	}
	//method overwritting:
	@Override 
	public void Attack(Unit unit) {
		System.out.println("Melee creep attacks unit for 10hp");
	}
	
}
