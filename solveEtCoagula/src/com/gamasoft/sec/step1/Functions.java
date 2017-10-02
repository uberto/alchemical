package com.gamasoft.sec.step1;

public class Functions {

    public static void printLabel(Client client, Printer printer){
        if (client.address != null)
            sendToPrinter(client, printer);
    }

    public static void printLine(Printer printer, String line){
        System.out.println(line); //simulate sending to printer
    }

    public static void sendToPrinter(Client client, Printer printer) {
        int mx = 0;
        for (String line : getLines(client)) {
            mx = mx > line.length() ? mx: line.length();
        }
        String side = "+" + createString(mx - 2, "-") + "+";
        printLine(printer, side);
        for (String line : getLines(client)) {
            String spaces = createString(mx - line.length() - 4, " ");
            printLine(printer,"| " + line + spaces + " |");
        }
        printLine(printer, side);
    }

    private static String createString(int length, String ofChar) {
        return new String(new char[length + 4]).replace("\0", ofChar);
    }

    public static String[] getLines(Client c) {
        String[] lines = new String[4];
        lines[0] = c.title + " " + c.fullName;
        lines[1] = c.address.street;
        lines[2] = c.address.city;
        lines[3] = c.address.areaCode;
        return lines;
    }

}
