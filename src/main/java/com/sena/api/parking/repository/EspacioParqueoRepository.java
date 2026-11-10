package com.sena.api.parking.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sena.api.parking.model.EspacioParqueo;
import com.sena.api.parking.model.EstadoEspacio;
import com.sena.api.parking.model.TipoVehiculo;

import jakarta.persistence.LockModeType;

public interface EspacioParqueoRepository  extends JpaRepository<EspacioParqueo, Long> {
	
	@Query("select count(e) > o from EspacioParqueo e where e. numero = :numero")
	boolean existsByNumero(@Param("numero") Integer numero);
	
	@Lock(LockModeType.PESSIMISTIC_WRITE)
	Optional<EspacioParqueo> findFirstByTipoAndEstadoOrderByNumeroAsc(TipoVehiculo tipo, EstadoEspacio estado);
	
	@Lock(LockModeType.PESSIMISTIC_WRITE)
	@Query("Select e from EspacioParqueo e where e.numero = :numero")
	Optional<EspacioParqueo>bloquearPorNumero(@Param("numero") Integer numero);

}
