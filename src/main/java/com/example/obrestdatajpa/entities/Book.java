package com.example.obrestdatajpa.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Books")
@ApiModel("Entidad libro para representar un elemento didáctico")
public class Book {

    //atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("Clave ficticia autoincremental tipo Long")
    private Long id;
    private String title;
    private String author;
    private Integer pages;
    @ApiModelProperty("Precio en determinada moneda usando .(punto) como separador")
    private Double price;
    private LocalDate relesaseDate;
    private Boolean online;

    //Constructores

    public Book() {
    }

    public Book(Long id, String title, String author, Integer pages, Double price, LocalDate relesaseDate, Boolean online) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.price = price;
        this.relesaseDate = relesaseDate;
        this.online = online;
    }

    //Getter y Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getRelesaseDate() {
        return relesaseDate;
    }

    public void setRelesaseDate(LocalDate relesaseDate) {
        this.relesaseDate = relesaseDate;
    }

    public Boolean getOnline() {
        return online;
    }

    public void setOnline(Boolean online) {
        this.online = online;
    }


}
