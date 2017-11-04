package pl.sda5.warzywniak.dao;

import pl.sda5.warzywniak.Konwersja.KonwerterProduktow;
import pl.sda5.warzywniak.Produkt;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MagazynDao {

    private String nazwaPliku;
    private KonwerterProduktow konwerter;

    public MagazynDao(String nazwaPliku,KonwerterProduktow konwerter) {
        this.nazwaPliku = nazwaPliku;
        this.konwerter = konwerter;
    }

    public List<Produkt> odczytajWszystkie() throws FileNotFoundException {
        BufferedReader strumien = new BufferedReader(new FileReader(nazwaPliku));
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



}
