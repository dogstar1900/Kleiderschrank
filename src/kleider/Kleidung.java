package kleider;

public abstract class Kleidung {

    private String name;
    private String farbe;


    public Kleidung(String name,String farbe){

        this.name = name;
        this.farbe = farbe;


    }

    public String getName() {
        return name;
    }

    public String getFarbe() {
        return farbe;
    }


}
