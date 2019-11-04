import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static List<Plant> myPlants = new List<>();
	public static List<String> adjectives = new List<>(){{
		add("edible");
		add("larger");
		add("smaller");
		add("tiny");
		add("narrow");
		add("twisted");
		add("inflated");
	}};
	public static List<String> specialAdjectives = new List<>(){{
		add("poisonous");
		add("carnivorous");
		add("glowing");
		add("medicinal");
		add("dry");
	}};

	public static void main(String[] args) {
		// create template plant objects, more is better
		Scanner scan = new Scanner(System.in);
		String result = scan.next();
		
	}

	public static Plant findPlant(String name)	{
		for (Plant plant : myPlants) {
			if(plant.name == name){
				return plant;
			}
		}
	}

	public static void arrayApplicable(boolean flowering) { //OUTDATED
		/* fill applicablePlants with all plant objects with the given growthType */
		applicablePlants.clear();
		for (Plant unit : DataBase.plants) {
			if(unit.flowering == flowering)
			{
				applicablePlants.add(unit);
			}
		}
	}

	public static Plant randomPlant() { //OUTDATED
		final int index = (int) Math.ceil(Math.random() * applicablePlants.size());
		return applicablePlants.get(index);
	}

	public static void printPlant(Plant active) //OUTDATED
	{
		System.out.println(active.name + " is a ");
		if(active.flowering){
			System.out.println("flowering plant");
		}
		else{
			System.out.println("non-flowering plant");
		}
		System.out.println(" of subtype " + active.subType + " except ");
		//System.out.println(active.adjective + ". ");
		System.out.println("Color one: " + "(" + active.mainColor.getR() + ", " + active.mainColor.getG() + ", " + active.mainColor.getB() + ")");
		System.out.println("Color one: " + "(" + active.secondaryColor.getR() + ", " + active.secondaryColor.getG() + ", " + active.secondaryColor.getB() + ")");
		System.out.println("Color one: " + "(" + active.tertiaryColor.getR() + ", " + active.tertiaryColor.getG() + ", " + active.tertiaryColor.getB() + ")");
	}

	public static String randomAdjective() {
		/*
		* choose from a random set of adjectives. With a small probability, add another
		* adjective. With a slightly larger probaility is a special adjective
		*/
		String chain = "";
		int rand = random(0, 10);

		if (rand < 5) {
			chain.concat(" " + adjectives.get(random(0, adjectives.size() - 1)));
		} else if (rand == 5) {
			chain.concat(" " + adjectives.get(random(0, adjectives.size() - 1)));
			chain.concat(" " + adjectives.get(random(0, adjectives.size() - 1)));
		} else if (rand == 6) {
			chain.concat(" " + adjectives.get(random(0, adjectives.size() - 1)));
			chain.concat(" " + adjectives.get(random(0, adjectives.size() - 1)));
			chain.concat(" " + adjectives.get(random(0, adjectives.size() - 1)));
		} else {
			chain.concat(" " + adjectives.get(random(0, adjectives.size() - 1)));
		}
		return chain;
	}

	public static int random(int min, int max) {
		Random rand = new Random();
		return rand.nextInt(max + 1 - min) + min;
	}
}
