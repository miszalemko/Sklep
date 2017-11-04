package pl.sda5.warzywniak;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public class Zamowienie {

    private int Id;
    private long dataZlozenia;
    private long dataRealizacji;
    private BigDecimal kwotaKoncowa;
    private Map<Produkt,Integer> koszyk = new LinkedHashMap<>();

}
