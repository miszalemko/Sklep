package pl.sda5.warzywniak.dao;

import pl.sda5.warzywniak.Konwersja.KonwerterProduktow;
import pl.sda5.warzywniak.Konwersja.KonwerterZamowien;
import pl.sda5.warzywniak.Zamowienie;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;

public class ZamowienieDao {

    private String nazwaPliku;
    private KonwerterZamowien konwerter;

    public Optional<Zamowienie> szukajPoId(int id) {
        BufferedReader reader = getBufferedReader();
        try {
            String linia = reader.readLine();
            Zamowienie zamowienie = konwerter.zmienNaZamowienie(linia);
            //linia->zamowienie
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
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
}
