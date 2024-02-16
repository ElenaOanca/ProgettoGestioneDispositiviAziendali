package it.epicode.ProgettoGestioneDispositiviAziendali.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class DispositivoRequest {

    @Enumerated(EnumType.STRING)
    @NotBlank(message = "Il tipo non può essere vuoto")
    @NotEmpty(message = "Il tipo è obbligatorio")
    private Tipo tipo;


    @Enumerated(EnumType.STRING)
    @NotBlank(message = "Lo status non può essere vuoto")
    @NotEmpty(message = "Lo status è obbligatorio")
    private Status status;


    @NotBlank(message = "Il dipendente non può essere vuoto")
    @NotEmpty(message = "Il dipendente è obbligatorio")
    private Dipendente dipendente;

    public DispositivoRequest() {
    }

    public Tipo getTipo() {
        return tipo;
    }

    public Status getStatus() {
        return status;
    }

    public Dipendente getDipendente() {
        return dipendente;
    }
    public DispositivoRequest(Tipo tipo, Status status, Dipendente dipendente) {
        this.tipo = tipo;
        this.status = status;
        this.dipendente = dipendente;
    }

}
