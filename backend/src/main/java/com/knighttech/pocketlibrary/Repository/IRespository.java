package com.knighttech.pocketlibrary.Repository;

import com.knighttech.pocketlibrary.Model.Book;
import java.util.List;

public interface IRespository {
    
    void addBook(Book book);
    Book getBook(String isbn);
    void removeBook(String isbn);
    List<Book> getAllBooks();

    boolean bookExists(String isbn);
    void updateBook(Book book);
    void clearAllBooks();    
}
