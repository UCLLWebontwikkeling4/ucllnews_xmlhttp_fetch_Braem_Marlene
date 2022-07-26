import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class RequestHandler {
    protected NewsItemRepository newsItemRepository;

    public abstract String handleRequest (HttpServletRequest request, HttpServletResponse response) throws IOException;

    public NewsItemRepository getService() {
        return newsItemRepository;
    }

    public void setService(NewsItemRepository service) {
        this.newsItemRepository = service;
    }
}
