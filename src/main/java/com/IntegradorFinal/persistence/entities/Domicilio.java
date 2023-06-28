package com.IntegradorFinal.persistence.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "domicilios")
@Getter @Setter
public class Domicilio {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "domicilio_sequence")
    @SequenceGenerator(name = "domicilio_sequence", sequenceName = "domicilio_sequence", allocationSize = 1)
    private Integer id;
    @NotBlank(message = "Debe especificar la calle del domicilio")
    @NotNull(message = "La calle del domicilio no puede ser nulo")
    private String calle;
//    @Pattern(regexp = "\\d", message = "El campo numero solo admite caracteres numericos")
    @Length(max = 5)
    @NotBlank(message = "Debe especificar el numero del domicilio")
    @NotNull(message = "El numero del domicilio no puede ser nulo")
    private String numero;
    @NotBlank(message = "Debe especificar la localidad del domicilio")
    @NotNull(message = "La localidad del domicilio no puede ser nulo")
    private String localidad;
    @NotBlank(message = "Debe especificar la provincia del domicilio")
    @NotNull(message = "La provincia del domicilio no puede ser nulo")
    private String provincia;


    public Domicilio() {
    }

    public Domicilio(String calle, String numero, String localidad, String provincia) {
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
    }

}
