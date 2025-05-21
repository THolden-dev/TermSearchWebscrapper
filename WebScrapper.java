
import java.io.IOException;
import java.util.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

class WebScrapper
{
    public static void main(String[] args)
    {
        String SearchedTerm = inputString("Enter: ");
        searchItem(SearchedTerm);
    }

    public static void searchItem(String Term)
    {
        try {
            Document doc
                    = Jsoup
                    .connect("https://google.com")
                    .get();
            Elements links = doc.select("a[href]");
            //Elements images = doc.select("img[src]");
            //System.out.println("Links: ");
            String PageText = doc.body().text();
            System.out.println(PageText.contains(Term));


            for (Element link : links) {
                System.out.println(link.attr("href"));
            }
            System.out.println("\n-----\n");
            /*System.out.println("Images:");
            for (Element image : images) {
                System.out.println(image.attr("src"));
            }*/
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String inputString(String Mes)
    {
        print(Mes);
        Scanner keyboard = new Scanner(System.in);
        return keyboard.nextLine();
    }

    public static void print(String Mes)
    {
        System.out.println(Mes);
    }

    public static void findOccurances(String Term, String Text)
    {
        int Counter = 0;
        int IndexFound = Text.indexOf(Term);

        while (IndexFound > 0)
        {
            
        }
    }

}