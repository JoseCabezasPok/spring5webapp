package com.josecabezas.spring5Webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import com.josecabezas.spring5Webapp.domain.Book;
public interface BookRepository extends CrudRepository<Book, Long> {
}
