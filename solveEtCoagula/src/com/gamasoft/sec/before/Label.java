package com.gamasoft.sec.before;

public class Label {
    private Address address;
    private Printer printer;

    public Label(Printer printer, Address address) {
        this.printer = printer;
        this.address = address;
    }

    public void sendToPrinter() {
        int mx = 0;
        for (String line : address.getLines()) {
            mx = mx > line.length() ? mx: line.length();
        }
        String side = "+" + createString(mx - 2, "-") + "+";
        printer.printLine(side);
        for (String line : address.getLines()) {
            String spaces = createString(mx - line.length() - 4, " ");
            printer.printLine("| " + line + spaces + " |");
        }
        printer.printLine(side);
    }

    private String createString(int length, String ofChar) {
        return new String(new char[length + 4]).replace("\0", ofChar);
    }
}
