package com.sena.api.parking.dto;

import com.sena.api.parking.model.EspacioParqueo;
import com.sena.api.parking.model.EstadoEspacio;
import com.sena.api.parking.model.TipoVehiculo;

public record EspacioResponse(Long idEspacio, Integer numero, TipoVehiculo tipo, EstadoEspacio estado) {

	public static EspacioResponse de(EspacioParqueo e) {
		return new EspacioResponse(e.getId_espacio(), e.getNumero(), e.getTipo(), e.getEstado());
	}

}