package com.knighttech.pocketlibrary.Repository;

import com.knighttech.pocketlibrary.Model.Book;
import java.util.List;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.datatype.jsr310.*;
import java.io.*;
import java.nio.file.*;

public class FileRepository implements IRespository {

    private final ObjectMapper mapper;
    private final Path storageFile;

    public FileRepository(String filename) {
        this.storageFile = Paths.get(filename);
        this.mapper = new ObjectMapper()
            .registerModule(new JavaTimeModule())               // para fechas Java 8+
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
            .enable(SerializationFeature.INDENT_OUTPUT)         // bonito, con sangrías
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }


    // Implementación de los métodos de IRespository
    @Override
    public void addBook(Book book) {
        try {
            // Solo creamos el directorio padre si existe y no es la raíz
            Path parent = storageFile.getParent();
            System.out.println("Directorio padre: " + parent.toAbsolutePath());
            if (!Files.exists(parent)) {
                Files.createDirectories(parent);
                System.out.println("Directorio creado: " + parent.toAbsolutePath());
            }
            System.out.println("Guardando libro: " + book);
            System.out.println("Ruta del archivo de almacenamiento: " + storageFile.toAbsolutePath());
            mapper.writeValue(storageFile.toFile(), book);
        } catch (IOException e) {
            throw new RuntimeException("Error guardando biblioteca en JSON", e);
        }
    }

    @Override
    public Book getBook(String isbn) {
        if (Files.exists(storageFile)) {
            try {
                return mapper.readValue(storageFile.toFile(), Book.class);
            } catch (IOException e) {
                throw new RuntimeException("Error cargando biblioteca desde JSON", e);
            }
        } else {
            throw new RuntimeException("No se encontró el archivo de biblioteca: " + storageFile);
        }
    }

    @Override
    public void removeBook(String isbn) {
        // Lógica para eliminar un libro por ISBN
    }

    @Override
    public List<Book> getAllBooks() {
        // Lógica para obtener todos los libros
        return null; // Placeholder
    }

    @Override
    public boolean bookExists(String isbn) {
        // Lógica para verificar si un libro existe por ISBN
        return false; // Placeholder
    }

    @Override
    public void updateBook(Book book) {
        // Lógica para actualizar un libro existente
    }

    @Override
    public void clearAllBooks() {
        // Lógica para limpiar todos los libros del repositorio
    }
    
}
