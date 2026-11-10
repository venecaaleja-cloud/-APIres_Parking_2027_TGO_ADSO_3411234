package com.sena.api.parking.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sena.api.parking.dto.EspacioResponse;
import com.sena.api.parking.dto.espacioRequest;
import com.sena.api.parking.exception.ApiException;
import com.sena.api.parking.model.EspacioParqueo;
import com.sena.api.parking.repository.EspacioParqueoRepository;
import com.sena.api.parking.repository.RegistroParqueoRepository;
import com.sena.api.parking.exception.ApiException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EspacioService {

	private static final int MAX_LOTE = 500;

	private final EspacioParqueoRepository espacioRepo;
	private final RegistroParqueoRepository registroRepo;

	@Transactional
	public EspacioResponse crear(espacioRequest req) {
		if (espacioRepo.existsByNumero(req.numero())) {
			throw ApiException.("Ya existe el espacio numero " + req.numero());
		}
		EspacioParqueo e = EspacioParqueo.builder().numero(req.numero()).tipo(req.tipo()).build();
		return EspacioResponse.de(espacioRepo.save(e));
	}

}
