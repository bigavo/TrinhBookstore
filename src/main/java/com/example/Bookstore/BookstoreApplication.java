package com.example.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.model.Book;
import com.example.Bookstore.model.BookRepository;
import com.example.Bookstore.model.Category;
import com.example.Bookstore.model.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository brepository, CategoryRepository crepository) {
	return (args) -> {

		crepository.save(new Category("Children"));
		crepository.save(new Category("Scientific"));
		crepository.save(new Category("Comic"));
		
		brepository.save(new Book("Harry Potter: The Complete Collection (1-7)", (char) (9783-16-148410-0), 80.23, "J. K. Rowling", 1997, crepository.findByName("Children").get(0)));
		brepository.save(new Book("Blind Love", (char) (1283-16-123410-0), 80.23, "John Matthew", 1999, crepository.findByName("Comic").get(0)));
		brepository.save(new Book("Wierd Plannet", (char) (5683-16-148410-0), 80.23, "Doe Smith", 2007, crepository.findByName("Scientific").get(0)));
		
	};
	}
}
