package it.epicode.ProgettoGestioneDispositiviAziendali.controller;


import it.epicode.ProgettoGestioneDispositiviAziendali.model.Dispositivo;
import it.epicode.ProgettoGestioneDispositiviAziendali.model.DispositivoRequest;
import it.epicode.ProgettoGestioneDispositiviAziendali.model.Status;
import it.epicode.ProgettoGestioneDispositiviAziendali.model.Tipo;
import it.epicode.ProgettoGestioneDispositiviAziendali.service.DispositivoService;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;


import java.util.List;


import java.time.LocalDate;

import java.util.Optional;


@RestController
@RequestMapping("/dispositivi")
public class DispositivoController {

    @Autowired
    private DispositivoService dispositivoService;

    @GetMapping
    public ResponseEntity getAllDispositivi(Pageable pageable) {

       try {
           return ResponseEntity.ok(dispositivoService.findAll(pageable));
       } catch (Exception e) {
           return ResponseEntity.badRequest().body(e.getMessage());
       }
    }

    @PostMapping
    public ResponseEntity createDispositivo(@RequestBody DispositivoRequest dispositivo) {
          try {
                return ResponseEntity.ok(dispositivoService.save(dispositivo));
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(e.getMessage());
            }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDispositivo(@PathVariable Long id) {
        dispositivoService.deleteById(id);
        return ResponseEntity.ok().build();
    }


    @PostMapping("/{id}/connect/{dipendente_id}")
    public ResponseEntity connectDispositivo(@PathVariable Long id, @PathVariable Long dipendente_id) {
        try {
            return ResponseEntity.ok(dispositivoService.connectDispositivo(dipendente_id, id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }



}