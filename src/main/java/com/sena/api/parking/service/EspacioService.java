package com.sena.api.parking.service;

import org.springframework.stereotype.Service;

import com.sena.api.parking.repository.EspacioParqueoRepository;
import com.sena.api.parking.repository.RegistroParqueoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EspacioService {
	
	private static final int MAX_LOTE = 500;
	
	private final EspacioParqueoRepository espacioRepo;
	private final RegistroParqueoRepository registroRepo;
	
	public EspacioResponse crear() {
		
	}

}
