package com.example.ej13mongodb.entity;


import com.example.ej13mongodb.dto.input.PersonaInputDTO;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@Table(name = "persona", uniqueConstraints = {@UniqueConstraint(columnNames = {"id_persona"})})
@Document(collection = "Persona")
public class Persona implements Serializable {

    @Id
    Integer id_persona;

    String usuario;
    String password;
    String name;
    String surname;
    String company_email;
    String personal_email;
    String city;
    boolean active;
    Date created_date;
    String imagen_url;
    Date termination_date;


    public Persona(PersonaInputDTO personaDTO) {
        this.id_persona = personaDTO.getId_persona();
        this.usuario = personaDTO.getUsuario();
        this.password = personaDTO.getPassword();
        this.name = personaDTO.getName();
        this.surname = personaDTO.getSurname();
        this.company_email = personaDTO.getCompany_email();
        this.personal_email = personaDTO.getPersonal_email();
        this.city = personaDTO.getCity();
        this.active = personaDTO.isActive();
        this.created_date = personaDTO.getCreated_date();
        this.imagen_url = personaDTO.getImagen_url();
        this.termination_date = personaDTO.getTermination_date();
    }

}
