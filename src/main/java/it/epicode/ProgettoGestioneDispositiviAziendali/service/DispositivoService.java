package it.epicode.ProgettoGestioneDispositiviAziendali.service;

import it.epicode.ProgettoGestioneDispositiviAziendali.exception.NotFoundException;
import it.epicode.ProgettoGestioneDispositiviAziendali.model.*;
import it.epicode.ProgettoGestioneDispositiviAziendali.repository.DispositivoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DispositivoService {

    @Autowired
    private DispositivoRepository dispositivoRepository;

    @Autowired
    private DipendenteService dipendenteService;



    public Dispositivo findById(Long id)  throws NotFoundException {
        return dispositivoRepository.findById(id).orElseThrow(() -> new NotFoundException("Dispositivo non trovato"));
    }

    public Page<Dispositivo> findAll(Pageable pageable) {
        return dispositivoRepository.findAll(pageable);
    }



    public Dispositivo updateDispositivo(Long id,DispositivoRequest dispositivo) throws NotFoundException {


        Dispositivo dispositivoToUpdate = findById(id);

        dispositivoToUpdate.setStatus(dispositivo.getStatus());
        dispositivoToUpdate.setTipo(dispositivo.getTipo());

        return dispositivoRepository.save(dispositivoToUpdate);
    }


    public Dispositivo save(DispositivoRequest dispositivo) {

        Dispositivo d = new Dispositivo();
      d.setTipo(dispositivo.getTipo());
        d.setStatus(dispositivo.getStatus());

        return dispositivoRepository.save(d);
    }

    public void deleteById(Long id) {
        dispositivoRepository.deleteById(id);
    }

    public Dispositivo connectDispositivo(Long dipendente_id, Long dispositivo_id) throws NotFoundException {

       Dispositivo dispositivo = findById(dispositivo_id);
       if(dispositivo.getStatus() == Status.ASSEGNATO) {
           throw new NotFoundException("Dispositivo non disponibile");
       }
     Dipendente dipendente = dipendenteService.findById(dipendente_id); ;
        dispositivo.setDipendente(dipendente);

        dispositivo.setStatus(Status.ASSEGNATO);

        return dispositivoRepository.save(dispositivo);

    }


}
