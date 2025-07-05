package com.knighttech.pocketlibrary.Controller;

import org.springframework.web.bind.annotation.*;

import com.knighttech.pocketlibrary.Model.Book;
import com.knighttech.pocketlibrary.Repository.FileRepository;

@RestController
@RequestMapping("/books")
@CrossOrigin(origins = "*")
public class BookController {
    
    private final FileRepository repository = new FileRepository("backend/data/books.json");

    @GetMapping()
    public String getBooks() {
        return "Mensaje desde getBooks";
    }
    
    /*@PutMapping("/id")
    public String putBook(@RequestBody String body){
        return "Contenido cuerpo petición: " + body;
    }*/

    @PostMapping(value = "/create", consumes = "application/json")
    public String addBook(@RequestBody Book book) {
        this.repository.addBook(book);
        return "Libro agregado: ISBN = " + book.getIsbn() + ", Título = " + book.getTitle();
    }
}
