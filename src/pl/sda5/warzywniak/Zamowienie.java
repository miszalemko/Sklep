package pl.sda5.warzywniak;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public class Zamowienie {

    private int id;
    private long dataZlozenia;
    private long dataRealizacji;
    private BigDecimal kwotaKoncowa;
    private Map<Produkt,Integer> koszyk = new LinkedHashMap<>();

    public Zamowienie(int id, long dataZlozenia, long dataRealizacji, BigDecimal kwotaKoncowa,Map<Produkt,Integer> koszyk) {
        this.id = id;
        this.dataZlozenia = dataZlozenia;
        this.dataRealizacji = dataRealizacji;
        this.kwotaKoncowa = kwotaKoncowa;
        this.koszyk = koszyk;
    }

    public void dodajProdukt(Produkt produkt, int ilosc) {
        if(koszyk.containsKey(produkt)) {
            ilosc += koszyk.get(produkt);
        }
        koszyk.put(produkt,ilosc);
    }

    public int getid() {
        return id;
    }

    public void setId(int id) {
        id = id;
    }

    public long getDataZlozenia() {
        return dataZlozenia;
    }

    public void setDataZlozenia(long dataZlozenia) {
        this.dataZlozenia = dataZlozenia;
    }

    public long getDataRealizacji() {
        return dataRealizacji;
    }

    public void setDataRealizacji(long dataRealizacji) {
        this.dataRealizacji = dataRealizacji;
    }

    public BigDecimal getKwotaKoncowa() {
        return kwotaKoncowa;
    }

    public void setKwotaKoncowa(BigDecimal kwotaKoncowa) {
        this.kwotaKoncowa = kwotaKoncowa;
    }

    public Map<Produkt, Integer> getKoszyk() {
        return koszyk;
    }

    public void setKoszyk(Map<Produkt, Integer> koszyk) {
        this.koszyk = koszyk;
    }
}
