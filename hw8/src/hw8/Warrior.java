package hw8;

public class Warrior extends Character{
    public int defense;
    public Warrior(String name, int health, int attackPower,int defense){
        super(name,health,attackPower);
        this.defense = defense;
    }
    @Override
    public void takeDamage(int damage) {
    	int reducedDamage = Math.max(damage - defense, 0); 
    	super.takeDamage (reducedDamage);
    }
    
    
    public void useShield(){
        defense += 10;
        System.out.println(name + "使用盾牌，防禦力增加至" + defense);
    }
	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("戰士名稱:"+name+",生命值:"+ health + ",攻擊力:"+ attackPower +",防禦力:" + defense);
	}
    
}