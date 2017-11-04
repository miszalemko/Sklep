package pl.sda5.warzywniak;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class MagazynDaoTest {

    private MagazynDao dao;

    @Before
    public void setUp() {
        dao = new MagazynDao("test/produkty-testowe.txt", new KonwerterProduktow());
    }

    @Test
    public void odczytajWszystkie() throws Exception {
        List<Produkt> wynik = dao.odczytajWszystkie();
        assertTrue(wynik.size() == 2);
        assertTrue(wynik.get(1).getId() == 2);
        assertEquals(wynik.get(1).getNazwa(), "produktB");
        assertEquals(wynik.get(1).getCena(), new BigDecimal("20"));
    }

}