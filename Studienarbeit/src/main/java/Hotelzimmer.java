public class Hotelzimmer {

    private int id;
    private double price;
    private Status status;
    private Art art;

    public Hotelzimmer(int id, double price, Art art) {
        this.status = Status.FREI;
        this.id = id;
        this.price = price;
        this.art = art;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
