package be.vdab.rekening;

public final class Spaarrekening extends Rekening{
    private static double intrest;

    public Spaarrekening(String reknr, double intrest) {
        this(reknr, intrest, 0.0);

    }

    public Spaarrekening(String rekeningNr, double intrest, double saldo) {
        super(rekeningNr, saldo);
        setIntrest(intrest);
    }

    public static double getIntrest() {
        return intrest;
    }

    public static void setIntrest(double intrest) {
        if (intrest > 0.0){
            Spaarrekening.intrest = intrest;
        }
    }

    @Override
    public void afhalen(double bedrag){
        if (bedrag > 0){
            if (getSaldo()-bedrag >= 0){
                super.afhalen(bedrag);
            }
        }
    }

    @Override
    public String toString(){
        return super.toString() + ", " + intrest;
    }

    @Override
    public double berekenIntrest(){
        return getSaldo() * intrest / 100;
    }
}