package com.sena.api.parking.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "espacio_parqueo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EspacioParqueo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id_espacio;
	@Column(nullable = false, unique = true)
   private Integer numero;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
   private TipoVeiculo tipo;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	@Builder.Default
   private EstadoEspacio estado = EstadoEspacio.LIBRE;
}
