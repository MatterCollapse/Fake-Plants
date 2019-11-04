import java.util.Random;

public class NameAnimal {

    private static String[] Beginning = { "Anoma", "Atra", "Acta", "Ca", "Casauri", "Co", "Cory", "Cro", "Ery", "Qua", "Lepro", "Odo", "Pa", "Pro", "Tina", "Tropi", "Uro", "Vi", "Are", "Phydo", "Vul", "Bi", "Aga", "", "", ""};
    private static String[] Middle = { "spid", "n", "form", "dor", "tal", "c", "tern", "typhl", "stom", "leo", "gn", "cellar", "mid", "doph", "pel", "per", "pes", "pen", "rid", "", "", "", "", "", "", "", "", ""};
    private static String[] End = { "id", "us", "is", "es", "as", "ine", "opid", "ia", "ath", "idia", "ae", "tid", "in", "ilia", "iline"};

    private static Random rand = new Random();

    public static String generateName() {
        String first = Beginning[rand.nextInt(Beginning.length)];
        String second = Middle[rand.nextInt(Middle.length)];
        String third = End[rand.nextInt(End.length)];

        if (first.endsWith(String.valueOf(second.charAt(second.length() - 1)))) {
            first = first.substring(0, first.length() - 1);
        }
        if (second.endsWith(String.valueOf(third.charAt(third.length() - 1)))) {
            second = second.substring(0, second.length() - 1);
        }

        if (rand.nextBoolean()) {
            return one + two;
        } else {
            return first + second + third;
        }
    }

}