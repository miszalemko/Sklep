package pl.sda5.warzywniak;

import java.io.FileNotFoundException;
import java.util.List;

public class Sklep {

    private Magazyn magazyn;

    public Sklep(Magazyn magazyn) {
        this.magazyn = magazyn;
    }

    public List<Produkt> pokazProdukty() throws FileNotFoundException {
        return magazyn.podayProduktyDoPokazania();
    }


    public int kup(Produkt produkt, int ilosc) {
        //zamowienie
        //czy jest zamowienie czy stworzenie nowego
        return 0;
    }
}
