package be.vdab.jpfhfdst16;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            var toetsenbord = new Scanner(System.in);
            new Invoer().geefGetal(toetsenbord.nextInt());
        } catch (GetalMagNietOnderNulException e){
            System.out.println("Fout: " + e.getMessage());
        }
    }
}
