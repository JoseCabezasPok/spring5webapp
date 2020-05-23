package com.josecabezas.spring5Webapp.repositories;


import com.josecabezas.spring5Webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
