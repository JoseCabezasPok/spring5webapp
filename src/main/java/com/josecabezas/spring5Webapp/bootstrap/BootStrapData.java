package com.josecabezas.spring5Webapp.bootstrap;

import com.josecabezas.spring5Webapp.domain.Author;
import com.josecabezas.spring5Webapp.domain.Book;
import com.josecabezas.spring5Webapp.domain.Publisher;
import com.josecabezas.spring5Webapp.repositories.AuthorRepository;
import com.josecabezas.spring5Webapp.repositories.BookRepository;
import com.josecabezas.spring5Webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Publisher peter = new Publisher("peter","Ronda nelle","Coruna","Galicia","15100");
        publisherRepository.save(peter);
        Author eric = new Author("Eric","Evans");
        Book ddd = new Book("Domain Driven Design","123123");
        eric.getBooks().add(ddd);
        ddd.setPublishers(peter);
        ddd.getAuthors().add(eric);
        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod","Riot");
        Book eee = new Book("Caperucita","33333333");
        eee.setPublishers(peter);
        rod.getBooks().add(eee);
        eee.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(eee);
        peter.getBooks().add(eee);
        peter.getBooks().add(ddd);
        System.out.println("Started in bootstrap");
        System.out.println("Number of books: "+bookRepository.count() );


        System.out.println("Numero de publisher:  "+publisherRepository.count());
        System.out.println(peter.toString());
        System.out.println("Numero de libros en publisher "+peter.getBooks().size());

    }
}
