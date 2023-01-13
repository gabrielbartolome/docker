import java.lang.reflect.Array;
import java.sql.PreparedStatement;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;

public class Verwaltung {

    ArrayList<Hotelzimmer> hotelzimmerListe;
    ArrayList<Kunde> kundenListe;
    HotelzimmerBuchung hotelzimmerBuchung = new HotelzimmerBuchung();

    public Verwaltung() {
        this.hotelzimmerListe = new ArrayList<Hotelzimmer>();
        this.kundenListe = new ArrayList<Kunde>();
    }

    public void addHotelzimmer(int id, double price, Art art){
        Hotelzimmer hotelzimmer = new Hotelzimmer(id, price, art);
        hotelzimmerListe.add(hotelzimmer);
        hotelzimmerBuchung.getBezKundeHotelzimmer().put(id, -1);
    }

    public void addKunde(int id, String vorname, String nachname, double guthaben){
        Kunde k = new Kunde(id, vorname, nachname, guthaben);
        kundenListe.add(k);
    }

    public void hotelzimmerReservieren(Kunde k, Hotelzimmer h){
        if(h.getStatus() == Status.FREI) {
            h.setStatus(Status.RESERVIERT);
            hotelzimmerBuchung.getBezKundeHotelzimmer().put(h.getId(), k.getID());
        }
    }

    public void hotelzimmerStornieren(Hotelzimmer h){
        if(h.getStatus() == Status.RESERVIERT || h.getStatus() == Status.GEBUCHT) {
            Kunde k = getKunde(hotelzimmerBuchung.getBezKundeHotelzimmer().get(h.getId()));
            k.setGuthaben(k.getGuthaben() + h.getPrice());
            h.setStatus(Status.FREI);
            hotelzimmerBuchung.getBezKundeHotelzimmer().put(h.getId(), -1);
        }
    }

    public void hotelzimmerSperren(Hotelzimmer h){
        if(h.getStatus() == Status.GEBUCHT) {
            Kunde k = getKunde(hotelzimmerBuchung.getBezKundeHotelzimmer().get(h.getId()));
            k.setGuthaben(k.getGuthaben() + h.getPrice());
        }
        h.setStatus(Status.GESPERRT);
        hotelzimmerBuchung.getBezKundeHotelzimmer().put(h.getId(), -1);
    }

    public void hotelzimmerBuchen(Kunde k, Hotelzimmer h){
        if(h.getStatus() == Status.FREI){
            k.setGuthaben(k.getGuthaben() - h.getPrice());
            h.setStatus(Status.GEBUCHT);
            hotelzimmerBuchung.getBezKundeHotelzimmer().put(h.getId(), k.getID());
        }
        else if(h.getStatus() == Status.RESERVIERT){
            if(hotelzimmerBuchung.getBezKundeHotelzimmer().get(h.getId()) == k.getID()){
                k.setGuthaben(k.getGuthaben() - h.getPrice());
                h.setStatus(Status.GEBUCHT);
                hotelzimmerBuchung.getBezKundeHotelzimmer().put(h.getId(), k.getID());
            }
        }
    }

    public double preisFuerKundeBerechnen(int kundeID){
        double betrag = 0;
        for(int i = 0; i < hotelzimmerListe.size(); i++){
            Hotelzimmer h = hotelzimmerListe.get(i);
            if(hotelzimmerBuchung.getBezKundeHotelzimmer().get(h.getId()) == kundeID){
                betrag+=h.getPrice();
            }
        }
        NumberFormat n = NumberFormat.getInstance();
        n.setMaximumFractionDigits(2); // max. 2 stellen hinter komma
        System.out.println(n.format(betrag));
        return betrag;
    }

    public Hotelzimmer getHotelzimmer(int hotezimmerID){
        for(int i = 0; i < hotelzimmerListe.size(); i++){
            if(hotelzimmerListe.get(i).getId() == hotezimmerID) {
                return hotelzimmerListe.get(i);
            }
        }
        return null;
    }

    public Kunde getKunde(int kundeID){
        for(int i = 0; i < kundenListe.size(); i++){
            if(kundenListe.get(i).getID() == kundeID) {
                return kundenListe.get(i);
            }
        }
        return null;
    }

}
