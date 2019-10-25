package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    private double poc, kraj;
    private boolean a, b;


    public Interval(double poc, double kraj, boolean a, boolean b) {
        if (poc > kraj) throw new IllegalArgumentException("Pocetna tacka veca od krajnje");
        this.poc = poc;
        this.kraj = kraj;
        this.a = a;
        this.b = b;
    }

    public Interval() {
        this.poc = 0;
        this.kraj = 0;
        this.a = false;
        this.b = false;
    }


    boolean isNull() {
        if (this.poc == 0. && this.kraj == 0. && this.a == false && this.b == false) return true;
        return false;
    }


    public boolean isIn(double v) {
        if (v >= this.poc && v <= this.kraj && this.a == true && this.b == true) return true;
        else if (v > this.poc && v <= this.kraj && this.a == false && this.b == true) return true;
        else if (v >= this.poc && v < this.kraj && this.a == true && this.b == false) return true;
        else if (v > this.poc && v < this.kraj && this.a == false && this.b == false) return true;
        return false;
    }


    public Interval intersect(Interval interval) {
        Interval pom = new Interval();
        if (this.poc >= interval.poc && this.kraj <= interval.kraj && interval.a == true && interval.b == true) {
            pom.poc = this.poc;
            pom.kraj = this.kraj;
            if (this.a == true) pom.a = true;
            else pom.a = false;
            if (this.b == false) pom.b = false;
            else pom.b = true;
        } else if (this.poc >= interval.poc && this.kraj <= interval.kraj && interval.a == false && interval.b == true) {
            pom.poc = this.poc;
            pom.kraj = this.kraj;
            pom.a = false;
            if (this.b == false) pom.b = false;
            else pom.b = true;
        } else if (this.poc >= interval.poc && this.kraj <= interval.kraj && interval.a == false && interval.b == false) {
            pom.poc = this.poc;
            pom.kraj = this.kraj;
            pom.a = false;
            pom.b = false;
        } else if (this.poc >= interval.poc && this.kraj <= interval.kraj && interval.a == true && interval.b == false) {
            pom.poc = this.poc;
            pom.kraj = this.kraj;
            if (this.a == true) pom.a = true;
            else pom.a = false;
            pom.b = false;
        } else if (this.poc >= interval.poc && this.kraj <= interval.kraj && interval.a == true && interval.b == false) {
            pom.poc = this.poc;
            pom.kraj = this.kraj;
            if (this.a == true) pom.a = true;
            else pom.a = false;
            pom.b = false;
        }else if (interval.poc <= this.poc && interval.kraj <= this.kraj && interval.a == true && interval.b == false && this.a == true && this.b ==true){
            pom.poc = this.poc;
            pom.kraj = interval.kraj;
            pom.a = true;
            pom.b = false;
        }
        return pom;
    }

    public static Interval intersect(Interval interval1, Interval interval2) {
        Interval pom = new Interval();
        if (interval1.poc <= interval2.poc && interval1.kraj <= interval2.kraj && interval1.a == true && interval1.b == false && interval2.a == true && interval2.b ==true){
            pom.poc = interval2.poc;
            pom.kraj = interval1.kraj;
            pom.a = true;
            pom.b = false;
        }
        return  pom;
    }

    @Override
    public String toString () {
        if (this.a == true && this.b == true) {
            return "[" + this.poc + "," + this.kraj + "]";
        } else if (this.a == true && this.b == false) {
            return "[" + this.poc + "," + this.kraj + ")";
        } else if (this.a == false && this.b == true){
            return "(" + this.poc + "," + this.kraj  + "]";
        }else if (this.a == false && this.b == false){
            return "(" + this.poc + "," + this.kraj + ")";
        }
        return "0";
    }

    @Override
    public boolean equals(Object o){
        Interval interval = (Interval) o;
        if (interval.poc == this.poc && interval.kraj == this.kraj && interval.a == this.a && interval.b == this.b) return  true;
        return false;
    }


}
