package kleider;

public class Oberteil extends Kleidung{

    private String art;
    private String groesse;

    public Oberteil(String name,String farbe,String art,String groess){
        super(name,farbe);
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



