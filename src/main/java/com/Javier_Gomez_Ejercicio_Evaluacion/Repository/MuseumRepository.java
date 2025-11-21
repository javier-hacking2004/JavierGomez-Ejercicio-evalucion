package com.Javier_Gomez_Ejercicio_Evaluacion.Repository;

import com.Javier_Gomez_Ejercicio_Evaluacion.model.Museum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MuseumRepository extends JpaRepository<Museum, Long> {
}
