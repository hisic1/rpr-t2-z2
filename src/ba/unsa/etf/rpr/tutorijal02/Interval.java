package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    private double Pocetna, Krajnja;
    private boolean dalPripada1, dalPripada2;
    Interval(double poc, double kraj, boolean dalPripada1, boolean dalPripada2){
        if(poc>kraj)throw new IllegalArgumentException();
        Pocetna=poc;
        Krajnja=kraj;
        this.dalPripada1=dalPripada1;
        this.dalPripada2=dalPripada2;
    }
    Interval(){
        Pocetna=0;
        Krajnja=0;
        dalPripada1=false;
        dalPripada2=false;
    }
    public boolean isNull(){
        return (Pocetna==0 && Krajnja==0 && !dalPripada1 && !dalPripada2);
    }
    public boolean isIn(double Tacka){
        if(!dalPripada1 && !dalPripada2)
            return (Tacka>Pocetna && Tacka<Krajnja);
        if(!dalPripada1 && dalPripada2)
            return (Tacka>Pocetna && Tacka<=Krajnja);
        if(dalPripada1 && !dalPripada2)
            return (Tacka>=Pocetna && Tacka<Krajnja);
        else
        return (Tacka>=Pocetna && Tacka<=Krajnja);
    }
    public Interval intersect(Interval drugi){
        return intersect(this,drugi);
    }
    public static Interval intersect(Interval i1, Interval i2) {
        Interval presjek= new Interval();
        if(i1.Pocetna>=i2.Pocetna) {
            presjek.Pocetna = i1.Pocetna;
            presjek.dalPripada1=i1.dalPripada1;
        }
        else {
            presjek.Pocetna = i2.Pocetna;
            presjek.dalPripada1=i2.dalPripada1;
        }
        if(i1.Krajnja<=i2.Krajnja) {
            presjek.Krajnja = i1.Krajnja;
            presjek.dalPripada2=i1.dalPripada2;
        }
        else {
            presjek.Krajnja = i2.Krajnja;
            presjek.dalPripada2=i2.dalPripada2;
        }
        return presjek;
    }
    //[2.2,2.5)
    public String toString() {
        if(this.isNull())return "()";
        Double p=Pocetna; //za toString() omotacka klasa
        Double k=Krajnja;
        if(!dalPripada1 && !dalPripada2)
            return "("+p.toString()+","+k.toString()+")";
        if(!dalPripada1 && dalPripada2)
            return "("+p.toString()+","+k.toString()+"]";
        if(dalPripada1 && !dalPripada2)
            return "["+p.toString()+","+k.toString()+")";
        else
            return "["+p.toString()+","+k.toString()+"]";
    }
    public boolean equals(Interval i){
        return (this.Pocetna==i.Pocetna && this.Krajnja==i.Krajnja &&this.dalPripada1==i.dalPripada1 &&this.dalPripada2==i.dalPripada2);
    }
}
