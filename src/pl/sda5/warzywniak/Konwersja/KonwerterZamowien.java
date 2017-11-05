package pl.sda5.warzywniak.Konwersja;

import pl.sda5.warzywniak.Produkt;
import pl.sda5.warzywniak.Zamowienie;

import java.util.Map;

public class KonwerterZamowien {

    public Zamowienie zmienNaZamowienie(String linia) {
        //id,data zlozenia,data realizacji,kwotaKoncowa,koszyk
        return null;
    }

    public String  zmienNaLinie(Zamowienie zamowienie) {
        StringBuilder sb = new StringBuilder();
        sb.append(zamowienie.getid());
        sb.append(",");
        sb.append(zamowienie.getDataZlozenia());
        sb.append(",");
        sb.append(zamowienie.getDataRealizacji());
        sb.append(",");
        sb.append(zamowienie.getKwotaKoncowa());

        for(Map.Entry<Produkt,Integer> aktualnyElementMapy : zamowienie.getKoszyk().entrySet()) {
            sb.append(",");
            sb.append(aktualnyElementMapy.getKey().getId());
            sb.append(",");
            sb.append(aktualnyElementMapy.getValue());
        }

        return sb.toString();
    }
}
