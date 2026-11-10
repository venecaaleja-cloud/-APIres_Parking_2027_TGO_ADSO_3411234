package com.sena.api.parking.dto;



import com.sena.api.parking.model.TipoVehiculo;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record espacioLoteRequest(@NotNull @Positive Integer desde, @NotNull @Positive Integer hasta,
		@NotNull TipoVehiculo tipo) {

}