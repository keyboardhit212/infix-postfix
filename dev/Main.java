package dev;

import postfix.Postfix;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("Enter expression: ");
        String expression = console.nextLine();
        System.out.println(new Postfix(expression));
    }
}
