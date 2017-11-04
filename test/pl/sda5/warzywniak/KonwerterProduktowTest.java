package pl.sda5.warzywniak;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class KonwerterProduktowTest {

    private KonwerterProduktow konwerter;

    @Before
    public void setUp() {
        konwerter = new KonwerterProduktow();
    }

    @Test
    public void zamienNaProdukt() throws Exception {
        Produkt produkt = konwerter.zamienNaProdukt("1,testowy,25.00");
        assertEquals(produkt.getNazwa(), "testowy");
        assertTrue(produkt.getId() == 1);
        assertEquals(produkt.getCena(), new BigDecimal("25.00"));
    }

    @Test
    public void zamienNaLinie() throws Exception {
        Produkt produkt = new Produkt(2,"testowy2", new BigDecimal("11.11"));
        String linia = konwerter.zamienNaLinie(produkt);
        assertEquals(linia,"2,testowy2,11.11");
    }

}