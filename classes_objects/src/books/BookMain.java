package books;

public class BookMain {

    public static void main(String[] args) {

        Book book = new Book();
        Publisher publisher = new Publisher();

        book.setName("The Shining");
        book.setAuthor("Stephen King");
        book.setYear(1977);

        publisher.setName("New English Library");
        publisher.setCity("London");
        publisher.setCountry("United Kingdom");
        book.setPublisher(publisher);
        System.out.println(book);
    }
}
