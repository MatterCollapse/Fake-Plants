import java.awt.Color;
import java.util.Random;

public class Plant {
    private static String[] Shape = {"acicular", "falcate", "orbicular", "rhomboid", "acuminate", "flabellate", "ovate", "rosette", "alternate", "haste", "palmate", "spatulate", "aristate", "lanceolate", "pedate", "spear-shaped", "bipinnate", "linear", "peltate", "subulate", "cordate", "labed", "perfoliate", "trifoliate/ternate", "cuneate", "obcordate", "odd pinnate", "tripinnate", "deltoid", "obovate", "even pinnate", "truncate", "digitate", "obtuse", "pinnatisect", "unifoliate", "elliptic", "opposite", "reniform", "whorled", ""};
    private static String[] Margin = {"ciliate", "crenate", "dentate", "denticulate", "double serrate", "entire", "lobate", "serrate", "serrulate", "sinuate", "spiny", "undulate"};
    private static String[] Venation = {"arcuate", "cross-venulate", "dichotomous", "longitudinal", "palmate", "parallel", "pinnate", "reticulate", "rotate"};
    
    private static String[] fungusCap = {"campanulate", "conical", "convex", "depressed", "flat", "infudibuliform", "ovate", "umbontae"};
    private static String[] fungusRing = {"pendant", "flaring", "sheathing", "double", "cobwebby", "ring zone"};
    private static String[] fungusGills = {"adnate", "adnexed", "decurrent", "free", "sinuate", "emarginate"};
    private static String[] fungusShape = {"cup", "false morels", "true morels", "teeth", "chanterelles", "coral fungi", "polypores", "puffballs", "earthstars", "stinkhorns", "*spines*", "*plates*"};
    
    private static String[] smell = {"herbal", "sweet", "off", "neutral", "uninvasive", "woodsy", "acidic", "repulsive", "freshening", "tart", "light", "warm", "minty", "suspicious", "hearthy"};
    private static String[] adjective = {"poisonous", "herbal", "edible", "carnivorous", "inedible"};

    String name = "empty";
    boolean flowering = false;
    boolean makeSeeds = false;
    boolean hasRoots = false;
    boolean hasleaves = true;

    String classification = "plant";
    String growthType = "no Type";
    String seeding = "none";
    String seedingResult = "none";
    String scent = "";
    String edibility = "";
    Color mainColor = new Color(0, 0, 0);
    Color secondaryColor = new Color(0, 0, 0);

    String leafShape = "";
    String leafMargin = "";
    String leafVenation = "";

    String branches = "none";
    boolean hasNeedles = false;

    boolean capped = false;
    String capShape = "none";
    String ringShape = "none";
    String gillShape = "none";
    String fungusEception = "none";
    String succulentType = "not a succulent";

    Double aveFullHeightMetres = 0;

    Random rand = new Random();

    public Plant(Plant basePlant)
    {
        this.name = basePlant.name + " " + NamePlant.generateName();
        this.scent = smell[rand.nextInt(smell.length)];
        this.mainColor = new Color(basePlant.mainColor.getR() + random(-10, 10), basePlant.mainColor.getG() + random(-10, 10), basePlant.mainColor.getB() + random(-10, 10));
        this.secondaryColor = new Color(basePlant.tertiaryColor.getR() + random(-10, 10), basePlant.tertiaryColor.getG() + random(-10, 10), basePlant.tertiaryColor.getB() + random(-10, 10));
        if(random(1, 10) < 3)
        {
            this.edibility = adjective[rand.nextInt(adjective.length)];
        }
    }

    public Plant()
    {
        this.name = NamePlant.generateName();
        this.scent = smell[rand.nextInt(smell.length)];
        this.mainColor = new Color(Random(0, 255), Random(0, 255), Random(0, 255));
        this.secondaryColor = new Color(Random(0, 255), Random(0, 255), Random(0, 255));
        if(rand.nextBoolean()) //Not Fungus
        {
            if(rand.nextBoolean()) //Make Seeds
            {
                makeSeeds = true;
                if(rand.nextBoolean()) //Flowering
                {
                    flowering = true;
                    classification = "angiosperm";
                    aveFullHeightMetres = parabolicRandom(0.01, 30.5, .92, 1);
                }
                else
                {
                    classification = "gymnosperm";
                    aveFullHeightMetres = parabolicRandom(1, 100, 15, 1);
                    seeding = "pinecones";
                    if(random(1, 10) < 8){
                        hasNeedles = true;
                        return;
                    }
                }
                hasleaves = true;
                growLeaves();
            }
            else
            {
                if(random(0, 10) < 7) //Roots
                {
                    hasRoots = true;
                    hasleaves = true;
                    growLeaves();

                    if(rand.nextBoolean())
                    {
                        classification = "fern";
                        aveFullHeightMetres = parabolicRandom(0.01, 25, 2, 1);
                    }
                    else
                    {
                        classification = "succulent";
                        aveFullHeightMetres = parabolicRandom(0.02, 3.658, 0.21, 1);
                        growSucculent();
                    }
                }
                else
                {
                    if(random(0, 10) > 7) //Some Roots
                    {
                        classification = "moss";
                        aveFullHeightMetres = parabolicRandom(0.01, .1, .013, 1);
                        growMoss();
                    }
                    else
                    {
                        classification = "algae";
                        growAlgae();
                    }
                }
            }
        }
        else
        {
            classification = "fungus";
            aveFullHeightMetres = parabolicRandom(0.001, 5, .1, 1);
            growFungus();
        }
    }
    
    public void growingType()
    {
        seeding = "flowers";

        switch(random(1, 7)) {
            case 1:
            growthType = "ground";
            branches = "many, flexible";
            if(rand.nextBoolean())
                growVegi();
            break;
            case 2:
            growthType = "tree";
            if(rand.nextBoolean())
                growFruit();
            case 3:
            growthType = "shrub / bush";
            if(rand.nextBoolean())
                growFruit();
            break;
            case 4:
            growthType = "vine";
            if(rand.nextBoolean())
                growFruit();
            break;
            case 5:
            growthType = "forb";
            break;
            case 6:
            growthType = "grass";
            if(rand.nextBoolean())
                growGrain();
            break;
            case 7:
            growthType = "aquatic plant";
            if(rand.nextBoolean())
                growVegi();
            break;
        }

        if(growthType != "grass" && growthType != "ground")
        {
            growBranches();
        }
    }

    /* GROW METHODS */

    public void growLeaves()
    {
        leafShape = Shape[rand.nextInt(Shape.length)];
        leafMargin = Margin[rand.nextInt(Margin.length)];
        leafVenation = Venation[rand.nextInt(Venation.length)];
    }

    public void growBranches()
    {
        switch(random(1, 3)) {
            case 1:
            branches = "none";
            break;
            case 2:
            branches = "few";
            break;
            case 3:
            branches = "many";
            break;
            }

            if (rand.nextBoolean()) {
            branches += ", firm";
            }
            else {
            branches += ", flexible";
            }

            if (rand.nextInt(10) < 4) {
            branches += ", thorny";
            }
    }

    public void growMoss()
    {
        mainColor = new Color(maincolor.getR / 3, mainColor.getG, mainColor.getB / 3);

        switch(random(1, 7))
        {
            case 1:
            growthType = "sheet ";
            break;
            case 2:
            growthType = "cushion ";
            break;
            case 3:
            growthType = "haircap ";
            break;
            case 4:
            growthType = "rockcap ";
            break;
            case 5:
            growthType = "aquatic ";
            break;
        }

        switch(random(1, 3))
        {
            case 1:
            growthType += "liverwort";
            break;
            case 2:
            growthType += "hornwort";
            break;
            case 3:
            growthType += "moss";
            break;
        }
    }

    public void growAlgae()
    {
        mainColor = new Color(maincolor.getR / 3, mainColor.getG, mainColor.getB / 3);

        switch(random(1, 3))
        {
            case 1:
            growthType = "red algae";
            break;
            case 2:
            growthType = "brown algae";
            break;
            case 3:
            growthType = "green algae";
            break;
        }
    }

    public void growFungus()
    {
        switch(random(1, 3))
        {
            case 1:
                growthType = "Sac Fungi";
            break;
            case 2:
                growthType = "Club Fungi";
                if(rand.nextBoolean())
                {
                    capped = true;
                    capShape = fungusCap[rand.nextInt(fungusCap.length)];
                }
                ringShape = fungusRing[rand.nextInt(fungusRing.length)];
                gillShape = fungusGills[rand.nextInt(fungusGills.length)];
            break;
            case 3:
                fungusEception = fungusShape[rand.nextInt(fungusShape.length)];
            break;
        }
    }

    public void growSucculent()
    {
        seeding = "offshoots";

        switch(random(1, 3))
        {
            case 1:
                leafShape = "Thick" + leafShape;
                succulentType = "leafed";
            break;
            case 2:
                leafShape = "none";
                leafMargin = "none";
                leafVenation = "none";
                growBranches();
                succulentType = "branched";
            break;
            case 3:
                leafShape = "Thick" + leafShape;
                growBranches();
                succulentType = "branched / leafed";
            break;
        }
    }

    public void growVegi() 
    {
        switch(random(1, 8)) 
        {
            case 1:
                seeding = "flower vegetable";
            break;
            case 2:
                seeding = "bulb vegetable";
            break;
            case 3:
                seeding = "root vegetable";
            break;
            case 4:
                seeding = "stem vegetable";
            break;
            case 5:
                seeding = "seed vegetable";
            break;
            case 6:
                seeding = "tuber vegetable";
            break;
            case 7:
                seeding = "leaf vegetable";
            break;
            case 8:
                seeding = "fruit vegetable";
            break;
        }
    }

    public void growFruit() 
    {
        switch(random(1, 6)) 
        {
            case 1:
                seeding = "simple fruit";
            break;
            case 2:
                seeding = "aggregate fruit";
            break;
            case 3:
                seeding = "multiple fruit";
            break;
            case 4:
                seeding = "false fruit";
            break;
            case 5:
                seeding = "nut";
            break;
            case 6:
                seeding = "pseudocereal";
            break;
        }
    }

    public void growGrain() //Very simple method left for the sake of consistency
    {
        seeding = "grain";
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