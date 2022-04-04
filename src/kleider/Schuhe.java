package kleider;

public class Schuhe extends Kleidung{

    private String art;

    public Schuhe(String name,String farbe,String groesse){
        super(name,farbe,groesse);
        this.art = art;
    }

    public String getArt() {
        return art;
    }
}
