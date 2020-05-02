package model;

import java.util.Random;

import model.GameObject.ObjectType;

public class GameObjectFactory {
		
	/*
	 * this method will generate a random integer between 0 and 5 and will be used by getObject to create one of the 
	 * objects from the enum ObjectType.
	 */
	public static ObjectType createRandomFruit() {
		Random random = new Random();
		int number = random.nextInt(20);
		if (number == 1) //there is a 1 in 20 chance of getting a bonus fruit
			return ObjectType.values()[random.nextBoolean()? 4 : 5];
		return ObjectType.values()[random.nextInt(4)];
		
	}
	
	public static ObjectType createRandomBomb() {
		Random random = new Random();
		return ObjectType.values()[random.nextBoolean()? 6 : 7];
	}
	
	public static GameObjectImplementation getObject(ObjectType objectType) {
		switch(objectType) {
		
		case APPLE:
			return new Apple();
		case BANANA:
			return new Banana();
		case WATERMELON:
			return new Watermelon();
		case SPECIAL_APPLE:
			return new FruitWithBonus(new Apple());
		case SPECIAL_BANANA:
			return new FruitWithBonus(new Banana());
		case SPECIAL_WATERMELON:
			return new FruitWithBonus(new Watermelon());
		case DANGEROUS_BOMB:
			return new DangerousBomb();
		case FATAL_BOMB:
			return new FatalBomb();
		default:
			return null;
		
		}
		
	}

}
