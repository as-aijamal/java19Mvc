package peaksoft.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.model.Author;
import peaksoft.service.AuthorService;
import peaksoft.service.BookService;

@Controller
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;
    private final BookService bookService;

    @GetMapping()
    public String getAllAuthors(Model model) {
        model.addAttribute("allAuthors", authorService.getAllAuthors());
        model.addAttribute("allBooks",bookService.getAllBooksWithoutAuthor());
        return "getAuthors";
    }

    @GetMapping("/new")
    public String createAuthor(Model model) {
        model.addAttribute("newAuthor", new Author());
        return "newAuthor";
    }

    @PostMapping("/save")
    public String saveAuthor(@ModelAttribute("newAuthor") Author author) {
        authorService.saveAuthor(author);
        return "redirect:/authors";
    }

    @GetMapping("/{id}")
    public String getAuthor(@PathVariable("id") Long id, Model model) {
        model.addAttribute("author", authorService.getAuthorById(id));
        return "updateAuthor";
    }

    @PostMapping("/update/{id}")
    public String updateAuthor(@ModelAttribute Author author,
                               @PathVariable("id") Long id) {
        authorService.updateAuthor(id, author);
        return "redirect:/authors";
    }

    @GetMapping("/{id}/delete")
    public String deleteAuthor(@PathVariable("id") Long id) {
        authorService.deleteAuthor(id);
        return "redirect:/authors";
    }

    @PostMapping("/assign/{authorId}")
    public String assignBook(@PathVariable("authorId") Long authorId,
                             @RequestParam("bookId") Long bookId) {
        bookService.assignBookToAuthor(authorId, bookId);
        return "redirect:/authors";
    }


}
