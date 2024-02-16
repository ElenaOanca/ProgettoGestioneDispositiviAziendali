package it.epicode.ProgettoGestioneDispositiviAziendali.model;

public class CollegaDispositivoRequest {

    private  Long idDipendente;
    private Long idDispositivo;

    public CollegaDispositivoRequest() {
    }

    public CollegaDispositivoRequest(Long idDipendente, Long idDispositivo) {
        this.idDipendente = idDipendente;
        this.idDispositivo = idDispositivo;
    }
}
