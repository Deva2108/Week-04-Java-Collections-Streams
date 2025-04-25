public class SpaceNormalizer {

    public static String normalizeSpaces(String input) {
        return input.replaceAll("\\s+", " ");
    }

    public static void main(String[] args) {
        String input = "This   is   an  example   with   multiple  spaces.";
        String output = normalizeSpaces(input);

        System.out.println(output);
    }
}
