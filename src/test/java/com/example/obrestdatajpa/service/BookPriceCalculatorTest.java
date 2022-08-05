package com.example.obrestdatajpa.service;

import com.example.obrestdatajpa.entities.Book;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BookPriceCalculatorTest {

    @Test //Pone la anotación por defecto pero sino chequear que tenga dicha anotación para que
    //habilite el botón de ejecutar(o play) al lado del método
    void calculatePrice() {

        //Configuración de la prueba
        Book book = new Book(1L, "El señor de los Anillos", "Tolkien", 350,
                        25.00, LocalDate.now(), true);
        BookPriceCalculator calculator = new BookPriceCalculator();

        //Se ejecuta el comportamiento a testear
        double price = calculator.calculatePrice(book);
        System.out.println(price);
        //Comprobaciones aserciones
        assertTrue(price >= price);
        assertEquals(32.99, price);

    }
}