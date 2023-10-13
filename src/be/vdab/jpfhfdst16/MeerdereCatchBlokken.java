package be.vdab.jpfhfdst16;

public class MeerdereCatchBlokken {
    public static void main(String[] args) {
        var tekst = "2";
        // var tekst = "6";
        // var tekst = "abc";
        try {
            var cijfers = new int [] { 12, 5, 28, 37};
            System.out.println("Element uit de array: " + cijfers[Integer.parseInt(tekst)]);
            System.out.println("Deze code wordt alleen uitgevoerd wanneer er geen fout optreedt.");
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException ex) {
            System.out.println(ex.getMessage());
        } catch (RuntimeException ex) {
            System.out.println("RuntimeException: " + ex.getMessage());
        }

    }
}