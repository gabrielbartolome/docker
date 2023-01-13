public class Kunde {

    private int ID;
    private String vorname, nachname;
    private double guthaben;

    public Kunde(int ID, String vorname, String nachname, double guthaben) {
        this.ID = ID;
        this.vorname = vorname;
        this.nachname = nachname;
        this.guthaben = guthaben;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public double getGuthaben() {
        return guthaben;
    }

    public void setGuthaben(double guthaben) {
        this.guthaben = guthaben;
    }
}
