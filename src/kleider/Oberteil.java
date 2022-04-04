package kleider;

public class Oberteil extends Kleidung{

    private String art;

    public Oberteil(String name,String farbe,String groesse,String art){
        super(name,farbe,groesse);
        this.art = art;
    }

    public String getArt() {
        return art;
    }
}
