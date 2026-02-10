import java.time.LocalDate;

/**
 * Beställning enligt UML:
 * + beställningsDatum: string
 * + kommentar: string
 *
 * I koden kopplas även beställningen till en Byggnad (så den går att registrera i ett register).
 */
public class Bestallning {

    private final String bestallningsDatum;
    private final String kommentar;
    private final Byggnad byggnad;

    public Bestallning(String bestallningsDatum, String kommentar, Byggnad byggnad) {
        if (byggnad == null) throw new IllegalArgumentException("Beställning måste ha en byggnad.");

        // Datum är String i UML, men vi gör en enkel check:
        if (bestallningsDatum == null || bestallningsDatum.isBlank())
            throw new IllegalArgumentException("Beställningsdatum får inte vara tomt.");

        // Försök tolka YYYY-MM-DD (om det misslyckas låter vi det ändå gå igenom,
        // men många skriver rätt format och då får man lite extra robusthet).
        try {
            LocalDate.parse(bestallningsDatum.trim());
        } catch (Exception ignored) { }

        this.bestallningsDatum = bestallningsDatum.trim();
        this.kommentar = (kommentar == null) ? "" : kommentar.trim();
        this.byggnad = byggnad;
    }

    public String getBestallningsDatum() {
        return bestallningsDatum;
    }

    public String getKommentar() {
        return kommentar;
    }

    public Byggnad getByggnad() {
        return byggnad;
    }

    public int getOrderID() {
        return byggnad.getOrderID();
    }

    public int getPris() {
        return byggnad.getPrisID();
    }

    @Override
    public String toString() {
        return "Bestallning{datum='" + bestallningsDatum + "', orderID=" + getOrderID() +
                ", pris=" + getPris() + " kr, byggnad=" + byggnad +
                (kommentar.isBlank() ? "" : ", kommentar='" + kommentar + "'") +
                "}";
    }
}
