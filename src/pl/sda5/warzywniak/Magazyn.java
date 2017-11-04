package pl.sda5.warzywniak;

import java.io.FileNotFoundException;
import java.util.List;

public class Magazyn {

    private MagazynDao dao;

    public List<Produkt> podayProduktyDoPokazania() throws FileNotFoundException {
        return dao.odczytajWszystkie();
    }
}
