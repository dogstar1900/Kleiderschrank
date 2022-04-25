package kleider;

public class Schuhe extends Kleidung {

    private String art;
    private String groesse;

    public Schuhe(String name, String farbe,String art, String groesse) {
        super(name, farbe);
        this.art = art;
        this.groesse = groesse;
    }

    public String getArt() {
        return art;
    }


    public String getGroesse() {
        return groesse;
    }
}