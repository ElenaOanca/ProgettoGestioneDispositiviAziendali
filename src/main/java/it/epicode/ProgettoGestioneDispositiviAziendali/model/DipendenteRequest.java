package it.epicode.ProgettoGestioneDispositiviAziendali.model;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class DipendenteRequest {

    private byte[] profileImage;
    @NotBlank(message = "L'username non può essere vuoto")
    @NotEmpty(message = "L'username è obbligatorio")
    private String username;

    @NotBlank(message = "Il nome non può essere vuoto")
    @NotEmpty(message = "Il nome è obbligatorio")
    private String nome;

    @NotBlank(message = "Il cognome non può essere vuoto")
    @NotEmpty(message = "Il cognome è obbligatorio")
    private String cognome;

    @Email(message = "Deve essere un indirizzo email valido")
    @NotBlank(message = "L'email non può essere vuota")
    @NotEmpty(message = "L'email è obbligatoria")
    private String email;

    public DipendenteRequest() {
    }

    public String getUsername() {
        return username;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getEmail() {
        return email;
    }



    public DipendenteRequest(String username, String nome, String cognome, String email) {
        this.username = username;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
    }


}
