package com.josecabezas.spring5Webapp.bootstrap;

import com.josecabezas.spring5Webapp.domain.Author;
import com.josecabezas.spring5Webapp.domain.Book;
import com.josecabezas.spring5Webapp.repositories.AuthorRepository;
import com.josecabezas.spring5Webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("Eric","Evans");
        Book ddd = new Book("Domain Driven Design","123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod","Riot");
        Book eee = new Book("Caperucita","33333333");
        rod.getBooks().add(eee);
        eee.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(eee);

        System.out.println("Started in bootstrap");
        System.out.println("Number of books: "+bookRepository.count() );


    }
}
