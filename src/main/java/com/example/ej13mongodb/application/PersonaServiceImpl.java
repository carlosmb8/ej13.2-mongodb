package com.example.ej13mongodb.application;

import com.example.ej13mongodb.dto.input.PersonaInputDTO;
import com.example.ej13mongodb.dto.output.PersonaOutputDTO;
import com.example.ej13mongodb.entity.Persona;
import com.example.ej13mongodb.excepciones.UnprocessableEntityException;

import com.example.ej13mongodb.repository.PersonaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;


import java.util.*;



@Service
@EnableMongoRepositories
@EnableAutoConfiguration
@ComponentScan
@Configuration
public class PersonaServiceImpl implements PersonaService {

//    @Autowired
//    PersonaRepositorio mongoTemplate;
    private final MongoTemplate mongoTemplate;
    
    @Autowired
    public PersonaServiceImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public PersonaOutputDTO insertarPersona(PersonaInputDTO personaDTO) {
        if (personaDTO.getUsuario().length() > 10) {
            throw new UnprocessableEntityException();
        } else {
            Persona persona = new Persona(personaDTO);
            mongoTemplate.save(persona);
            PersonaOutputDTO saveOutputDTO = new PersonaOutputDTO(persona);
            return saveOutputDTO;
        }
    }

    @Override
    public PersonaOutputDTO editarPersona(Integer id, PersonaInputDTO personaInputDTO) throws Exception {

        Persona persona = mongoTemplate.findById(id, Persona.class);

        persona.setUsuario(personaInputDTO.getUsuario());
        persona.setPassword(personaInputDTO.getPassword());
        persona.setName(personaInputDTO.getName());
        persona.setSurname(personaInputDTO.getSurname());
        persona.setCompany_email(personaInputDTO.getCompany_email());
        persona.setPersonal_email(personaInputDTO.getPersonal_email());
        persona.setCity(personaInputDTO.getCity());
        persona.setActive(personaInputDTO.isActive());
        persona.setImagen_url(personaInputDTO.getImagen_url());

        mongoTemplate.save(persona);

        return new PersonaOutputDTO(persona);

    }

    @Override
    public void eliminarPersona(Integer id) throws Exception {
        try {

            mongoTemplate.remove(id);

        } catch (Exception e) {
            throw new Exception();
        }
    }

    @Override
    public Persona buscarPersonaPorId(Integer id) {

        return mongoTemplate.findById(id, Persona.class);
    }


    @Override
    public List<Persona> dameAllPersonas() throws Exception {
        try {

            return mongoTemplate.findAll(Persona.class);
        } catch (Exception e) {
            throw new Exception("No hay registros");
        }
    }
}
