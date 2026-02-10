import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * beställningsRegister enligt UML:
 * + läggTill(b: Beställning) : void
 * + taBort(orderID: int) : void
 * + lista() : void
 * + visaVinst() : int
 *
 * Intern struktur (mer "kreativ" än standardlösning):
 * - ArrayList för ordning (lista)
 * - HashMap för snabb uppslagning via orderID
 */
public class BestallningsRegister {

    private final List<Bestallning> lista = new ArrayList<>();
    private final Map<Integer, Bestallning> index = new HashMap<>();

    public void laggTill(Bestallning b) {
        if (b == null) throw new IllegalArgumentException("Kan inte lägga till null.");

        int orderID = b.getOrderID();
        if (index.containsKey(orderID)) {
            throw new IllegalArgumentException("OrderID finns redan: " + orderID);
        }

        lista.add(b);
        index.put(orderID, b);
    }

    public boolean taBort(int orderID) {
        Bestallning hittad = index.remove(orderID);
        if (hittad == null) return false;

        // Tar bort samma objekt ur listan också
        lista.remove(hittad);
        return true;
    }

    public void lista() {
        if (lista.isEmpty()) {
            System.out.println("Inga beställningar registrerade.");
            return;
        }

        System.out.println("\n--- Beställningar ---");
        for (Bestallning b : lista) {
            System.out.println(b);
        }
    }

    public int visaVinst() {
        int sum = 0;
        for (Bestallning b : lista) {
            sum += b.getPris();
        }
        return sum;
    }
}
