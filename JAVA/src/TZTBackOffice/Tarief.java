/*
 * Gemaakt door: Twan
 * Aangepast door: -
 * Functie: Het verkrijgen van tarief gegevens
 */
package TZTBackOffice;

public class Tarief {

    private KoeriersDienst koeriersDienst;
    private int km;
    private Double prijs;
    private Double extraPrijs;

    public Tarief(KoeriersDienst koeriersDienst, int km, Double prijs, Double extraPrijs) {
        this.koeriersDienst = koeriersDienst;
        this.km = km;
        this.prijs = prijs;
        this.extraPrijs = extraPrijs;
    }

    public KoeriersDienst getKoeriersDienst() {
        return koeriersDienst;
    }

    public int getKm() {
        return km;
    }

    public Double getPrijs() {
        return prijs;
    }

    public Double getExtraPrijs() {
        return extraPrijs;
    }

}
