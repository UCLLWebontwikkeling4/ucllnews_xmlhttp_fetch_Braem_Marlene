import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class NewsItemRepository {
    private List<NewsItem> newsItems = new ArrayList<NewsItem>();
    private String searchAuthor = "";

    public NewsItemRepository() {
        NewsItem elke = new NewsItem("Titel 1: News item Elke", "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", "Elke Steegmans", LocalDate.parse("2022-07-18"));
        NewsItem johan = new NewsItem("Titel 2: News item Johan", "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", "Johan Pieck", LocalDate.parse("2022-07-16"));
        NewsItemReply reply1 = new NewsItemReply("Eerste reply", "Persoon", LocalDate.parse("2022-07-19") );
        NewsItemReply reply2 = new NewsItemReply("Tweede reply", "Persoon", LocalDate.parse("2022-07-19") );
        NewsItemReply reply3 = new NewsItemReply("Derde reply", "Persoon", LocalDate.parse("2022-07-19") );
        NewsItemReply reply4 = new NewsItemReply("Vierde reply", "Persoon", LocalDate.parse("2022-07-19") );
        NewsItemReply reply5 = new NewsItemReply("Vijfde reply", "Persoon", LocalDate.parse("2022-07-19") );
        NewsItemReply reply6 = new NewsItemReply("Zesde reply", "Persoon", LocalDate.parse("2022-07-20") );
        elke.addReply(reply1);
        elke.addReply(reply2);
        elke.addReply(reply3);
        elke.addReply(reply4);
        elke.addReply(reply5);
        elke.addReply(reply6);
        newsItems.add(elke);
        newsItems.add(johan);
    }

    public List<NewsItem> getAll() {
        return newsItems;
    }

    public void add (NewsItem newsItem) {
        newsItems.add(newsItem);
    }

    public NewsItem getRandomLector() {
        Random random = new Random();
        int position = random.nextInt(newsItems.size());
        return newsItems.get(position);
    }

    public List<NewsItem> getNewsItems() {
        return newsItems;
    }

    public void addReply(NewsItemReply newsItemReply,NewsItem newsItem) {
        newsItem.addReply(newsItemReply);

    }

    public List<NewsItemReply> getNewsItemsReply(NewsItem newsItem) {
        return newsItem.getReplies();
    }

    public NewsItem getNewsItem(String title,String text) {
        NewsItem item = null;
        for(NewsItem newsItem: getNewsItems()){
            if (newsItem.getTitle().equals(text) && newsItem.getText().equals(title)){
                item = newsItem;
            }
        }
        return item;
    }

    // story 05 overview comments published by person x
    public List<NewsItemReply> getNewsItemRepliesFromPersonX(){
        ArrayList<NewsItemReply> repliesFromauthorX = new ArrayList<>();
        List<NewsItem> newsItems = getAll();

        for (NewsItem newsItem: newsItems){
            List<NewsItemReply> repliesNewsItem = newsItem.getReplies();

            for (NewsItemReply newsItemReply: repliesNewsItem){
                if (newsItemReply.getAuthor().toUpperCase().equals(searchAuthor.toUpperCase())){
                    repliesFromauthorX.add(newsItemReply);
                }
            }

        }
        return repliesFromauthorX;
    }

    public void searchNewsItemsRepliesFromAuthor(String author){
        searchAuthor = author;
    }
}
