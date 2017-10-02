package com.gamasoft.sec.after;

public class Label {

    public static void print(Printer printer, Client client) {
        int mx = 0;
        for (String line : client.getLines()) {
            mx = mx > line.length() ? mx: line.length();
        }
        String side = "+" + createString(mx - 2, "-") + "+";
        printer.printLine(side);
        for (String line : client.getLines()) {
            String spaces = createString(mx - line.length() - 4, " ");
            printer.printLine("| " + line + spaces + " |");
        }
        printer.printLine(side);
    }

    private static String createString(int length, String ofChar) {
        return new String(new char[length + 4]).replace("\0", ofChar);
    }

}
