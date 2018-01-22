package com.codurance.merchantgalaxy;

public class MerchantGalaxy {
    private final Console console;

    public MerchantGalaxy(Console console) {
        this.console = console;
    }

    public void run() {
        String input = console.readLine();
        while(!input.equals("exit")) {
            input = console.readLine();
        }

        console.printLine("That's all folks!");
    }
}
