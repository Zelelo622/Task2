package ru.vsu.num28;

import java.util.Scanner;

public class Cake {

    public static void main(String[] args) {
        int sum = readInteger("amount —> ");
        int priceCake1 = readInteger("price of 1 cake —> ");
        int numberCakes1 = readInteger("number of 1 cakes —> ");
        int priceCake2 = readInteger("price of 2 cake —> ");
        int numberCakes2 = readInteger("number of 2 cakes —> ");
        int bal = minMaxCostCake(priceCake1, priceCake2, sum, numberCakes1, numberCakes2);

        printNumberPurchasedCakes(bal);
    }

    public static int minMaxCostCake(int priceCake1, int priceCake2, int sum, int numberCakes1, int numberCakes2) {
        int bal1 = determineNumberCakes(priceCake1, priceCake2, sum, numberCakes1, numberCakes2);
        int bal2 = determineNumberCakes(priceCake2, priceCake1, sum, numberCakes2, numberCakes1);
        return Math.max(bal1, bal2);
    }

    public static int determineNumberCakes(int priceCake1, int priceCake2, int sum, int numberCakes1, int numberCakes2) {
        int price = Math.min(priceCake1, priceCake2);

        if (price == priceCake1) {
            if (canBuyOnlyFirstTypeCake(sum, price, numberCakes1)) {
                return sum / price;
            }
            if (canBuyOnlySecondTypeCake(sum, price, numberCakes1, priceCake2, numberCakes2)) {
                return numberCakes1 + ((sum - price * numberCakes1) / priceCake2);
            }
            if (canBuyOnlyTwoTypesCakes(sum, price, numberCakes1, priceCake2, numberCakes2)) {
                return numberCakes1 + numberCakes2;
            }
        }
        return 0;
    }

    private static boolean canBuyOnlyFirstTypeCake(int sum, int price, int numberCakes1) {
        return sum >= price && sum <= price * numberCakes1;
    }

    private static boolean canBuyOnlySecondTypeCake(int sum, int price, int numberCakes1, int priceCake2, int numberCakes2) {
        return sum > price * numberCakes1 && sum <= price * numberCakes1 + priceCake2 * numberCakes2;
    }

    private static boolean canBuyOnlyTwoTypesCakes(int sum, int price, int numberCakes1, int priceCake2, int numberCakes2) {
        return sum > price * numberCakes1 + priceCake2 * numberCakes2;
    }

    static void printNumberPurchasedCakes(int bal) {
        System.out.print("You bought —> " + bal);
    }

    static int readInteger(String name) {
        System.out.printf("Enter the %s", name);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}