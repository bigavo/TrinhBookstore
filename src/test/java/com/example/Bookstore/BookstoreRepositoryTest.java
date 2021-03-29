package com.example.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.Bookstore.model.Book;
import com.example.Bookstore.model.BookRepository;
import com.example.Bookstore.model.CategoryRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BookstoreRepositoryTest {
    @Autowired
    private BookRepository repository;
    @Autowired
    private CategoryRepository crepository;
    @Test
    public void findByTitleShouldReturnAuthor() {
        List<Book> books = repository.findByTitle("Harry Potter: The Complete Collection (1-7)");
        //assertThat(books).hasSize(1);
        assertThat(books.get(0).getAuthor()).isEqualTo("J. K. Rowling");
    }
    @Test
    public void createNewBook() {
        Book book = new Book("Doreamon", (char) (9783-16-148410-0), 80.23, "Japanese", 1997, crepository.findByName("Children").get(0));
        repository.save(book);
        assertThat(book.getId()).isNotNull();
    }
}


