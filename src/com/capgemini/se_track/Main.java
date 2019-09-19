package com.capgemini.se_track;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try {
            suprise(1);   
        } catch(StackOverflowError e){
            
        }
        
        try {          
            createObject();
        } catch (NullPointerException npe) {
            npe.printStackTrace();   
        }

        try {            
            getCharacter(25);
        } catch(IndexOutOfBoundsException iobe) {
            iobe.printStackTrace();
        }

        try {
            formatInteger();
        } catch(NumberFormatException nfe) {
            nfe.printStackTrace();
        }

        try {
            division();
        } catch(InputMisMatchException ime) {
            ime.printStackTrace();   
        } catch(ArithmeticException ame) {
            ame.printStackTrace();   
        }

        try {
            loopOverArray();
        } catch(ArrayIndexOutOfBoundsException aiob) {
            aiob.printStackTrace();   
        }
            
        waitForInput();
        
        try {
            printName(null);
        } catch(IllegalArgumentException iae) {
            iae.printStackTrace();   
        }
        
        try {
            int myAge = getAgeFromUser();
            
        } catch(IllegalArgumentException e) {
            e.printStackTrace();   
        } catch(NumberFormatException e) {
            e.printStackTrace();   
        }
    }

    private static void createObject() {
        String a; //a is null
        String b = "b";
        String c = "c";
        int i = 10;

        String result = a + b;
        result += c;

        System.out.println(result + Integer.toString(i)); //throws a null pointer exception
    }

    private static void getCharacter(int index) {
        String a = "This is a test string ";
        char c = a.charAt(24); //Throws a IndexOutOfBoundsException
        System.out.println(c);
    }

    private static void division() {
        int a, b, result;

        Scanner input = new Scanner(System.in);
        System.out.println("Input two integers");

        a = input.nextInt(); //InputMisMatchException
        b = input.nextInt();

        result = a / b; //ArithMeticException

        System.out.println("Result = " + result);
    }

    private static void formatInteger() {
        String str = "1;";
        int num = Integer.parseInt (str) ; //NumberFormatException

        System.out.println(num);
    }

    private static String languages[] = { "C", "C++", "Java", "Perl", "Python" };
    private static void loopOverArray() {

        for (int c = 1; c <= 5; c++) {
            System.out.println(languages[c]); //ArrayIndexOutOfBoundsException
        }
    }
    
    public static void printName(String name) {
        if(name == null || name.isEmpty()) {
            throw new IllegalArgumentException("name can't be empty!");
        }
        
        System.out.println("Name: " + name);
    }
    
    public static int getAgeFromUser() {
        Scanner scanner = new Scanner(System.in);
        
        String age = scanner.nextLine(); 
        if(age.isEmpty()) {
            throw new new IllegalArgumentException("age can't be empty!");
        }
        
        return Integer.parseInt(age); //NumberFormatException    
    }
    
    public static void suprise(int num) {
        System.out.println("Number: " + num);
         
        if(num == 0)
            return;
        else
            suprise(++num);
    }

    private static void waitForInput() {
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
