package pl.sda5.warzywniak;

import pl.sda5.warzywniak.Konwersja.KonwerterProduktow;
import pl.sda5.warzywniak.dao.MagazynDao;
import pl.sda5.warzywniak.widoki.ProduktyKonsolowe;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

public class Runner {
    public static void main(String[] args) {

        if(args.length == 0) {
            System.out.println("Podaj poprawne parametry");
            System.exit(1);
        }
        MagazynDao magazynDao = null;
        try {
            magazynDao = new MagazynDao("./dane/magazyn.csv", new KonwerterProduktow());
        }
        catch(FileNotFoundException f) {
            System.out.println("Nie znaleziono pliku ,=magazynu");
            System.exit(1);
        }
        Magazyn magazyn = new Magazyn(magazynDao);
        Sklep sklep = new Sklep(magazyn);

        if(args[0].equals("pokazprodukty")) {
            try {
                List<Produkt> produkty = sklep.pokazProdukty();
                ProduktyKonsolowe widok = new ProduktyKonsolowe(produkty);
                widok.pokaz();
            } catch (FileNotFoundException e) {
                System.out.println("Nie znaleziono pliku \"magazyn.csv\"");
            }
        }

        if (args[0].equals("kup")) {
            //walidacja czy parametry są poprawne

            System.out.println("Kupujemy!");
            int idProduktu = Integer.valueOf(args[1]);
            int ilosc = Integer.valueOf(args[2]);
            int idZamowienia = -1;
            if (args.length == 4) {
                idZamowienia = Integer.valueOf(args[3]);
                Zamowienie zamowienie = null;
            }
            else {
                Zamowienie zamowienie = null;
            }
            System.out.println(idZamowienia);
            Optional<Produkt> produktOptional = magazyn.podaj(idProduktu);
            if(!produktOptional.isPresent()) {
                System.out.println("Nie znaleziono produktu");
                System.exit(1);
            }
            sklep.kup(produktOptional.get(),ilosc);
        }
    }
}
