package it.epicode.ProgettoGestioneDispositiviAziendali.repository;

import it.epicode.ProgettoGestioneDispositiviAziendali.model.Dipendente;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DipendenteRepository extends JpaRepository<Dipendente, Long>, PagingAndSortingRepository<Dipendente, Long> {
    Dipendente getDipendenteById(int id);


//    @Query("SELECT d FROM Dipendente d WHERE d.cognome = :cognome")
//    List<Dipendente> findByCognome(@Param("cognome") String cognome);
//
//    @Query(value = "SELECT * FROM dipendente WHERE email = :email", nativeQuery = true)
//    Dipendente findByEmail(@Param("email") String email);
}