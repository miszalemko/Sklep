package pl.sda5.warzywniak;

import org.junit.Before;
import org.junit.Test;
import pl.sda5.warzywniak.Konwersja.KonwerterProduktow;
import pl.sda5.warzywniak.dao.MagazynDao;

import java.util.List;

import static org.junit.Assert.*;

public class MagazynTest {

    private Magazyn magazyn;

    @Before
    public void setUp() throws Exception {
        MagazynDao dao = new MagazynDao("test/produkty-testowe.txt", new KonwerterProduktow());
        magazyn = new Magazyn(dao);
    }

    @Test
    public void podajProduktyDoPokazania() throws Exception {
        List<Produkt> wynik = magazyn.podayProduktyDoPokazania();
        assertTrue(wynik.size() == 2);
    }

}