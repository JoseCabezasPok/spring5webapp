package com.josecabezas.spring5Webapp.repositories;

import com.josecabezas.spring5Webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
