import java.util.Scanner;

/**
 * Program: Beställningssystem för byggnader
 * Beskrivning: Konsolprogram som låter användaren registrera beställningar
 * av Villa, Radhus och Garage. Beställningar sparas i ett register där man
 * kan lista, ta bort och räkna total vinst.
 *
 * @author Ditt Namn
 * @version 1.0
 * @since 2026-01-01
 */
public class Main {

    private static final Scanner IN = new Scanner(System.in);

    public static void main(String[] args) {
        BestallningsRegister register = new BestallningsRegister();

        while (true) {
            skrivMeny();
            int val = lasInt("Välj: ");

            switch (val) {
                case 1 -> skapaOchLaggTill(register);
                case 2 -> taBort(register);
                case 3 -> register.lista();
                case 4 -> System.out.println("Total vinst: " + register.visaVinst() + " kr");
                case 5 -> {
                    System.out.println("Hejdå!");
                    return;
                }
                default -> System.out.println("Ogiltigt val.");
            }
        }
    }

    private static void skrivMeny() {
        System.out.println("\n--- MENY ---");
        System.out.println("1) Lägg till beställning");
        System.out.println("2) Ta bort beställning (orderID)");
        System.out.println("3) Lista beställningar");
        System.out.println("4) Visa vinst");
        System.out.println("5) Avsluta");
    }

    private static void skapaOchLaggTill(BestallningsRegister register) {
        System.out.println("\nVälj byggnadstyp:");
        System.out.println("1) Villa");
        System.out.println("2) Radhus");
        System.out.println("3) Garage");

        int typ = lasInt("Typ: ");

        // Gemensamma fält (från UML: Byggnad)
        String kundNamn = lasString("Kundnamn: ");
        String leveransAdress = lasString("Leveransadress: ");
        int orderID = lasInt("OrderID (heltal > 0): ");
        int prisID = lasInt("Pris (kr, heltal > 0): ");

        Byggnad byggnad;
        try {
            byggnad = switch (typ) {
                case 1 -> skapaVilla(kundNamn, leveransAdress, prisID, orderID);
                case 2 -> skapaRadhus(kundNamn, leveransAdress, prisID, orderID);
                case 3 -> skapaGarage(kundNamn, leveransAdress, prisID, orderID);
                default -> null;
            };

            if (byggnad == null) {
                System.out.println("Ogiltig typ.");
                return;
            }

            String datum = lasString("Beställningsdatum (t.ex 2026-01-01): ");
            String kommentar = lasStringValfri("Kommentar (valfritt, ENTER för tom): ");

            Bestallning b = new Bestallning(datum, kommentar, byggnad);

            register.laggTill(b);
            System.out.println("✅ Beställning tillagd!");

        } catch (IllegalArgumentException e) {
            System.out.println("Fel: " + e.getMessage());
        }
    }

    private static void taBort(BestallningsRegister register) {
        int orderID = lasInt("OrderID att ta bort: ");
        boolean ok = register.taBort(orderID);
        System.out.println(ok ? "✅ Borttagen." : "Hittade ingen beställning med orderID: " + orderID);
    }

    private static Villa skapaVilla(String kundNamn, String adress, int prisID, int orderID) {
        int antalRum = lasInt("Antal rum: ");
        int antalSovrum = lasInt("Antal sovrum: ");
        int boytaKvm = lasInt("Boyta (kvm): ");
        int antalBadrum = lasInt("Antal badrum: ");
        int tomtKvm = lasInt("Tomt (kvm): ");

        return new Villa(kundNamn, adress, prisID, orderID,
                antalRum, antalSovrum, boytaKvm, antalBadrum, tomtKvm);
    }

    private static Radhus skapaRadhus(String kundNamn, String adress, int prisID, int orderID) {
        int antalRum = lasInt("Antal rum: ");
        int antalSovrum = lasInt("Antal sovrum: ");
        int boytaKvm = lasInt("Boyta (kvm): ");
        int antalBadrum = lasInt("Antal badrum: ");
        int tomtKvm = lasInt("Tomt (kvm): ");

        return new Radhus(kundNamn, adress, prisID, orderID,
                antalRum, antalSovrum, boytaKvm, antalBadrum, tomtKvm);
    }

    private static Garage skapaGarage(String kundNamn, String adress, int prisID, int orderID) {
        int bilAreaKvm = lasInt("Bilarea (kvm): ");
        int forradsAreaKvm = lasInt("Förrådsarea (kvm): ");

        return new Garage(kundNamn, adress, prisID, orderID, bilAreaKvm, forradsAreaKvm);
    }

    // ---------- Input-hjälp (robusthet) ----------

    private static int lasInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = IN.nextLine().trim();
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.println("Skriv ett giltigt heltal.");
            }
        }
    }

    private static String lasString(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = IN.nextLine().trim();
            if (!s.isBlank()) return s;
            System.out.println("Fältet får inte vara tomt.");
        }
    }

    private static String lasStringValfri(String prompt) {
        System.out.print(prompt);
        return IN.nextLine().trim(); // får vara tom
    }
}
