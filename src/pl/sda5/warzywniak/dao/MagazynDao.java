package pl.sda5.warzywniak.dao;

import pl.sda5.warzywniak.Konwersja.KonwerterProduktow;
import pl.sda5.warzywniak.Produkt;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MagazynDao {

    private String nazwaPliku;
    private KonwerterProduktow konwerter;

    public MagazynDao(String nazwaPliku,KonwerterProduktow konwerter) throws FileNotFoundException {
        this.nazwaPliku = nazwaPliku;
        this.konwerter = konwerter;
        File file = new File(nazwaPliku);
        if(!file.exists()){
            throw new FileNotFoundException();
        }
    }

    public List<Produkt> odczytajWszystkie() {
        BufferedReader strumien = getBufferedReader();
        List<Produkt> wynik = new ArrayList<>();
        try {
            String linia = strumien.readLine();
            while(linia!= null) {
                Produkt produkt = konwerter.zamienNaProdukt(linia);
                wynik.add(produkt);
                linia = strumien.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wynik;
    }

    private BufferedReader getBufferedReader() {
        BufferedReader strumien = null;
        try {
            strumien = new BufferedReader(new FileReader(nazwaPliku));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return strumien;
    }


    public Optional<Produkt> znajdzPoId(int idProduktu) {
        BufferedReader strumien = getBufferedReader();
        try {
            String linia = strumien.readLine();
            while(linia!= null) {
            Produkt produkt = konwerter.zamienNaProdukt(linia);
            if(produkt.getId() == idProduktu) {
                return Optional.of(produkt);
            }
                linia = strumien.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
