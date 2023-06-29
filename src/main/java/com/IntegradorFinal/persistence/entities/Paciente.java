package com.IntegradorFinal.persistence.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Set;


@Entity
@Table(name="pacientes")
@Getter
@Setter
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paciente_sequence")
    @SequenceGenerator(name = "paciente_sequence", sequenceName = "paciente_sequence", allocationSize = 1)
    private Integer id;

    @Size(max = 50, message = "El nombre debe tener hasta 50 caracteres")
    @NotNull(message = "El nombre del paciente no puede ser nulo")
    @NotBlank(message = "El nombre del paciente no debe quedar en blanco" )
    private String nombre;

    @Size(max = 50, message = "El apellido debe tener hasta 50 caracteres")
    @NotNull(message ="El apellido del paciente no debe ser nulo" )
    private String apellido;

//    @Pattern(regexp = "\\d", message = "El campo DNI solo admite caracteres numericos")
    @Length(max = 12)
    @NotBlank(message = "Debe especificar el DNI del paciente")
    private String dni;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @FutureOrPresent(message = "La fecha no debe ser anteior al dia de hoy")
    @NotNull(message = "Debe especificar la fecha de ingreso del paciente")
    private LocalDate fechaIngreso;


    //Relacion de UN Paciente tienen UN Domicilio
    @OneToOne(cascade = CascadeType.ALL, optional = true)
    @JoinColumn(name = "domicilio_id", referencedColumnName = "id", nullable = true)
    private Domicilio domicilio;


    //Relacion de UN paciente tiene MUCHOS turnos
    @OneToMany(mappedBy = "paciente")
    @JsonIgnore
    private Set<Turno> turnos;


    // Constructores
    public Paciente(String nombre, String apellido, String dni, LocalDate fechaIngreso) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
    }

    public Paciente() {
    }




}
