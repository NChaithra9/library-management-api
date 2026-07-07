package com.library.library_management_api.service;

import com.library.library_management_api.entity.Book;
import com.library.library_management_api.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;


    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }


    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElse(null);
    }


    public Book createBook(Book book) {
        book.setAvailable(true);
        return bookRepository.save(book);
    }


    public Book updateBook(Long id, Book updatedBook) {

        Book existingBook = bookRepository.findById(id)
                .orElse(null);

        if(existingBook != null) {

            existingBook.setTitle(updatedBook.getTitle());
            existingBook.setAuthor(updatedBook.getAuthor());
            existingBook.setGenre(updatedBook.getGenre());
            existingBook.setIsbn(updatedBook.getIsbn());

            return bookRepository.save(existingBook);
        }

        return null;
    }


    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}