package pl.springmvcrest.book;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // oznacza to ze wszystko co mamy w clasie ma tak jakby adnotacje @ResponseBody, zwracamy jsona do przegladarki
@RequestMapping("/books")
public class BookController {

    private final MemoryBookService bookService;

    public BookController(MemoryBookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/hello")
    public String hello(){
        return "{hello: World}";
    }

    @RequestMapping("/helloBook") // trszeba przeksztalcic obiekt na jsona - zajmie sie tym jackson
    public Book helloBook(){
        return new Book(1L,"9788324631766","Thinking in Java",
                "Bruce Eckel","Helion","programming");
    }

    @GetMapping("/books")
    public List<Book> getAll() {
        return bookService.getList();
    }

    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable long id) {
        return bookService.getOne(id);
    }

    @PostMapping("/books")
    public void addBook(@RequestBody Book book){ //
        bookService.addBook(book);
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable long id) {
        bookService.deleteBook(id);
    }

    @PutMapping("/books/{id}")
    public void editBook(@PathVariable long id, @RequestBody Book book) {
        bookService.editBook(id, book);
    }




}