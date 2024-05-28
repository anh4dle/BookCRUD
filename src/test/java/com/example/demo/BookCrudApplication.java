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
			Book book1 = new Book("To Huu", "Nang Ha", "Quyen sach dau tien", 123);
			Book book2 = new Book("To Huu2", "Nang Ha2", "Quyen sach thu 2", 4561);
			Book book3 = new Book("To Huu3", "Nang Ha3", "Quyen sach thu 3", 789);
			repo.save(book1);
			repo.save(book2);
			repo.save(book3);

			repo.findAll().forEach(book -> {
				System.out.println(book.toString());
			});
			Book returned = repo.findByisbn(4561);
			System.out.println("Book returned: " + returned.toString());
		};
	}

}
