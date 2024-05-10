package library;

 public class Book {
    private String title;
    private  String theme;
    private Author author;
    private int year;
    private boolean isBorrowed;
    private String publisher;
   //private Long id;

    public Book(String title, Author author, String theme, int year, boolean isBorrowed,String publisher) {
       this.title = title;
       this.author = author;
       this.theme = theme;
       this.year = year;
       this.isBorrowed = isBorrowed;
       this.publisher = publisher;
    }

    @Override
    public String toString() {
       return "Book{" +
               "title='" + title + '\'' +
               ", theme='" + theme + '\'' +
               ", author=" + author +
               ", year=" + year +
               ", isBorrowed=" + isBorrowed +
               '}';
    }

    public String getTitle() {
       return title;
    }

    public void setTitle(String title) {
       this.title = title;
    }

    public String getTheme() {
       return theme;
    }

    public void setTheme(String theme) {
       this.theme = theme;
    }

    public Author getAuthor() {
       return author;
    }

    public void setAuthor(Author author) {
       this.author = author;
    }

    public int getYear() {
       return year;
    }

    public void setYear(int year) {
       this.year = year;
    }

    public boolean isBorrowed() {
       return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
       isBorrowed = borrowed;
    }
 }
