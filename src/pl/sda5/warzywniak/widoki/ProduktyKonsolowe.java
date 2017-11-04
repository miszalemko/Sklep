package pl.sda5.warzywniak.widoki;

import pl.sda5.warzywniak.Produkt;

import java.util.Formatter;
import java.util.List;

public class ProduktyKonsolowe {

    private List<Produkt> produkty;
    public String format = "%-40s %-25s %-10s";

    public ProduktyKonsolowe(List<Produkt> produkty) {
        this.produkty = produkty;
    }

    public void pokaz() {
        System.out.println(String.format(format,"Id","Nazwa","Cena"));
        produkty.stream().forEach(p -> System.out.println(formatuj(p)) );
    }

    public String formatuj(Produkt produkt) {
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb);
        formatter.format(format,produkt.getId(),produkt.getNazwa(),produkt.getCena());
//        sb.append(produkt.getId());
//        sb.append("");
//        sb.append(produkt.getNazwa());
//        sb.append("");
//        sb.append(produkt.getCena());
        return sb.toString();
    }
}
