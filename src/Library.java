public class Library {
    private Book[] bookArray;

    public Library(int  sizeArray ) {
        this.bookArray = new Book[sizeArray];
    }
    public   void addBook(String bookName, String authorName1, String authorName2, int year) {
        // найти первую пустую ячейку
        int freePosition = findItem(bookArray);
        if (freePosition > bookArray.length) {
            throw new RuntimeException("Для новых книг не осталось места");
        }
        // Добавить книгу
        Author nameAuthor = new Author(authorName1, authorName2);
        Book newBook = new Book(bookName, nameAuthor, year);
        bookArray[freePosition] = newBook;
    }

    public int findItem(Book[] array) {
        // найти первую пустую ячейку
        int numItem = array.length + 1;  // если массив заполнен - вернет неверное значение
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                numItem = i;
                break;
            }
        }
        return numItem;
    }

    public void printBookDetail(String nameBook) {
        // 4.a Напечатать информацию о книге по ее названию, которое приходит в метод в качестве параметра.
        //  4.a.1 найти книгу в библиотеке
        Book trueBook = findBook(nameBook);
        //  4.a.2 Напечатать
        printMyBook(trueBook);
    }
    public void changeBookYear(String nameBook, int year) {
        // 5.a Изменить год публикации книги по ее названию.
        //  4.a.1 найти книгу в библиотеке
        Book trueBook = findBook(nameBook);
        //  5.a.2 Изменить год
        changeYear(trueBook,  year);
    }
    private Book findBook(String name){
        for (int i = 0; i < bookArray.length; i++) {
            if (bookArray[i].getBookName().equals(name)) {
                return bookArray[i];
            }
        }
        return null;
    }
    private  void  printMyBook(Book card) {
            System.out.print(card.getBookName() + " by ");
            System.out.print(card.getAuthor() + " was published in ");
            System.out.print(card.getBookPublication());
            System.out.print("\n");
    }
    private  void  changeYear(Book Book,  int year) {
         Book.setBookPublication(year);
    }
}
