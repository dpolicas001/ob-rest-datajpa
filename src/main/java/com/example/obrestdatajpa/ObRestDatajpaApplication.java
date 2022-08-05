package com.example.obrestdatajpa;

import com.example.obrestdatajpa.entities.Book;
import com.example.obrestdatajpa.repository.BookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class ObRestDatajpaApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(ObRestDatajpaApplication.class, args);

		BookRepository repository = context.getBean(BookRepository.class);


		//Crear un libro
		Book book1 = new Book(null, "Homo Deus", "Yuval Noah", 450, 29.99, LocalDate.of(2018, 12, 1), true);
		Book book2 = new Book(null, "Homo Deus", "Yuval Noah", 450, 19.99, LocalDate.of(2013, 12, 1), true);


		//Imprimir antes de almacenar (esto no es CRUD es solo para probar que no hay nada en la BBDD)
		System.out.println("Numero de libros en base de datos: " + repository.findAll().size());
		//Almacenar un libro
		repository.save(book1);
		repository.save(book2);

		//Recuperar todos los libros
		System.out.println("Numero de libros en base de datos: " + repository.findAll().size());

		//Borrar un libro
		//repository.deleteById(1L);

		//Recuperar todos los libros
		System.out.println("Numero de libros en base de datos: " + repository.findAll().size());






	}

}
