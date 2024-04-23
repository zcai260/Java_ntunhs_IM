package hw8;

public class RPG {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Warrior warrior = new Warrior("戰士",100,15,5);
		Mage mage = new Mage("法師",80,10,50);
		
		mage.castSpell(warrior);
		warrior.useShield();
		warrior.attack(mage);
		mage.display();
		warrior.display();
	}

}
