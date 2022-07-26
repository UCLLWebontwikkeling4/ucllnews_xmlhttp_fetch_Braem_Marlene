import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;

public class Add extends RequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("In add");
        String title = request.getParameter("title_input");
        String text = request.getParameter("text_input");
        String author = request.getParameter("author_input");
        LocalDate date = LocalDate.now();


        //if(title == null) return "overview.jsp"; //anders voeg je news artikelen toe met enkel de datum dit kan wel nog beter gemaakt worden maar was nog niet deel van de opdracht dus heb het nog niet uitgewerkt

        System.out.println(title);

        NewsItem newsItem = new NewsItem(title, text, author, date);
        getService().add(newsItem);
        return "OK";
    }

}
