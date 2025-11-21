package com.Javier_Gomez_Ejercicio_Evaluacion.Service;

import com.Javier_Gomez_Ejercicio_Evaluacion.DTO.MuseumRequestDto;
import com.Javier_Gomez_Ejercicio_Evaluacion.Repository.MuseumRepository;
import com.Javier_Gomez_Ejercicio_Evaluacion.error.InvalidMuseumDataException;
import com.Javier_Gomez_Ejercicio_Evaluacion.error.MuseumNotFoundException;
import com.Javier_Gomez_Ejercicio_Evaluacion.model.Museum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MuseumService {

    private final MuseumRepository museumRepository;

    public List<Museum> getAll(){
        List<Museum> museums = museumRepository.findAll();
        
        if(museums.isEmpty()) {
            throw new MuseumNotFoundException();
        }
        
        return museums;
    }

    public Museum getById(Long id){
        return museumRepository.findById(id)
                .orElseThrow(() -> new MuseumNotFoundException(id));
    }

    public Museum edit(Long id, MuseumRequestDto dto){
        if(!StringUtils.hasText(dto.nombreMuseo())) {
            throw new InvalidMuseumDataException();
        }

        Museum museum = museumRepository.findById(id)
                .orElseThrow(() -> new MuseumNotFoundException(id));
        
        museum.setNombreMuseo(dto.nombreMuseo());
        museum.setCiudad(dto.ciudad());
        museum.setAnioAperturta(dto.anioAperturta());
        museum.setNSalas(dto.nSalas());
        museum.setDescripcion(dto.descripcion());
        museum.setUrl(dto.url());

        return museumRepository.save(museum);
    }

    public Museum create(MuseumRequestDto dto){
        if(!StringUtils.hasText(dto.nombreMuseo())) {
            throw new InvalidMuseumDataException();
        }

        return museumRepository.save(dto.toEntity());
    }

    public void delete(Long id){
        if(!museumRepository.existsById(id)) {
            throw new MuseumNotFoundException(id);
        }
        museumRepository.deleteById(id);
    }
}
