package be.vdab.rekening;

public final class Zichtrekening extends Rekening{
    private int maxKrediet;
    private static final double INTREST_ZICHTREKENING = 0.25;

    public Zichtrekening(String rekeningNr, int maxKrediet) {
        this(rekeningNr, 0.0, maxKrediet);
    }

    public Zichtrekening(String rekeningNr, double saldo, int maxKrediet) {
        super(rekeningNr, saldo);
        setMaxKrediet(maxKrediet);
    }

    public int getMaxKrediet() {
        return maxKrediet;
    }

    public final void setMaxKrediet(int maxKrediet) {
        if (maxKrediet > 0) {
            this.maxKrediet = maxKrediet;
        }
    }

    @Override
    public void afhalen(double bedrag){
        if (bedrag > 0){
            if (getSaldo()-bedrag >= (-maxKrediet)){
                super.afhalen(bedrag);
            }
        }
    }

    @Override
    public String toString(){
        return super.toString() + ", " + maxKrediet;
    }

    @Override
    public double berekenIntrest(){
        if (getSaldo() > 0) {
            return getSaldo() * INTREST_ZICHTREKENING / 100;
        } else {
            return 0.0;
        }
    }

}
