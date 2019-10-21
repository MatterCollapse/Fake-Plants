import java.util.Random;

public class RandomSpecies {

    private static String[] Beginning = { "Sol", "Tu", "Alli", "Se", "Lyco", "Melo", "Sa", "Baby", "A", "Ma", "Lo",
            "Pere", "Multi", "Festu", "Cucu", "Lage", "Sice", "Poa", "Cir", "Vul", "Ole", "Arve", "Festu", "Dacty",
            "Sello", "Photo", "Ama", "Musca", "Basi", "Dio", "Aga", "bi" };
    private static String[] Middle = { "an", "ber", "pa", "per", "nger", "lix", "lon", "lba", "tsu", "lium", "nne",
            "flo", "ca", "rbi", "na", "ra", "si", "ga", "re", "thalli", "ni", "myce", "ri", "spor" };
    private static String[] End = { "cium", "ceae", "osum", "cum", "arc", "es", "ceur", "der", "ica", "dana", "rum",
            "ta", "um", "re", "lon", "ana", "ria", "te", "us" };

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
            return first + second;
        } else {
            return first + second + third;
        }
    }

}