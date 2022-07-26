import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class Overview extends RequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        List<NewsItem> newsItems = newsItemRepository.getAll();
        request.setAttribute("newsItems", newsItems);
        return "overview.jsp";
    }

}
