import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class Random extends RequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("in ");
        List<NewsItem> newsItems = getService().getNewsItems();
        StringBuilder newsItemsAsJson = new StringBuilder();
        newsItemsAsJson.append("[");

        for (NewsItem newsItem:newsItems) {
            newsItemsAsJson.append(newsItemToJson(newsItem)).append(",");
        }

        newsItemsAsJson.deleteCharAt(newsItemsAsJson.length() - 1);
        newsItemsAsJson.append("]");

        return newsItemsAsJson.toString();
    }


    private String newsItemToJson(NewsItem newsItem){
        ObjectMapper mapper = new ObjectMapper();
        String result = null;
        try {
            result = mapper.writeValueAsString(newsItem);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(result);
        return result;
    }
}
