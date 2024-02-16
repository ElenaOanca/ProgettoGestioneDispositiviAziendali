package it.epicode.ProgettoGestioneDispositiviAziendali.model;

import jakarta.persistence.*;

import lombok.Data;

import lombok.AllArgsConstructor;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NamedQuery(name = "Dipendente.findByNome",
        query = "SELECT d FROM Dipendente d WHERE d.nome = :nome")
public class Dipendente {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private byte[] profileImage;
    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cognome;

    @Column(nullable = false, unique = true)
    private String email;

    @OneToMany(mappedBy = "dipendente")
    private List<Dispositivo> dispositivi;

    public Dipendente() {
    }

    public Dipendente(String username, String nome, String cognome, String email, byte[] profileImage) {
        this.username = username;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.profileImage = profileImage;
    }

    public byte[] getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(byte[] profileImage) {
        this.profileImage = profileImage;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    @Override
    public String toString() {
        return "Dipendente{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }


}
