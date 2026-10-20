package com.sena.api.parking.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sena.api.parking.model.EspacioParqueo;
import com.sena.api.parking.model.RegsitroParqueo;

import jakarta.persistence.LockModeType;

public interface RegistroParqueoRepository extends JpaRepository<RegsitroParqueo, Long> {
	
	@Query("select count(r) > 0 from RegistroParqueadero r join r.vehiculo where v.placa = :placa"
			+ "and r.fechaSalida is null")
	boolean existsByVehiculoPlacaAndFechaSalidaINull(@Param("placa")String placa);
	
	@Query("select count(r) > 0 from RegistroParqueo r where r.espacio = :espacio")
	boolean existsByEspacio(@Param("espacio") EspacioParqueo espacio);
	
	Optional<RegsitroParqueo> findByVehiculoPlacaAndFechaSalidaIsNull(String placa);
	
	List<RegsitroParqueo> findByFechaSalidaIsNotNullOrderByFechaEntradaDesc();
	
	List<RegsitroParqueo> finByVehiculoPlacaOrderByFechaEntradaDesc(String placa);
	
	@Lock(LockModeType.PESSIMISTIC_WRITE)
	@Query("select r frm RegistroParqueo r where r.id_registro = :id")
	Optional<RegsitroParqueo> bloquearPrId(@Param ("id") long id);
	
	@Lock(LockModeType.PESSIMISTIC_WRITE)
	@Query("select r from RegistroParqueo r join r.vehiculo where v.placa = :placa and r.fechaSalida is null")
	
	Optional<RegsitroParqueo> bloquearActivoPorPlaca(@Param ("placa") String placa);
	
	

}
