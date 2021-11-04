public class Library {
    private final Book[] bookArray;

    public Library(int sizeArray) {
        this.bookArray = new Book[sizeArray];
    }

    public void addNewBook(Book book) {
        // найти первую пустую ячейку
        int freePosition = findItem(bookArray);
        if (freePosition == -1) {
            throw new RuntimeException("Для новых книг не осталось места");
        }
        // Добавить книгу
        bookArray[freePosition] = book;
    }

    public int findItem(Book[] array) {
        // найти первую пустую ячейку
        int numItem = -1;  // если массив заполнен - вернет неверное значение
        if (array[0] == null) {
            return 0;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                numItem = i;
                break;
            }
        }
        return numItem;
    }

    public void printBookDetail(String bookName) {
        // 4.a Напечатать информацию о книге по ее названию, которое приходит в метод в качестве параметра.
        //  4.a.1 найти книгу в библиотеке
        Book book = findBook(bookName);
        //  4.a.2 Напечатать
        printMyBook(book);
    }

    public void changeBookYear(String nameBook, int year) {
        // 5.a Изменить год публикации книги по ее названию.
        //  4.a.1 найти книгу в библиотеке
        Book book = findBook(nameBook);
        //  5.a.2 Изменить год
        changeYear(book, year);
    }

    private Book findBook(String name) {
        for (int i = 0; i < bookArray.length; i++) {
            if (bookArray[i].getBookName().equals(name)) {
                return bookArray[i];
            }
        }
        return null;
    }

    private void printMyBook(Book card) {
        System.out.print(card.getBookName() + " by ");
        System.out.print(card.getAuthor().getAuthorName() + " was published in ");
        System.out.println(card.getPublicationYear());
    }

    private void changeYear(Book book, int year) {
        book.setPublicationYear(year);
    }
}
