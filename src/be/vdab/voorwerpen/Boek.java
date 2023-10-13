package be.vdab.voorwerpen;

import be.vdab.util.Isbn13Exception;
import be.vdab.util.Voorwerp;

public abstract class Boek implements Voorwerp {
    private String titel;
    private String auteur;
    private float aankoopprijs;
    private String genre;
    private String isbn13;

    public Boek(String titel, String auteur, float aankoopprijs, String genre, String isbn13) {
            setIsbn13(isbn13);
            setTitel(titel);
            setAuteur(auteur);
            setAankoopprijs(aankoopprijs);
            setGenre(genre);
    }

    public void setIsbn13(String isbn13) {
        if (checkIsbnNummer(isbn13)) {
            this.isbn13 = isbn13;
        }
        else {
            throw new Isbn13Exception("ongeldig isbnnr", isbn13);
        }
    }

    public final void setAankoopprijs(float aankoopprijs) {
        if (aankoopprijs > 0.0) {
            this.aankoopprijs = aankoopprijs;
        }
    }

    public final void setTitel(String titel) {
        if (titel != null) {
            this.titel = titel;
        }
    }

    public final void setAuteur(String auteur) {
        if (auteur != null) {
            this.auteur = auteur;
        }
    }

    public final void setGenre(String genre) {
        if (genre != null) {
            this.genre = genre;
        }
    }

    public float getAankoopprijs() {
        return aankoopprijs;
    }

    private boolean checkIsbnNummer(String isbn) {
        if (isbn == null || isbn.isBlank()) {
            return false;
        }
        //Snellere manier om "-" uit de String te halen
        //var isbnNummer = isbn.replaceAll("-", "");
        var isbnInStukjes = isbn.split("-");
        var builder = new StringBuilder();
        for (var stukje : isbnInStukjes) {
            builder.append(stukje);
        }
        var isbnNummer = builder.toString();
        if (isbnNummer.length() != 13) {
            return false;
        }
        try {
            int som = 0;
            for (var i = 0; i < isbnNummer.length() - 1; i += 2) {
                // charAt() geeft een character terug, substring(beginIndex, Eindindex) geeft een String terug
                // som += Integer.parseInt(isbnNummer.substring(i, i+1));
                som += Integer.parseInt(String.valueOf(isbnNummer.charAt(i)));
                // som += Integer.parseInt(isbnNummer.substring(i+1, i+2));
                som += Integer.parseInt(String.valueOf(isbnNummer.charAt(i + 1))) * 3;
            }
            var laatsteNummer = Integer.parseInt(isbnNummer.substring(isbnNummer.length()-1), isbnNummer.length());
            var rest = som % 10;
            var verschil = 10 - rest;
            if (verschil == 10) {
                verschil = 0;
            }

            return verschil == laatsteNummer;

        } catch (NumberFormatException ex) {
            return false;
        }
    }

    @Override
    public void gegevensTonen() {
        System.out.println("titel: " + titel);
        System.out.println("auteur: " + auteur);
        System.out.println("eigenaar: " + EIGENAAR);
        System.out.println("aankoopprijs: " + aankoopprijs);
        System.out.println("genre: " + genre);
        System.out.println("Isbn13: " + isbn13);
    }

    @Override
    public String toString() {
        return titel + ";" + auteur + ";" + EIGENAAR + ";" + aankoopprijs + ";" + genre + ";" + isbn13;
    }
}