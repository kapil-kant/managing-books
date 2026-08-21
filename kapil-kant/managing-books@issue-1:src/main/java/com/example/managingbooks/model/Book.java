package com.example.managingbooks.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is required and cannot be empty")
    private String title;

    @NotBlank(message = "Author is required and cannot be empty")
    private String author;

    @NotBlank(message = "ISBN is required")
    // Basic ISBN pattern validation: Supports 10-digit ISBN-10 (with optional hyphens) or 13-digit ISBN-13
    @Pattern(regexp = "^(\d{9}[\dX]|\d{13})$", message = "Invalid ISBN format (must be 10 or 13 digits)")
    private String isbn;

    @NotNull(message = "Published year is required")
    @Min(value = 1000, message = "Published year must be a realistic year")
    private Integer publishedYear;

    // Getters and Setters

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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(Integer publishedYear) {
        this.publishedYear = publishedYear;
    }
}