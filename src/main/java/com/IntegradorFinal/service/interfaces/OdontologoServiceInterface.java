package com.IntegradorFinal.service.interfaces;

import com.IntegradorFinal.dto.OdontologoDTO;

import java.util.Set;

public interface OdontologoServiceInterface extends ServiceInterface<OdontologoDTO>{
    public Set<OdontologoDTO> obtenerOdontologosPorSuApellidoLike(String apellidoOdontolog);
}
