package com.compan.num28;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int sum = readInt("amount —> ");
        int price1 = readInt("price of 1 cake —> ");
        int num1 = readInt("number of 1 cakes —> ");
        int price2 = readInt("price of 2 cake —> ");
        int num2 = readInt("number of 2 cakes —> ");

        CheapCake1(price1, price2, sum, num1, num2);
        CheapCake2(price1, price2, sum, num1, num2);
    }

    private static void CheapCake1 (int price1, int price2, int sum, int num1, int num2) {
        // Remaining balance
        int bal;

        int price = Math.min(price1, price2);

        if (price == price1) {
            if (sum >= price && sum <= price * num1) {
                System.out.print("You bought —> ");
                bal = sum / price;
                System.out.println(bal);
            }
            if (sum > price * num1 && sum <= price * num1 + price2 * num2) {
                System.out.print("You bought —> ");
                bal = num1 + ((sum - price * num1) / price2);
                System.out.println(bal);
            }
            if (sum > price * num1 + price2 * num2) {
                System.out.print("You bought —> ");
                bal = num1 + num2;
                System.out.println(bal);
            }
            if (sum < price) {
                System.out.println("You won't buy anything");
            }
        }
    }

    private static void CheapCake2 (int price1, int price2, int sum, int num1, int num2) {
        // Remaining balance
        int bal;

        int price = Math.min(price1, price2);

        if (price == price2) {
            if (sum < price) {
                System.out.println("You won't buy anything");
            }
            if (sum >= price && sum <= price * num2) {
                System.out.print("You bought --> ");
                bal = sum / price;
                System.out.println(bal);
            }
            if (sum > price * num2 && sum <= price * num2 + price1 * num1) {
                System.out.print("You bought --> ");
                bal = num2 + ((sum - price * num2) / price1);
                System.out.println(bal);
            }
            if (sum > price * num2 + price1 * num1) {
                System.out.print("You bought --> ");
                bal = num1 + num2;
                System.out.println(bal);
            }
        }
    }


    public static int readInt(String name) {
        System.out.printf("Enter the %s", name);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}