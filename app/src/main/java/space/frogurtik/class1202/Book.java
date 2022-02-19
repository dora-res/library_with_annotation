package space.frogurtik.class1202;

public class Book {
    String title, author;
    int year, coveredID;

    public Book(String title, String author, int year, int coveredID) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.coveredID = coveredID;
    }

    @Override
    public String toString() {
        return title + " "+ author;
    }
}
