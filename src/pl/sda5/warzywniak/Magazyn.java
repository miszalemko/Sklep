package pl.sda5.warzywniak;

import pl.sda5.warzywniak.dao.MagazynDao;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

public class Magazyn {

    private MagazynDao dao;

    public Magazyn(MagazynDao dao) {
        this.dao = dao;
    }

    public List<Produkt> podayProduktyDoPokazania() {
        return dao.odczytajWszystkie();
    }

    public Optional<Produkt> podaj(int idProduktu) {
        return dao.znajdzPoId(idProduktu);
    }
}
