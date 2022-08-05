package com.example.obrestdatajpa.controller;

import com.example.obrestdatajpa.entities.Book;
import com.example.obrestdatajpa.repository.BookRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    //Atributos
    private BookRepository bookRepository;
    private final Logger log = LoggerFactory.getLogger(BookController.class);

    //Constructores
    public BookController(BookRepository bookRepository){

        this.bookRepository = bookRepository;
    }


    /**
     * Buscar todos los libros que hay en la base de datos (ArrayList de libros)
     * http://localhost:8080/api/books
     * @return
     */
    @GetMapping("/api/books")
    public List<Book> findAll(){
        //Recuperar y devolver los libros de base de datos
        return bookRepository.findAll();

    }

    //Buscar un solo libro en base de datos según su id

    //Opción 1: Esta opción es haciendolo con objetos book pero devuelve null sino se encuentra el obj y lo
    //correcto es devolver una respuesta para eso usamos la otra opción ResponseEntity(ver opción 2)
    /*@GetMapping("/api/books/{id}")
    public Book findOneById(@PathVariable Long id){

        //Optional es genérico por lo que debo especificarlo en el objeto a guardar
        Optional<Book> bookOpt = bookRepository.findById(id);

        //Opción 1: para devolver el objeto con if con sintaxis normal

        //if(bookOpt.isPresent()) return bookOpt.get();
        //else return null;


        //Opción 2: con programción funcional, es el mismo resultado que la opción 1
        return bookOpt.orElse(null);

    }*/

    /**
     * Buscar un solo libro en base de datos según su id
     * Request
     * Response
     * @param id
     * @return
     */
    //Opción 2: Usando ResponseEntity para no tener que devolver null
    @GetMapping("/api/books/{id}")
    @ApiOperation("Buscar un libro por clave primaria id Long")//Agrega en swagger lo que hace el método
    public ResponseEntity<Book> findOneById(@ApiParam("Clave primaria tipo Long") @PathVariable Long id){

        Optional<Book> bookOptional = bookRepository.findById(id);

        //Opción 1: con sintaxis orientada a objetos
        if(bookOptional.isPresent())
            return ResponseEntity.ok(bookOptional.get());

            return ResponseEntity.notFound().build();


        //Opción 2: con sintaxis funcional con lambda
       //return bookOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }

    /**
     * Crear un nuevo libro en base de datos
     * Método POST, no colisiona con finaAll porque son diferentes métodos HTTP: GET vs POST
     * @param book
     * @param headers
     * @return
     */
    @PostMapping("/api/books")
    public ResponseEntity<Book> create(@RequestBody Book book, @RequestHeader HttpHeaders headers){
        System.out.println(headers.get("User-Agent"));
        //Guardar un libro en la base de datos recibido por parámetro
        if(book.getId() != null) {//quiere decir que existe el "id", por lo tanto, no es una creación
            log.warn("Trying to create a book with id");
            System.out.println("Trying to create a book with id");
            return ResponseEntity.badRequest().build();
        }
        Book result = bookRepository.save(book);
        return ResponseEntity.ok(result); //el libro devuelto tiene una clave primaria
    }


    /**
     * Actualizar un libro existente en la base de datos
     */
    @PutMapping("/api/books")
    public ResponseEntity<Book> update(@RequestBody Book book){
        if(book.getId() == null){// si no tiene id quiere decir que sí es una creación
            log.warn("Trying to update a non existent book");
            return ResponseEntity.badRequest().build();
        }
        if(!bookRepository.existsById(book.getId())){
            log.warn("Trying to update a non existent book");
            return ResponseEntity.notFound().build();
        }
        //El proceso de actualización
        Book result = bookRepository.save(book);
        return ResponseEntity.ok(result);
    }


    //Borrar un libro en base de datos
    @ApiIgnore//No deja que aparezca el método en la documentacións
    @DeleteMapping("/api/books/{id}")
    public ResponseEntity<Book> delete(@PathVariable Long id){

        if(!bookRepository.existsById(id)) {
            log.warn("Trying to delete a non existent book");
            return ResponseEntity.notFound().build();
        }

        bookRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @ApiIgnore//No deja que aparezca el método en la documentación
    @DeleteMapping("/api/books")
    public ResponseEntity<Book> deleteAll(){
        log.info("REST Request for delete all books");
        bookRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }

}
