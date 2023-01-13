public class Main {
    public static void main(String[] args) {
        Verwaltung v = new Verwaltung();
        //Hotelzimmer hinzufügen
        v.addHotelzimmer(1, 99.2, Art.DOPPELZIMMER);
        v.addHotelzimmer(2, 124.34, Art.EINZELZIMMER);
        v.addKunde(1, "Max", "Bauer", 312.36);
        v.addKunde(2, "Michael", "Meyer", 926.12);

        v.hotelzimmerReservieren(v.getKunde(1), v.getHotelzimmer(2));
        v.hotelzimmerStornieren(v.getHotelzimmer(2));
        v.hotelzimmerBuchen(v.getKunde(1), v.getHotelzimmer(2));
        v.preisFuerKundeBerechnen(1);

    }
}