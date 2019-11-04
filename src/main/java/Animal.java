import java.awt.Color;
import java.util.Random;

public class Plant {
    String[] herbivoreDiet = {"nuts", "berries", "fruit", "vegetables", ""};
    String[] carnivoreDiet = {"comparatively small prey", "eggs", "equal-size prey", "insects", "same-species prey"};

    String name = "empty";

    String classification = "creature";
    boolean vertebrate = false;

    String diet = "herivore";
    String dietPreference = "none";

    String birth = "none";
    Color mainColor = new Color(0, 0, 0);
    Color secondaryColor = new Color(0, 0, 0);

    Double aveFullHeightMetres = 0;

    Random rand = new Random();

    public Plant(Animal baseAnimal)
    {
        this.name = baseAnimal.name + " " + NameAnimal.generateName();
        this.mainColor = new Color(baseAnimal.mainColor.getR() + random(-10, 10), baseAnimal.mainColor.getG() + random(-10, 10), baseAnimal.mainColor.getB() + random(-10, 10));
        this.secondaryColor = new Color(baseAnimal.tertiaryColor.getR() + random(-10, 10), baseAnimal.tertiaryColor.getG() + random(-10, 10), baseAnimal.tertiaryColor.getB() + random(-10, 10));  
    }

    public Plant()
    {
        this.name = NameAnimal.generateName();
        this.mainColor = new Color(Random(0, 255), Random(0, 255), Random(0, 255));
        this.secondaryColor = new Color(Random(0, 255), Random(0, 255), Random(0, 255));
        if(rand.nextBoolean()) //vertebrate
        {
            vertebrate = true;
            switch(random(1, 5)){
                case 1: 
                    classification = "amphibian";
                    birth = "egg";
                    spawnAmphibian();
                break;
                case 2: 
                    classification = "bird";
                    birth = "egg";
                    spawnBird();
                break;
                case 3: 
                    classification = "fish";
                    birth = "egg";
                    spawnFish();
                break;
                case 4: 
                    classification = "mammal";
                    birth = "live";
                    spawnMammal();
                break;
                case 5: 
                    classification = "reptile";
                    birth = "egg";
                    spawnReptile();
                break;
            }
        }
        else
        {
            switch(random(1, 6)){
                case 1: 
                    classification = "worm";
                    //birth?
                    spawnWorm();
                break;
                case 2: 
                    classification = "anthropod";
                    //birth?
                    spawnAnthropod();
                break;
                case 3: 
                    classification = "cnidarian";
                    //birth?
                    spawnCnidarian();
                break;
                case 4: 
                    classification = "echinoderm";
                    //birth?
                    spawnEchinoderm();
                break;
                case 5: 
                    classification = "mollusk";
                    //birth?
                    spawnMollusk();
                break;
                case 6: 
                    classification = "sponge";
                    //birth?
                    spawnSponge();
                break;
            }
        }
    }

    /* SPAWN METHODS */

    public void spawnAmphibian()
    {
        switch(random(1, 3)){
            case 1: 
                diet = "herbivore";
            break;
            case 2: 
                diet = "omnivore";
            break;
            case 3: 
                diet = "carnivore";
            break;
        }
    }

    public void spawnBird()
    {
        
    }

    public void spawnFish()
    {
        
    }
    
    public void spawnMammal()
    {
        
    }

    public void spawnReptile()
    {
        
    }

    public void spawnWorm()
    {
        
    }

    public void spawnAnthropod()
    {
        
    }

    public void spawnCnidarian()
    {
        
    }

    public void spawnEchinoderm()
    {
        
    }

    public void spawnMollusk()
    {
        
    }

    public void spawnSponge()
    {
        
    }

    /* RANDOMIZER METHODS */

    public int random(int min, int max) {
		Random rand = new Random();
		return rand.nextInt(max + 1 - min) + min;
    }

    public static double parabolicRandom(double min, double max, double prefered, double distribution) { //distribution 1 is default, larger is closer
        distribution = 1 + 2 * distribution;
        Random rand = new Random();
        if(prefered > max && prefered < min)
            prefered = min;
        double xMax = Math.pow((max - prefered), 1.0 / distribution);
        double xMin = -Math.pow(Math.abs(min - prefered), 1.0 / distribution);
        double x = rand.nextDouble() * (xMax - xMin) + xMin;
        double y = Math.pow(x, distribution) + prefered;
        return y;
    }
}