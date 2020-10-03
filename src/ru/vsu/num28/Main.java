package ru.vsu.num28;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int sum = readingMoneyAndCakeAmount("amount —> ");
        int priceCake1 = readingMoneyAndCakeAmount("price of 1 cake —> ");
        int numberCakes1 = readingMoneyAndCakeAmount("number of 1 cakes —> ");
        int priceCake2 = readingMoneyAndCakeAmount("price of 2 cake —> ");
        int numberCakes2 = readingMoneyAndCakeAmount("number of 2 cakes —> ");

        checkingTheCostOfCake(priceCake1, priceCake2, sum, numberCakes1, numberCakes2);
        checkingTheCostOfCake(priceCake2, priceCake1, sum, numberCakes2, numberCakes1);
    }

    private static void checkingTheCostOfCake(int priceCake1, int priceCake2, int sum, int numberCakes1, int numberCakes2) {
        // Remaining balance
        int bal;

        int price = Math.min(priceCake1, priceCake2);

        if (price == priceCake1) {
            if (sum >= price && sum <= price * numberCakes1) {
                System.out.print("You bought —> ");
                bal = sum / price;
                System.out.println(bal);
            }
            if (sum > price * numberCakes1 && sum <= price * numberCakes1 + priceCake2 * numberCakes2) {
                System.out.print("You bought —> ");
                bal = numberCakes1 + ((sum - price * numberCakes1) / priceCake2);
                System.out.println(bal);
            }
            if (sum > price * numberCakes1 + priceCake2 * numberCakes2) {
                System.out.print("You bought —> ");
                bal = numberCakes1 + numberCakes2;
                System.out.println(bal);
            }
            if (sum < price) {
                System.out.println("You won't buy anything");
            }
        }
    }

    static int readingMoneyAndCakeAmount(String name) {
        System.out.printf("Enter the %s", name);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}