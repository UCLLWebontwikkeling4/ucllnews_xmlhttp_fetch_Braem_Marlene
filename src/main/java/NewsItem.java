import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NewsItem {
    private String title;
    private String text;
    private String author;
    private LocalDate date;
    private List<NewsItemReply> newsItemsReplies;


    public NewsItem() {
    }
    public NewsItem(String title, String text, String author, LocalDate date) {
        this.title = title;
        this.text = text;
        this.author = author;
        this.date = date;
        this.newsItemsReplies  = new ArrayList<NewsItemReply>();

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }


    public void addReply(NewsItemReply newsItemReply) {
        this.newsItemsReplies.add(newsItemReply);
    }

    public List<NewsItemReply> getReplies() {
        return this.newsItemsReplies;
    }

    public String dateToString(Date date){
        return  date.toString();
    }

}
