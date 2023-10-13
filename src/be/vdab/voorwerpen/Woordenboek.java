package be.vdab.voorwerpen;

public class Woordenboek extends Boek{
    private String taal;
    private final static float WINSTMARGE = 1.75F;

    public Woordenboek() {
        this("Woordenboek Engels", "Van Dale", 30.10F, "vertaal woordenboek","978-3-16-148410-0",
                "Engels-Nederlands");
    }

    public Woordenboek(String titel, String auteur, float aankoopprijs, String genre, String isbn13, String taal) {
        super(titel, auteur, aankoopprijs, genre, isbn13);
        setTaal(taal);
    }

    public void setTaal(String taal) {
        if (taal != null){
            this.taal = taal;
        }
    }

    @Override
    public void gegevensTonen() {
        System.out.println("\nWOORDENBOEK");
        super.gegevensTonen();
        System.out.println("taal: " + taal);
        System.out.println("Berekende winst: " + winstBerekenen());
    }

    @Override
    public float winstBerekenen() {
        return super.getAankoopprijs() * WINSTMARGE;
    }

    @Override
    public String toString() {
        return  super.toString() + " ; " + taal + " ; " + WINSTMARGE;
    }
}
