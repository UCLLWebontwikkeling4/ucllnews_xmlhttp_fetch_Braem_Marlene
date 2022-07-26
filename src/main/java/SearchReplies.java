import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SearchReplies extends RequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<NewsItemReply> newsItemReplies = getService().getNewsItemRepliesFromPersonX();
        String repliesToJSON = null;

        repliesToJSON = repliesToJSON(newsItemReplies);


        return repliesToJSON;
    }


    private String repliesToJSON(List<NewsItemReply> newsItemReply){
        ObjectMapper mapper = new ObjectMapper();
        String result = null;
        try {
            result = mapper.writeValueAsString(newsItemReply);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(result);
        return result;
    }
}
