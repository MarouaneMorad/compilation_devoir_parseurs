public class Main {
    public static void main(String[] args) {
        String[] testCases = {
                "cdcbc",
                "bcdcbcb",
                "cbdcbdcbc",
                "ccdcbcdcbcdcbbcr",
                "cdcbbb",
                "cdcb",
                "ε"
        };

        for (String test : testCases) {
            Parser parser = new Parser(test);
            System.out.println(test + ": " + parser.parse());
        }
    }
}