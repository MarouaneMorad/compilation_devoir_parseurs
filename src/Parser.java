public class Parser {
    private String input;
    private int pos;

    public Parser(String input) {
        this.input = input;
        this.pos = 0;
    }

    public boolean parse() {
        return parseS() && pos == input.length();
    }

    private boolean parseS() {
        if (pos >= input.length()) return false;

        int savedPos = pos;

        if (match('b') && parseS() && match('b')) {
            return true;
        }

        pos = savedPos;
        if (match('c') && parseA() && match('c')) {
            return true;
        }

        return false;
    }

    private boolean parseA() {
        if (pos >= input.length()) return false;

        int savedPos = pos;

        if (match('b') && parseA() && parseA()) {
            return true;
        }

        pos = savedPos;
        if (match('c') && parseA() && parseS() && parseA() && match('b')) {
            return true;
        }

        pos = savedPos;
        if (match('d') && match('c') && match('b')) {
            return true;
        }

        return false;
    }

    private boolean match(char expected) {
        if (pos < input.length() && input.charAt(pos) == expected) {
            pos++;
            return true;
        }
        return false;
    }
}