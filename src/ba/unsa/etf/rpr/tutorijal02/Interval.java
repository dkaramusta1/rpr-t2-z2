package ba.unsa.etf.rpr.tutorijal02;


public class Interval {
    double pocetna, krajnja;
    boolean pocetnaPripadaIntervalu, krajnjaPripadaIntervalu;

    Interval(){
        this.pocetna = 0;
        this.krajnja = 0;
        this.pocetnaPripadaIntervalu = false;
        this.krajnjaPripadaIntervalu = false;
    }

    Interval(double pocetna, double krajnja, boolean pocetnaPripadaIntervalu, boolean krajnjaPripadaIntervalu) throws IllegalArgumentException {
        if(pocetna > krajnja){
            throw new IllegalArgumentException();
        }
        this.pocetna = pocetna;
        this.krajnja = krajnja;
        this.pocetnaPripadaIntervalu = pocetnaPripadaIntervalu;
        this.krajnjaPripadaIntervalu = krajnjaPripadaIntervalu;
    }

    public boolean isNull(){
        return pocetna == 0 && krajnja == 0;
    }

    public boolean isIn(double tacka){
        if(tacka < pocetna || tacka > krajnja){
            return false;
        }
        if(pocetnaPripadaIntervalu && !krajnjaPripadaIntervalu){
            return tacka < krajnja;
        }
        else if(!pocetnaPripadaIntervalu && krajnjaPripadaIntervalu){
            return tacka > pocetna;
        }
        else{
            return tacka >= pocetna && tacka <= krajnja;
        }
    }

    public Interval intersect(Interval interval){
        double pocetakPresjeka, krajPresjeka;
        boolean pocetakPresjekaPripada, krajPresjekaPripada;
        if(this.pocetna > interval.pocetna){
            pocetakPresjeka = this.pocetna;
            pocetakPresjekaPripada = this.pocetnaPripadaIntervalu;
        }
        else {
            pocetakPresjeka = interval.pocetna;
            pocetakPresjekaPripada = interval.pocetnaPripadaIntervalu;
        }
        if(this.krajnja < interval.krajnja){
            krajPresjeka = this.krajnja;
            krajPresjekaPripada = this.krajnjaPripadaIntervalu;
        }
        else{
            krajPresjeka = interval.krajnja;
            krajPresjekaPripada = interval.krajnjaPripadaIntervalu;
        }
        if(pocetakPresjeka < krajPresjeka){
            return new Interval(pocetakPresjeka, krajPresjeka, pocetakPresjekaPripada, krajPresjekaPripada);
        }
        return new Interval();
    }

    public static Interval intersect(Interval interval1, Interval interval2){
        double pocetakPresjeka, krajPresjeka;
        boolean pocetakPresjekaPripada, krajPresjekaPripada;
        if(interval1.pocetna > interval2.pocetna){
            pocetakPresjeka = interval1.pocetna;
            pocetakPresjekaPripada = interval1.pocetnaPripadaIntervalu;
        }
        else {
            pocetakPresjeka = interval2.pocetna;
            pocetakPresjekaPripada = interval2.pocetnaPripadaIntervalu;
        }
        if(interval1.krajnja < interval2.krajnja){
            krajPresjeka = interval1.krajnja;
            krajPresjekaPripada = interval1.krajnjaPripadaIntervalu;
        }
        else{
            krajPresjeka = interval2.krajnja;
            krajPresjekaPripada = interval2.krajnjaPripadaIntervalu;
        }
        if(pocetakPresjeka < krajPresjeka){
            return new Interval(pocetakPresjeka, krajPresjeka, pocetakPresjekaPripada, krajPresjekaPripada);
        }
        return new Interval();
    }

    @Override
    public boolean equals(Object intv){
        if (intv == this) {
            return true;
        }
        if (!(intv instanceof Interval)) {
            return false;
        }
        Interval interval = (Interval) intv;
        return interval.pocetna == this.pocetna && interval.krajnja == this.krajnja && interval.pocetnaPripadaIntervalu == this.pocetnaPripadaIntervalu && interval.krajnjaPripadaIntervalu == this.krajnjaPripadaIntervalu;
    }

    public static boolean equals(Interval int1, Interval int2){
        return int1.pocetna == int2.pocetna && int1.krajnja == int2.krajnja && int1.pocetnaPripadaIntervalu == int2.pocetnaPripadaIntervalu && int1.krajnjaPripadaIntervalu == int2.krajnjaPripadaIntervalu;
    }

    @Override
    public String toString(){
        String pocetakIntervala, krajIntervala;
        if(pocetnaPripadaIntervalu){
            pocetakIntervala = "[";
        }
        else {
            pocetakIntervala = "(";
        }
        if(krajnjaPripadaIntervalu){
            krajIntervala = "]";
        }
        else{
            krajIntervala = ")";
        }
        if(pocetna == 0 && krajnja == 0) {
            return pocetakIntervala + krajIntervala;
        }
        return pocetakIntervala + pocetna + "," + krajnja + krajIntervala;
    }

}
