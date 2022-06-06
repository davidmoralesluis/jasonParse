import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

import static java.rmi.server.LogStream.log;

public class ParseJson {
    public static void main(String[] args) throws IOException {
        //le añadimos el enlace de la pagina que queremos parsear al objecto tipo 'Document'
        Document doc = Jsoup.connect("https://weather.com/es-ES/tiempo/hoy/l/42.23,-8.71").get();
        log(doc.title());

        //Recogemos los valores que nos interesan
        Elements newsHeadlines1 = doc.select(".CurrentConditions--location--kyTeL");
        Elements newsHeadlines2 = doc.select(".CurrentConditions--tempValue--3a50n");
        Elements newsHeadlines3 = doc.select(".CurrentConditions--phraseValue--2Z18W");

        //Recorremos todos los elementos
        for (Element headline : newsHeadlines1) {
            System.out.println("Local: " + headline.html());
        }
        for (Element headline : newsHeadlines2) {
            System.out.println("Temp: " +headline.html());
        }
        for (Element headline : newsHeadlines3) {
            System.out.println("Tiempo: "+headline.html());
        }



    }
}