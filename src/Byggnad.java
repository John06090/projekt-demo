/**
 * Basklass enligt UML: Byggnad
 * Innehåller kundNamn, leveransAdress, prisID och orderID.
 */
public abstract class Byggnad {

    private String kundNamn;
    private String leveransAdress;
    private int prisID;   // används som pris (kr)
    private int orderID;

    protected Byggnad(String kundNamn, String leveransAdress, int prisID, int orderID) {
        setKundNamn(kundNamn);
        setLeveransAdress(leveransAdress);
        setPrisID(prisID);
        setOrderID(orderID);
    }

    public String getKundNamn() {
        return kundNamn;
    }

    public void setKundNamn(String kundNamn) {
        if (kundNamn == null || kundNamn.isBlank())
            throw new IllegalArgumentException("KundNamn får inte vara tomt.");
        this.kundNamn = kundNamn.trim();
    }

    public String getLeveransAdress() {
        return leveransAdress;
    }

    public void setLeveransAdress(String leveransAdress) {
        if (leveransAdress == null || leveransAdress.isBlank())
            throw new IllegalArgumentException("Leveransadress får inte vara tom.");
        this.leveransAdress = leveransAdress.trim();
    }

    public int getPrisID() {
        return prisID;
    }

    public void setPrisID(int prisID) {
        if (prisID <= 0) throw new IllegalArgumentException("Pris måste vara > 0.");
        this.prisID = prisID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        if (orderID <= 0) throw new IllegalArgumentException("OrderID måste vara > 0.");
        this.orderID = orderID;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                " {orderID=" + orderID +
                ", kund='" + kundNamn + '\'' +
                ", adress='" + leveransAdress + '\'' +
                ", pris=" + prisID + " kr}";
    }
}
