package kleider;

public class Hose extends Kleidung{

    private String art;

    public Hose(String name,String farbe,String groesse, String art){
        super(name,farbe,groesse);
        this.art = art;
    }

    public String getArt() {
        return art;
    }
}
