package pl.sda5.warzywniak;

import java.math.BigDecimal;

public class Produkt {

    private int id;
    private String nazwa;
    private BigDecimal cena;

    public Produkt(int id, String nazwa, BigDecimal cena) {
        this.id = id;
        this.nazwa = nazwa;
        this.cena = cena;
    }

    @Override
    public String toString() {
        return "Produkt{" +
                "id=" + id +
                ", nazwa='" + nazwa + '\'' +
                ", cena=" + cena +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Produkt produkt = (Produkt) o;

        if (id != produkt.id) return false;
        if (nazwa != null ? !nazwa.equals(produkt.nazwa) : produkt.nazwa != null) return false;
        return cena != null ? cena.equals(produkt.cena) : produkt.cena == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nazwa != null ? nazwa.hashCode() : 0);
        result = 31 * result + (cena != null ? cena.hashCode() : 0);
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public BigDecimal getCena() {
        return cena;
    }

    public void setCena(BigDecimal cena) {
        this.cena = cena;
    }
}
