package it.epicode.ProgettoGestioneDispositiviAziendali.controller;

import it.epicode.ProgettoGestioneDispositiviAziendali.model.CustomResponse;
import it.epicode.ProgettoGestioneDispositiviAziendali.model.Dipendente;
import it.epicode.ProgettoGestioneDispositiviAziendali.service.DipendenteService;
import it.epicode.ProgettoGestioneDispositiviAziendali.exception.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.HashMap;


@RestController
@RequestMapping("/dipendenti")
public class DipendenteController  {

    @Autowired
    private DipendenteService dipendenteService;


    @PostMapping("/{id}/upload-image")
    public ResponseEntity<Object> uploadProfileImage(@PathVariable Long id, @RequestParam("file") MultipartFile file) {
        try {
            // Esegui il caricamento dell'immagine e aggiorna il dipendente con l'immagine caricata
            dipendenteService.uploadProfileImage(id, String.valueOf(file));
            return ResponseEntity.ok().body("Immagine del profilo caricata con successo!");
        } catch (NotFoundException e) {
            return ResponseEntity.badRequest().body("Errore durante il caricamento dell'immagine: " + e.getMessage());
        }
    }



//    @PatchMapping("/{id}/upload")
//    public ResponseEntity<CustomResponse> uploadLogo(@PathVariable Long id, @RequestParam("upload") MultipartFile file) {
//        try {
//            String url = dipendenteService.uploadFileAndGetUrl(file);
//            Dipendente dipendente = dipendenteService.uploadProfileImage(url);
//            return CustomResponse.success(HttpStatus.OK.toString(), dipendente, HttpStatus.OK);
//        } catch (IOException e) {
//            return CustomResponse.error(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }





    public ResponseEntity<Dipendente> getDipendenteById(@PathVariable Long id) {

        try {
            return ResponseEntity.ok(dipendenteService.findById(id));
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }

    }




    @GetMapping
    public Page<Dipendente> getAllDipendenti(Pageable pageable) {
          return dipendenteService.findAll( pageable);
    }



    @PostMapping
    public Dipendente createDipendente(@RequestBody Dipendente dipendente) {
        return dipendenteService.save(dipendente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDipendente(@PathVariable Long id) {
        dipendenteService.deleteById(id);
        return ResponseEntity.ok().build();
    }


}

