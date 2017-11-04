package pl.sda5.warzywniak;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SklepTest {

    private Sklep sklep;
    @Before
    public void setUp() {
        MagazynDao magazynDao = new MagazynDao("test/produkty-testowe.txt", new KonwerterProduktow());
        Magazyn magazyn = new Magazyn(magazynDao);
        sklep = new Sklep(magazyn);
    }

    @Test
    public void pokazProdukty() throws Exception {
        List<Produkt> wynik = sklep.pokazProdukty();
        assertTrue(wynik.size() == 2);
    }

}