package peaksoft.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import peaksoft.model.Book;
import peaksoft.service.BookService;

@Controller
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping
    public String getAllBooks(Model model) {
        model.addAttribute("allBooks", bookService.getAllBooks());
        return "getBooks";
    }

    @GetMapping("/new")
    public String createBook(Model model) {
        model.addAttribute("newBook", new Book());
        return "newBook";
    }

    @PostMapping("/save")
    public String saveBook(@ModelAttribute("newBook") Book book) {
        bookService.saveBook(book);
        return "redirect:/books";
    }


}
