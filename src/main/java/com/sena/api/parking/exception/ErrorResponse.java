package com.sena.api.parking.exception;

import java.time.LocalDateTime;
import java.util.List;

public record ErrorResponse(LocalDateTime timetamp, int status, String error, String mensaje, List<String> detalles) {

}
