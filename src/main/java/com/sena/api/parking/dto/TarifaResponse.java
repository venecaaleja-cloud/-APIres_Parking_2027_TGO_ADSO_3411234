package com.sena.api.parking.dto;

import java.time.LocalDateTime;

import com.sena.api.parking.model.Tarifa;
import com.sena.api.parking.model.TipoVehiculo;

public record TarifaResponse(Long idTarifa, TipoVehiculo tipo, Long valorHora, Long valorFraccion,
		Integer fraccionMinutos, LocalDateTime vigenteDesde, LocalDateTime vigenteHasta, boolean vigente) {
	public static TarifaResponse de(Tarifa t) {
		return new TarifaResponse(t.getId_tarifa(), t.getTipo(), t.getValorHora(), t.getValorFraccion(),
				t.getFraccionMinutos(), t.getVigenteDesde(), t.getVigenteHasta(), t.getVigenteHasta() == null);

	}

}
