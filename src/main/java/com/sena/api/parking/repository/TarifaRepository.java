package com.sena.api.parking.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sena.api.parking.model.Tarifa;
import com.sena.api.parking.model.TipoVeiculo;

import jakarta.persistence.LockModeType;

public interface TarifaRepository extends JpaRepository<Tarifa, Long> {
	
	
	
	@Query("select count(t) > 0 from Tarifa t where t.tipo = :tipo and t.vigenteHasta is null")
	boolean existsByTipoAndVigenteHastaIsNull(@Param("tipo") TipoVeiculo tipo);
	
	Optional<Tarifa> findfirstByTipoAndVigenteHastaIsNull(TipoVeiculo tipo);
	List<com.sena.api.parking.model.Tarifa> findAllByTipoAscVigenteDesdeDesc();

	@Lock(LockModeType.PESSIMISTIC_WRITE)
	@Query("select t from Tarifa t where t.tipo = :tipo and t.vigenteHasta is null")
	Optional<Tarifa> bloquearVigente(@Param("tipo") TipoVeiculo tipo);
	
	@Query("select t from Tarifa t where t.tipo = :tipo and t.vigenteDesde <= :momento "
			+ "and (t.vigenteHasta is null or t.vigenteHasta > :momento) order by t.vigenteDesde desc")
	List<Tarifa> vigenteEn(@Param("tipo")TipoVeiculo tipo, @Param("momento")LocalDateTime momento);
}
