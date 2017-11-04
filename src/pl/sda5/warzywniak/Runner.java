package pl.sda5.warzywniak;

import java.io.FileNotFoundException;
import java.util.List;

public class Runner {
    public static void main(String[] args) {

        if(args.length == 0) {
            System.out.println("Podaj poprawne parametry");
            System.exit(1);
        }
        MagazynDao magazynDao = new MagazynDao("./dane/magazyn.csv", new KonwerterProduktow());
        Magazyn magazyn = new Magazyn(magazynDao);
        Sklep sklep = new Sklep(magazyn);

        if(args[0].equals("pokazprodukty")) {
            try {
                List<Produkt> produkty = sklep.pokazProdukty();
            } catch (FileNotFoundException e) {
                System.out.println("Nie znaleziono pliku \"magazyn.csv\"");
            }
        }
    }
}
