/**
 * Radhus ärver Byggnad och har samma typ av fält som Villa enligt UML.
 */
public class Radhus extends Byggnad {

    private int antalRum;
    private int antalSovrum;
    private int boytaKvm;
    private int antalBadrum;
    private int tomtKvm;

    public Radhus(String kundNamn, String leveransAdress, int prisID, int orderID,
                  int antalRum, int antalSovrum, int boytaKvm, int antalBadrum, int tomtKvm) {
        super(kundNamn, leveransAdress, prisID, orderID);
        setAntalRum(antalRum);
        setAntalSovrum(antalSovrum);
        setBoytaKvm(boytaKvm);
        setAntalBadrum(antalBadrum);
        setTomtKvm(tomtKvm);
    }

    public int getAntalRum() { return antalRum; }
    public void setAntalRum(int antalRum) {
        if (antalRum <= 0) throw new IllegalArgumentException("Radhus: antalRum måste vara > 0.");
        this.antalRum = antalRum;
    }

    public int getAntalSovrum() { return antalSovrum; }
    public void setAntalSovrum(int antalSovrum) {
        if (antalSovrum < 0) throw new IllegalArgumentException("Radhus: antalSovrum får inte vara negativt.");
        this.antalSovrum = antalSovrum;
    }

    public int getBoytaKvm() { return boytaKvm; }
    public void setBoytaKvm(int boytaKvm) {
        if (boytaKvm <= 0) throw new IllegalArgumentException("Radhus: boytaKvm måste vara > 0.");
        this.boytaKvm = boytaKvm;
    }

    public int getAntalBadrum() { return antalBadrum; }
    public void setAntalBadrum(int antalBadrum) {
        if (antalBadrum <= 0) throw new IllegalArgumentException("Radhus: antalBadrum måste vara > 0.");
        this.antalBadrum = antalBadrum;
    }

    public int getTomtKvm() { return tomtKvm; }
    public void setTomtKvm(int tomtKvm) {
        if (tomtKvm < 0) throw new IllegalArgumentException("Radhus: tomtKvm får inte vara negativt.");
        this.tomtKvm = tomtKvm;
    }

    @Override
    public String toString() {
        return super.toString().replace("}", "") +
                ", rum=" + antalRum +
                ", sovrum=" + antalSovrum +
                ", boyta=" + boytaKvm + " kvm" +
                ", badrum=" + antalBadrum +
                ", tomt=" + tomtKvm + " kvm" +
                "}";
    }
}
