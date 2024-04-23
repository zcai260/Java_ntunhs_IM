package hw8;

public class Mage extends Character{
    public int mana;
    public Mage(String name, int health, int attackPower,int mana){
        super(name,health,attackPower);
        this.mana = mana;
    }
    public void castSpell(Character other) {
        if (mana >= 20) {
            int spellDamage = attackPower * 2;
            other.takeDamage (spellDamage);
            mana -= 20;
            System.out.println(name+"施放法術,造成" + spellDamage + "傷害");
        } else {
            System.out.println(name+"法力不足");
        }
    }
	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("戰士名稱:"+name+",生命值:"+ health + ",攻擊力:"+ attackPower +",法力值:" + mana);
	}
}
