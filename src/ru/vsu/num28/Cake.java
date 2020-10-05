package ru.vsu.num28;

import java.util.Scanner;

public class Cake {

    public static void main(String[] args) {
        int sum = readInteger("amount —> ");
        int priceCake1 = readInteger("price of 1 cake —> ");
        int numberCakes1 = readInteger("number of 1 cakes —> ");
        int priceCake2 = readInteger("price of 2 cake —> ");
        int numberCakes2 = readInteger("number of 2 cakes —> ");
        int bal1 = checkCostOfCake(priceCake1, priceCake2, sum, numberCakes1, numberCakes2);
        int bal2 = checkCostOfCake(priceCake2, priceCake1, sum, numberCakes2, numberCakes1);
        int bal = Math.max(bal1, bal2);

        printNumberOfPurchasedCakes(bal);
    }

    public static int checkCostOfCake(int priceCake1, int priceCake2, int sum, int numberCakes1, int numberCakes2) {
        int price = Math.min(priceCake1, priceCake2);

        if (price == priceCake1) {
            if (sum >= price && sum <= price * numberCakes1) {
                return sum / price;
            }
            if (sum > price * numberCakes1 && sum <= price * numberCakes1 + priceCake2 * numberCakes2) {
                return numberCakes1 + ((sum - price * numberCakes1) / priceCake2);
            }
            if (sum > price * numberCakes1 + priceCake2 * numberCakes2) {
                return numberCakes1 + numberCakes2;
            }
        }
        return 0;
    }

    static void printNumberOfPurchasedCakes(int bal){
        System.out.print("You bought —> " + bal);
    }

    static int readInteger(String name) {
        System.out.printf("Enter the %s", name);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}