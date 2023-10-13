package be.vdab.util;

public class Isbn13Exception extends RuntimeException{
    private String fouteIsbn;

    public Isbn13Exception(String message, String fouteIsbn) {
        super(message);
        this.fouteIsbn = fouteIsbn;
    }

    public String getFouteIsbn() {
        return fouteIsbn;
    }
}
