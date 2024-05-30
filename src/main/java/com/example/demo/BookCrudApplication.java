package com.example.demo;

import com.example.demo.Models.Book;
import com.example.demo.Repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookCrudApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repo) {
		return (args) -> {
			repo.deleteAll();

			Book book1 = new Book("To Huu", "Nang Ha", "Quyen sach dau tien", 123);
			Book book2 = new Book("To Huu2", "Nang Ha2", "Quyen sach thu 2", 4561);
			Book book3 = new Book("To Huu3", "Nang Ha3", "Quyen sach thu 3", 789);
			repo.save(book1);
			repo.save(book2);
			repo.save(book3);
			//Get all books
			repo.findAll().forEach(book -> {
				System.out.println(book.toString());
			});
			//Find by isbn
			System.out.println("Book returned: " + repo.findByisbn(4561).toString());
			//Find by title
			System.out.println("Book returned: " + repo.findByTitle("Nang Ha3").toString());
			//Delete a book
			repo.delete(book3);
			//Get all books
			repo.findAll().forEach(book -> {
				System.out.println(book.toString());
			});
			//Delete all book
			repo.deleteAll();
			System.out.print("Book size after delete all: " + repo.findAll().size());

		};
	}

}
