package com.IntegradorFinal.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class TurnoDTO {
    private Integer id;
    private LocalDateTime fecha;
    private PacienteDTO paciente;
    private OdontologoDTO odontologo;
}
