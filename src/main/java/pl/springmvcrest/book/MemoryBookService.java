package pl.springmvcrest.book;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemoryBookService {
    private List<Book> list;

    public MemoryBookService() {

        list = new ArrayList<>();
        list.add(new Book(1L, "9788324631766", "Thinking in Java", "Bruce Eckel",
                "Helion", "programming"));
        list.add(new Book(2L, "9788324627738", "Rusz glowa, Java.",
                "Sierra Kathy, Bates Bert", "Helion", "programming"));
        list.add(new Book(3L, "9780130819338", "Java 2. Podstawy",
                "Cay Horstmann, Gary Cornell", "Helion", "programming"));
    }

    public List<Book> getList() {
        return list;
    }

    public void setList(List<Book> list) {
        this.list = list;
    }

    public Book getOne(long id) {
        return this.list.stream().filter(b -> b.getId() == id).findFirst().get();
    }

    public void addBook(Book book) {
        this.list.add(book);
    }

    public void deleteBook(long id) {
        Book book = this.list.stream()
                .filter(b -> b.getId() == id)
                .findFirst()
                .get();
        this.list.remove(book);
    }

    public void editBook(long id, Book book2) {
        Book book = this.list.stream()
                .filter(b -> b.getId() == id)
                .findFirst()
                .get();
        this.list.remove(book);
        this.list.add(book2);
    }
}
