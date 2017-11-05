package pl.sda5.warzywniak.Konwersja;

import org.junit.Before;
import org.junit.Test;
import pl.sda5.warzywniak.Produkt;
import pl.sda5.warzywniak.Zamowienie;

import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class KonwerterZamowienTest {

    private KonwerterZamowien konwerter;

    @Before
    public void setUp() throws Exception {
        konwerter = new KonwerterZamowien();
    }

    @Test
    public void zmienNaZamowienie() throws Exception {
    }

    @Test
    public void zmienNaLinieGdyKoszykPusty() throws Exception {
        int idZamowienia = 1;
        long dataZlozenia = 2;
        long dataRealizacji = 3;
        BigDecimal kwotaKoncowa = new BigDecimal("9.99");
        Map koszyk = new LinkedHashMap<>();
        Produkt produktA = new Produkt(1,"produktA", new BigDecimal("10.00"));
        Produkt produktB = new Produkt(2,"produktB", new BigDecimal("12.00"));
        koszyk.put(produktA,1);
        koszyk.put(produktB,2);
        Zamowienie zamowienie = new Zamowienie(idZamowienia,dataZlozenia,dataRealizacji,kwotaKoncowa,koszyk);
        String linia = konwerter.zmienNaLinie(zamowienie);
        assertEquals("1,2,3,9.99,1,1,2,2", linia);
    }
}