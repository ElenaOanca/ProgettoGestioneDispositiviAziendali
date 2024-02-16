package it.epicode.ProgettoGestioneDispositiviAziendali.exception;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorResponse {
    private String message;
    private LocalDateTime dataResponse;


    private String status;

    public ErrorResponse(String message) {
    }


    public void setMessage(String message) {
    }

    public void setStatus(String number) {
    }

    public void setDataResponse(LocalDateTime now) {
    }



}
