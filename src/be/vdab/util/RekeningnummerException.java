package be.vdab.util;

public class RekeningnummerException extends RuntimeException{
    private String foutRekeningNummer;

    public RekeningnummerException() {
    }

    public RekeningnummerException(String message) {
        super(message);
    }

    public RekeningnummerException(String message, String foutRekeningNummer) {
        super(message);
        this.foutRekeningNummer = foutRekeningNummer;
    }

    public String getFoutRekeningNummer() {
        return foutRekeningNummer;
    }

}
