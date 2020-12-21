import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.IOException;

public class Pobierz{
    private Document doct = null;

    public Pobierz(String url){
        try{
            this.doct = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Element strona(){
        return this.doct.getAllElements().first();
    }
    public String zawartosc(String cQ, int i){
        return strona().select(cQ).get(i).text();
    }
    @Override
    public String toString() {
        return "Pobierz{" +
                "doct=" + doct +
                '}';
    }
}
