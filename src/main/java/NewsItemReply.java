import java.time.LocalDate;
import java.util.Date;

public class NewsItemReply {

    private String text;
    private String author;
    private LocalDate date;

    public NewsItemReply() {
    }

    public NewsItemReply(String text, String author, LocalDate date) {
        this.text = text;
        this.author = author;
        this.date = date;
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
}
