package com.example.ej13mongodb.application;

import com.example.ej13mongodb.dto.input.PersonaInputDTO;
import com.example.ej13mongodb.dto.output.PersonaOutputDTO;
import com.example.ej13mongodb.entity.Persona;
import org.springframework.stereotype.Component;


import java.util.HashMap;
import java.util.List;

public interface PersonaService {
    public PersonaOutputDTO insertarPersona(PersonaInputDTO personaDTO);
    public PersonaOutputDTO editarPersona(Integer id, PersonaInputDTO personaInputDTO) throws Exception;
    public void eliminarPersona(Integer id) throws Exception;
    public Persona buscarPersonaPorId(Integer id);
    public List<Persona> dameAllPersonas() throws Exception;

//    public List<Persona> damePersonasPorCriterioPaginado(HashMap<String, Object> conditions, Integer offset, Integer limit);



}
