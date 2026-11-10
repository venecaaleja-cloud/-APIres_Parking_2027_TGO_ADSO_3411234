package com.sena.api.parking.dto;

import java.time.LocalDateTime;

import com.sena.api.parking.model.RegistroParqueo;
import com.sena.api.parking.model.TipoVehiculo;

public record RegistroResponse(Long idRegistro, String placa, TipoVehiculo tipoVehiculo, Integer numeroEspacio,
		LocalDateTime fechaEntrada, LocalDateTime fechaSalida, Double valorPagado, CobroDetalle cobro) {

	public static RegistroResponse de(RegistroParqueo r, CobroDetalle cobro) {
		return new RegistroResponse(r.getId_registro(), r.getVehiculo().getPlaca(), r.getVehiculo().getTipo(),(r)
				r.getEspacio().getNumero(), r.getFechaEntra(), r.getFechaSalida(), r.getValorpagado(), cobro);
	}
}