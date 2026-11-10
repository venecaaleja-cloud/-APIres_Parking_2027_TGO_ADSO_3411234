package com.sena.api.parking.dto;

import com.sena.api.parking.model.TipoVehiculo;
import com.sena.api.parking.model.Vehiculo;

public record VehiculoRresponse(Long idvehiculo, string placa, TipoVehiculo tipo, string descripcion) {

	public static VehiculoRresponse de(Vehiculo v) {
		return new VehiculoRresponse(v.getId_vehiculo(), v.getPlaca(), v.getTipo(), v.getDescripcion());
	}

}
