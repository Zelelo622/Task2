package ru.vsu.num28;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int sum = readingMoneyAndCakeAmount("amount —> ");
        int price1 = readingMoneyAndCakeAmount("price of 1 cake —> ");
        int quantity1 = readingMoneyAndCakeAmount("number of 1 cakes —> ");
        int price2 = readingMoneyAndCakeAmount("price of 2 cake —> ");
        int quantity2 = readingMoneyAndCakeAmount("number of 2 cakes —> ");

        checkingTheCostOfCake1(price1, price2, sum, quantity1, quantity2);
        checkingTheCostOfCake2(price1, price2, sum, quantity1, quantity2);
    }

    private static void checkingTheCostOfCake1(int price1, int price2, int sum, int quantity1, int quantity2) {
        // Remaining balance
        int bal;

        int price = Math.min(price1, price2);

        if (price == price1) {
            if (sum >= price && sum <= price * quantity1) {
                System.out.print("You bought —> ");
                bal = sum / price;
                System.out.println(bal);
            }
            if (sum > price * quantity1 && sum <= price * quantity1 + price2 * quantity2) {
                System.out.print("You bought —> ");
                bal = quantity1 + ((sum - price * quantity1) / price2);
                System.out.println(bal);
            }
            if (sum > price * quantity1 + price2 * quantity2) {
                System.out.print("You bought —> ");
                bal = quantity1 + quantity2;
                System.out.println(bal);
            }
            if (sum < price) {
                System.out.println("You won't buy anything");
            }
        }
    }

    private static void checkingTheCostOfCake2(int price1, int price2, int sum, int quantity1, int quantity2) {
        // Remaining balance
        int bal;

        int price = Math.min(price1, price2);

        if (price == price2) {
            if (sum < price) {
                System.out.println("You won't buy anything");
            }
            if (sum >= price && sum <= price * quantity2) {
                System.out.print("You bought --> ");
                bal = sum / price;
                System.out.println(bal);
            }
            if (sum > price * quantity2 && sum <= price * quantity2 + price1 * quantity1) {
                System.out.print("You bought --> ");
                bal = quantity2 + ((sum - price * quantity2) / price1);
                System.out.println(bal);
            }
            if (sum > price * quantity2 + price1 * quantity1) {
                System.out.print("You bought --> ");
                bal = quantity1 + quantity2;
                System.out.println(bal);
            }
        }
    }


    static int readingMoneyAndCakeAmount(String name) {
        System.out.printf("Enter the %s", name);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}