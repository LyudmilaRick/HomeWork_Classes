public class Main {

    public static void main(String[] args) {
        // создать несколько объектов Книга (достаточно двух)
        // и несколько объектов Автор (достаточно тоже двух) и инициализировать друг друга
        Author nameAuthor1 = new Author("Стив", "Макконнел");
        Author nameAuthor2 = new Author("Брюс", "Шнайдер");
        Book firstBook = new Book("Совершенный код", nameAuthor1, 2019);
        Book secondBook = new Book("Прикладная криптография", nameAuthor2, 2002);
        secondBook.setBookPublication(2003);
        // первый уровень сложности
        System.out.println("Первый уровень сложности");
        System.out.println(firstBook.getBookName() + " " + nameAuthor1.getFirstName() + " " + nameAuthor1.getLastName() + " " + firstBook.getBookPublication());
        System.out.println(secondBook.getBookName() + " " + nameAuthor2.getFirstName() + " " + nameAuthor2.getLastName() + " " + secondBook.getBookPublication());
        // второй уровень сложности
        System.out.print("\n");
        System.out.println("Второй уровень сложности");
        // Необходимо в классе с методом main создать массив объектов типа Book и положить туда созданные книги.
        Book[] bookArray = new Book[5];
        bookArray[0] = firstBook;
        bookArray[1] = secondBook;
        // Добавить книгу
        addBook(bookArray, "Рефакторинг", "Мартин", "Фаулер", 2019);
        // Распечатать книгу
        printBook(bookArray);
        Library libraryMe = new Library(25);
        // Сложный уровень
        System.out.print("\n");
        System.out.println("Сложный уровень");
        // Добавить книги в библиотеку
        libraryMe.addBook("Рефакторинг", "Мартин", "Фаулер", 2019);
        libraryMe.addBook("Мир и война", "Борис",  "Акунин",  2020);
        libraryMe.addBook("Семь дней до Мегиддо", "Сергей", "Лукьяненко", 2021);
        // Напечатать информацию о книге по ее названию
        libraryMe.printBookDetail("Рефакторинг");
        // Изменить год публикации книги по ее названию
        libraryMe.changeBookYear("Рефакторинг", 2021);
         // Напечатать чтобы проверить
        libraryMe.printBookDetail("Рефакторинг");
    }

    private static void addBook(Book[] array, String bookName, String authorName1, String authorName2, int year) {
        // найти первую пустую ячейку
        int freePosition = findItem(array);
        if (freePosition > array.length) {
            throw new RuntimeException("Для новых книг не осталось места");
        }
        // Добавить книгу
        Author nameAuthor = new Author(authorName1, authorName2);
        Book newBook = new Book(bookName, nameAuthor, year);
        array[freePosition] = newBook;
    }

    private static int findItem(Book[] array) {
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

    private static void printBook(Book[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                break;
            }
            System.out.print(array[i].getBookName() + ": ");
            System.out.print(array[i].getAuthor() + ": ");
            System.out.print(array[i].getBookPublication());
            System.out.print("\n");
        }
    }
}
