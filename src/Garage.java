/**
 * Garage ärver Byggnad och har bilAreaKvm + forradsAreaKvm enligt UML.
 */
public class Garage extends Byggnad {

    private int bilAreaKvm;
    private int forradsAreaKvm;

    public Garage(String kundNamn, String leveransAdress, int prisID, int orderID,
                  int bilAreaKvm, int forradsAreaKvm) {
        super(kundNamn, leveransAdress, prisID, orderID);
        setBilAreaKvm(bilAreaKvm);
        setForradsAreaKvm(forradsAreaKvm);
    }

    public int getBilAreaKvm() { return bilAreaKvm; }
    public void setBilAreaKvm(int bilAreaKvm) {
        if (bilAreaKvm <= 0) throw new IllegalArgumentException("Garage: bilAreaKvm måste vara > 0.");
        this.bilAreaKvm = bilAreaKvm;
    }

    public int getForradsAreaKvm() { return forradsAreaKvm; }
    public void setForradsAreaKvm(int forradsAreaKvm) {
        if (forradsAreaKvm < 0) throw new IllegalArgumentException("Garage: forradsAreaKvm får inte vara negativt.");
        this.forradsAreaKvm = forradsAreaKvm;
    }

    @Override
    public String toString() {
        return super.toString().replace("}", "") +
                ", bilArea=" + bilAreaKvm + " kvm" +
                ", forrad=" + forradsAreaKvm + " kvm" +
                "}";
    }
}
