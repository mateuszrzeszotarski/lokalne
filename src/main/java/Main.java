import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Pobierz pobierz = new Pobierz("https://www.morele.net/kategoria/myszy-komputerowe-464/");
        ArrayList<String> nazwa = new ArrayList<>();
        ArrayList<String> cena = new ArrayList<>();

        for(int i = 0;i<30; i++) {
            nazwa.add(pobierz.zawartosc(".cat-product-name", i));
            cena.add(pobierz.zawartosc(".price-new", i));
        }

        File file = new File("myszki.txt");
        try{
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), "UTF-8"));
            for(int i = 0; i < nazwa.size(); i++){
                writer.append(nazwa.get(i)+"\n");
                writer.append(cena.get(i)+"\n");
                writer.append("__________________________________\n");
            }
            writer.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}

