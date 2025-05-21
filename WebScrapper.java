
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
        String SearchedAddress = inputString("Enter address to search (Leave blank for google search): ");
        String SearchedTerm = inputString("Enter term to search: ");
        String EnterSearchDepth = inputString("Enter term to search: ");
        searchItem(SearchedTerm, "https://www.geeksforgeeks.org/", 1);
    }

    public static void searchItem(String Term, String SearchLink, int DepthTravel)
    {
        try {
            Document doc
                    = Jsoup
                    .connect(SearchLink)
                    .get();

            //Elements images = doc.select("img[src]");
            //System.out.println("Links: ");
            String PageText = doc.body().text();
            int NumberOfFinds = findOccurances(Term,PageText);
            print(SearchLink + " Found: " + NumberOfFinds);
            //System.out.println(PageText.contains(Term));

            if (DepthTravel > 0)
            {
                Elements links = doc.select("a[href]");
                int NextDepth = DepthTravel - 1;

                for (Element link : links) {
                    String LinkAddress = link.attr("href");
                    searchItem(Term,LinkAddress , NextDepth);
                }
            }

            //System.out.println("\n-----\n");
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

    public static int findOccurances(String Term, String Text)
    {
        int Finds = 0;
        int IndexFound = Text.indexOf(Term);

        while (IndexFound > 0)
        {
            Finds++;
            IndexFound = Text.indexOf(Term,IndexFound + Term.length());
        }

        return Finds;
    }

}