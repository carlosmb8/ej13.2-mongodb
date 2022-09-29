package com.example.ej13mongodb.controller;


import com.example.ej13mongodb.application.PersonaServiceImpl;
import com.example.ej13mongodb.dto.input.PersonaInputDTO;
import com.example.ej13mongodb.dto.output.PersonaOutputDTO;
import com.example.ej13mongodb.entity.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
public class PersonaControlador {

    @Autowired
    PersonaServiceImpl personaServiceImpl;



    public static final String GREATER_THAN="greater";
    public static final String LESS_THAN="less";
    public static final String EQUAL="equal";


    @GetMapping("personas/{id}")
    public PersonaOutputDTO damePersona(@PathVariable Integer id) {
            return new PersonaOutputDTO(personaServiceImpl.buscarPersonaPorId(id));
    }

    @PostMapping("personas")
    public List<PersonaOutputDTO> damePersonaPorNombre(@RequestParam String name) throws Exception {

        return personaServiceImpl.buscarPersonaPorName(name);
    }

    @GetMapping("personas")
    public Iterable<Persona> damePersonas() throws Exception{

        return personaServiceImpl.dameAllPersonas();
    }

    @PostMapping("personas/insertar")
    public PersonaOutputDTO insertaPersona(@RequestBody PersonaInputDTO personaDTO) {

        return personaServiceImpl.insertarPersona(personaDTO);


    }

    @PutMapping("personas/editar")
    public PersonaOutputDTO editarPersona(@RequestParam Integer id, @RequestBody PersonaInputDTO persona) throws Exception {
        return personaServiceImpl.editarPersona(id, persona);
    }

    @DeleteMapping("personas/eliminar")
    public String eliminarPersona(@RequestParam Integer id) throws Exception {
        personaServiceImpl.eliminarPersona(id);
        return "La persona con el id: " + id + " ha sido borrada correctamete";
    }



//    @GetMapping("personas/listadoCriteria")
//    public List<Persona> getPersonasPorCriterio(@RequestParam(required = false) String usuario, @RequestParam(required = false) String name,
//                                                @RequestParam(required = false) String surname, @RequestParam(required = false) @DateTimeFormat(pattern="dd-MM-yyyy HH:mm:ss") Date created_date,
//                                                @RequestParam(required = false) String dateCondition, @RequestParam(required = false) String orderCondition,
//                                                @RequestParam(required = false) Integer offset, @RequestParam(required = false) Integer limit){
//        HashMap<String, Object> conditions = new HashMap<>();
//        if(usuario!=null) {
//            conditions.put("usuario", usuario);
//        }
//        if(name!=null) {
//            conditions.put("name", name);
//        }
//        if(surname!=null) {
//            conditions.put("surname", surname);
//        }
//        if(dateCondition==null || (!dateCondition.equals(GREATER_THAN) && !dateCondition.equals(LESS_THAN)  && !dateCondition.equals(EQUAL))){
//            dateCondition=GREATER_THAN;
//            System.out.println(dateCondition);
//        }
//        if(created_date!=null) {
//            conditions.put("created_date", created_date);
//            System.out.println(created_date);
//            conditions.put("dateCondition", dateCondition);
//        }
//        if(orderCondition!=null) {
//            conditions.put("orderCondition", orderCondition);
//        }
//
//        return personaServiceImpl.damePersonasPorCriterioPaginado(conditions, offset, limit);
//    }
}
