import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

public class AddReply extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String textReply = request.getParameter("text");
        String authorReply = request.getParameter("author");

        String textNewsItem = request.getParameter("textNewsItem");
        String titleNewsItem = request.getParameter("titleNewsItem");

        if(textReply == null) return "index.jsp";
        LocalDate date = LocalDate.now();


        NewsItemReply newsItemReply = new NewsItemReply(textReply, authorReply, date);
        NewsItem newsItem = getService().getNewsItem(textNewsItem,titleNewsItem);

        getService().addReply(newsItemReply,newsItem);
        return "OK";
    }
}
