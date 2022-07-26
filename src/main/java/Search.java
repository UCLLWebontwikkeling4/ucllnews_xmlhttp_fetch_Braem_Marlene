import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Search extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String author = request.getParameter("authorSearch");
        getService().searchNewsItemsRepliesFromAuthor(author);
        return "OK";
    }
}
