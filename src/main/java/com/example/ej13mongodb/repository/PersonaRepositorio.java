package com.example.ej13mongodb.repository;

import com.example.ej13mongodb.entity.Persona;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Repository
public interface PersonaRepositorio
//        extends MongoRepository<Persona, Integer>
{

    List<Persona> findByName(String name);
}
