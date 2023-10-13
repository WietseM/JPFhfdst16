package be.vdab.jpfhfdst16;

public class Invoer {
    public void geefGetal (int getal) throws GetalMagNietOnderNulException {
        if (getal < 0) {
            throw new GetalMagNietOnderNulException("Het getal moet groter zijn dan 0");
        }
    }
}
