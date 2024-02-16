package it.epicode.ProgettoGestioneDispositiviAziendali.model;

import jakarta.persistence.*;





@Entity
public class Dispositivo {



  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private Tipo tipo;

  @Column(nullable = false)
  @Enumerated(EnumType.STRING)
  private Status status;

  @ManyToOne
  @JoinColumn(name = "dipendente_id")
  private Dipendente dipendente;

  // Costruttore vuoto
  public Dispositivo() {}

  // Costruttore con parametri
  public Dispositivo(Tipo tipo, Status status, Dipendente dipendente) {

    this.tipo = tipo;
    this.status = status;
    this.dipendente = dipendente;
  }

  // Getter e Setter
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Tipo getTipo() {
    return tipo;
  }

  public void setTipo(Tipo tipo) {
    this.tipo = tipo;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public Dipendente getDipendente() {
    return dipendente;
  }

  public void setDipendente(Dipendente dipendente) {
    this.dipendente = dipendente;
  }

  @Override
  public String toString() {
    return "Dispositivo{" +
            "id=" + id +
            ", tipo=" + tipo +
            ", status=" + status +
            ", dipendente=" + dipendente +
            '}';
  }
}

