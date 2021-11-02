public class Book {
    private String bookName;
    private Author Author;
    private int bookPublication;

    public Book(String bookName, Author Author, int bookPublication) {
        this.bookName = bookName;
        this.Author = Author;
        this.bookPublication = bookPublication;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthor() {
        return Author.getFirstName() +" "+ Author.getLastName();
    }

    public int getBookPublication() {
        return bookPublication;
    }

    public void setBookPublication(int BookPublication) {
        this.bookPublication = BookPublication;
    }
}
