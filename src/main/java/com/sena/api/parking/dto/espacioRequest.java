package com.sena.api.parking.dto;

import com.sena.api.parking.model.TipoVehiculo;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record espacioRequest(@NotNull @Positive Integer numero, @NotNull TipoVehiculo tipo) {

}
