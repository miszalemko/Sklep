package pl.sda5.warzywniak;

import java.math.BigDecimal;

public class KonwerterProduktow {

    public Produkt zamienNaProdukt(String linia) {
        String[] tablica = linia.split(",");
        return new Produkt(Integer.valueOf(tablica[0]),tablica[1], new BigDecimal(tablica[2]));
    }

    public String zamienNaLinie(Produkt produkt) {
        StringBuilder sb = new StringBuilder();
        sb.append(produkt.getId());
        sb.append(",");
        sb.append(produkt.getNazwa());
        sb.append(",");
        sb.append(produkt.getCena());
        return sb.toString();
    }
}
