package pl.sda5.warzywniak;

import java.io.FileNotFoundException;
import java.util.List;

public class Sklep {

    private Magazyn magazyn;

    public List<Produkt> pokazProdukty() throws FileNotFoundException {
        return magazyn.podayProduktyDoPokazania();
    }


}
