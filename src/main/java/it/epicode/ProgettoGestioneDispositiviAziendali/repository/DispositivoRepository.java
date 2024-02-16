package it.epicode.ProgettoGestioneDispositiviAziendali.repository;


import it.epicode.ProgettoGestioneDispositiviAziendali.model.Dipendente;
import it.epicode.ProgettoGestioneDispositiviAziendali.model.Dispositivo;
import it.epicode.ProgettoGestioneDispositiviAziendali.model.Status;
import it.epicode.ProgettoGestioneDispositiviAziendali.model.Tipo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DispositivoRepository extends JpaRepository<Dispositivo, Long>, PagingAndSortingRepository<Dispositivo, Long> {






}
