package be.vdab.rekening;

import be.vdab.util.RekeningnummerException;

public abstract class Rekening {
    private String rekeningNr;
    private double saldo;

    public Rekening(String rekeningNr) {
        setRekeningNr(rekeningNr);
    }

    public Rekening(String rekeningNr, double saldo) {
        this(rekeningNr);
        if (saldo >= 0) {
            this.saldo = saldo;
        }
    }

    public String getRekeningNr() {
        return rekeningNr;
    }

    public final void setRekeningNr(String rekeningNr) {
        if (checkIBANnummer(rekeningNr)) {
            this.rekeningNr = rekeningNr;
        } else {
            throw new RekeningnummerException("ongeldig IBANreknr", rekeningNr);
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public void storten(double bedrag) {
        if (checkBedrag(bedrag)) {
            saldo += bedrag;
        }
    }

    public void afhalen(double bedrag) {
        if (checkBedrag(bedrag)) {
            saldo -= bedrag;
        }
    }

    public void overschrijven(Rekening rek, double bedrag) {
        if (checkBedrag(bedrag)) {
            saldo -= bedrag;
            rek.storten(bedrag);
        }
    }

    private boolean checkIBANnummer (String reknr){
        if (reknr == null || reknr.isBlank() || reknr.length()!= 19 || !reknr.substring(0,2).equals("BE")){
            return false;
        }
        try {
            Integer.parseInt(reknr.substring(2,4));
            var d1 = Integer.parseInt(reknr.substring(5, 9));
            var d2 = Integer.parseInt(reknr.substring(10, 14));
            var d3 = Integer.parseInt(reknr.substring(15, 17));
            var d4 = Integer.parseInt(reknr.substring(17, 19));
            var tienCijfers = d1 * 1000000 + d2 * 100 + d3;
            var rest = (int) (tienCijfers%97);
            return rest == d4;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    private boolean checkBedrag(double bedrag) {
        return bedrag > 0.0;
    }

    public abstract double berekenIntrest();

    @Override
    public String toString(){
        return rekeningNr + ", " + saldo;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) {
            return true;
        }
        if (!(o instanceof Rekening rekening)){
            return false;
        }

        return rekeningNr.equals(rekening.getRekeningNr());
    }
}