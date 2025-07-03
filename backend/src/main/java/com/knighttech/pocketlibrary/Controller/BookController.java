package com.knighttech.pocketlibrary.Controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {
    
    @GetMapping()
    public String getBooks() {
        return "Mensaje desde getBooks";
    }
    
    /*@PutMapping("/id")
    public String putBook(@RequestBody String body){
        return "Contenido cuerpo petición: " + body;
    }*/

    @PostMapping("/{isbn}/{title}")
    public String addBook(@PathVariable String isbn, @PathVariable String title) {

        return "Libro agregado: ISBN = " + isbn + ", Título = " + title;
    }
}
