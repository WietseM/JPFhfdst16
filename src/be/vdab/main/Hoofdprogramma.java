package be.vdab.main;

import be.vdab.util.Isbn13Exception;
import be.vdab.util.Voorwerp;
import be.vdab.voorwerpen.Leesboek;
import be.vdab.voorwerpen.Woordenboek;

public class Hoofdprogramma {
    public static void main(String[] args) {
        var voorwerpen = new Voorwerp[3];
        try {
            voorwerpen[0] = new Leesboek();
        } catch (Isbn13Exception ex) {
            System.out.println(ex.getMessage());
        }

        try {
            voorwerpen[1] = new Leesboek("De wolven van Arazan", "John Flanagan", 16.99F, "Actie/Avontuur", "978-14-302-4764-7", "Fictie");
        } catch (Isbn13Exception ex) {
            System.out.println(ex.getMessage());
        }

        try {
            voorwerpen[2] = new Woordenboek("Van Dale Groot woordenboek Nederlands", "A.H. van den Baar", 34.99F, "vertaal woordenboek", "978-90-664-8143-9", "Nederlands");
        } catch (Isbn13Exception ex) {
            System.out.println(ex.getMessage());
        }

        var winst = 0.0;
        for (var voorwerp : voorwerpen){
            if (voorwerp != null) {
                voorwerp.gegevensTonen();
                winst += voorwerp.winstBerekenen();
            }
        }
        System.out.println(" ");
        System.out.println("De totale winst bedraagt = " + winst);
    }

}

