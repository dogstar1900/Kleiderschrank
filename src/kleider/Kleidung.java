package kleider;

public abstract class Kleidung {

    private String name;
    private String farbe;
    private String groesse;

    public Kleidung(String name,String farbe,String groesse){

        this.name = name;
        this.farbe = farbe;
        this.groesse = groesse;

    }

    public String getName() {
        return name;
    }

    public String getFarbe() {
        return farbe;
    }

    public String getGroesse() {
        return groesse;
    }
}
