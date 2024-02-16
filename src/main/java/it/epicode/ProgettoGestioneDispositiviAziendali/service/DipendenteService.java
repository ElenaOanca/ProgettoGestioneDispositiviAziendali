package it.epicode.ProgettoGestioneDispositiviAziendali.service;


import it.epicode.ProgettoGestioneDispositiviAziendali.exception.NotFoundException;
import it.epicode.ProgettoGestioneDispositiviAziendali.model.CustomResponse;
import it.epicode.ProgettoGestioneDispositiviAziendali.model.Dipendente;
import it.epicode.ProgettoGestioneDispositiviAziendali.repository.DipendenteRepository;

import it.epicode.ProgettoGestioneDispositiviAziendali.repository.DispositivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@Service
public class DipendenteService {

    @Autowired
    private DipendenteRepository dipendenteRepository;

    @Autowired
    private DispositivoRepository dispositivoRepository;

    public void uploadProfileImage(Long id, String image) throws NotFoundException {
        Dipendente dipendente = dipendenteRepository.findById(id).orElse(null);
        if (dipendente != null) {
            dipendente.setProfileImage(image.getBytes());
            dipendenteRepository.save(dipendente);
        } else {
            throw new NotFoundException("Dipendente non trovato");
        }
    }

    public Page<Dipendente> findAll(Pageable pageable) {
        return dipendenteRepository.findAll(pageable);


    }

    public Dipendente findById(long ID) throws NotFoundException {
        return dipendenteRepository.findById(ID).orElseThrow(() -> new NotFoundException("Dipendente non trovato"));
    }


    public Dipendente updateDipendente(Dipendente dipendente) throws NotFoundException {
        Dipendente dipendenteDaAggiornare = this.findById(dipendente.getId());
        if (dipendenteDaAggiornare == null) {
            throw new NotFoundException("Dipendente non trovato");
        }
        dipendenteDaAggiornare.setNome(dipendente.getNome());
        dipendenteDaAggiornare.setCognome(dipendente.getCognome());
        dipendenteDaAggiornare.setEmail(dipendente.getEmail());
        dipendenteDaAggiornare.setUsername(dipendente.getUsername());

        return dipendenteRepository.save(dipendenteDaAggiornare);
    }


    public void deleteById(long id) {
        dipendenteRepository.deleteById(id);
    }


    public Dipendente save(Dipendente dipendente) {
        dipendente.setNome(dipendente.getNome());
        dipendente.setCognome(dipendente.getCognome());
        dipendente.setEmail(dipendente.getEmail());
        dipendente.setUsername(dipendente.getUsername());
        return dipendenteRepository.save(dipendente);
    }


//    public Dipendente uploadProfileImage(int id, String url) throws NotFoundException{
//       Dipendente dipendente = dipendenteRepository.getDipendenteById(id);
//
//        dipendente.setProfileImage(url.getBytes());
//        return dipendenteRepository.save(dipendente);
//    }


    public String uploadFileAndGetUrl(MultipartFile file) {
        try {
            // Definisci il percorso in cui desideri salvare il file
            Path path = Paths.get("uploads/" + file.getOriginalFilename());

            // Salva il file nel percorso specificato
            Files.write(path, file.getBytes());

            // Restituisci il percorso del file come stringa
            return path.toString();
        } catch (IOException e) {
            throw new RuntimeException("Errore durante il caricamento del file", e);
        }
    }


}
