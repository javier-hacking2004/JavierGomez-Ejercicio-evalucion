package com.Javier_Gomez_Ejercicio_Evaluacion.Controller;

import com.Javier_Gomez_Ejercicio_Evaluacion.DTO.MuseumRequestDto;
import com.Javier_Gomez_Ejercicio_Evaluacion.DTO.MuseumResponseDto;
import com.Javier_Gomez_Ejercicio_Evaluacion.Service.MuseumService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Tag(name = "Museum", description = "Documentación de los endpoints de la Api")
public class MuseumController {

    private final MuseumService museumService;

    @Operation(summary = "Obtener todos los museos")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Museos recibidos correctamente",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = MuseumResponseDto.class),
                            examples = @ExampleObject(
                                    value = """
                                            [
                                                {
                                                    "id": 1,
                                                    "nombreMuseo": "Museo del Prado",
                                                    "ciudad": "Madrid",
                                                    "anioAperturta": 1819,
                                                    "nSalas": 60,
                                                    "descripcion": "Uno de los museos más importantes del mundo",
                                                    "url": "https://www.museodelprado.es"
                                                }
                                            ]
                                            """
                            )
                    )),
            @ApiResponse(responseCode = "404", description = "Error al recibir los museos",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ProblemDetail.class),
                            examples = @ExampleObject(
                                    value = """
                                            {
                                                
                                            }
                                            """
                            )
                    )
            )
    })
    @GetMapping("/museums")
    public List<MuseumResponseDto> getAll(){
        return museumService.getAll().stream().map(MuseumResponseDto::of).toList();
    }

    @Operation(summary = "Obtener un museo por su identificador")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Museo recibido correctamente",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = MuseumResponseDto.class),
                            examples = @ExampleObject(
                                    value = """
                                        
                                            {
                                                
                                            }
                                        
                                        """
                            )
                    )),
            @ApiResponse(responseCode = "404", description = "Error al recibir el museo",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ProblemDetail.class),
                            examples = @ExampleObject(
                                    value = """
                                                {
                                                    
                                                }
                                                """
                            )
                    )
            )
    })
    @GetMapping("/museums/{id}")
    public MuseumResponseDto getById(
            @Parameter(description = "Identificador del museo", example = "1")
            @PathVariable Long id){
        return MuseumResponseDto.of(museumService.getById(id));
    }

    @Operation(summary = "Editar un museo")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Museo editado correctamente",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = MuseumResponseDto.class),
                            examples = @ExampleObject(
                                    value = """
                                     
                                            {
                                                
                                            }
                                       
                                        """
                            )
                    )),
            @ApiResponse(responseCode = "404", description = "Error al recibir el museo",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ProblemDetail.class),
                            examples = @ExampleObject(
                                    value = """
                                                {
                                                    
                                                }
                                                """
                            )
                    )
            ),
            @ApiResponse(responseCode = "400", description = "Error al editar el museo",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ProblemDetail.class),
                            examples = @ExampleObject(
                                    value = """
                                                {
                                                    
                                                }
                                                """
                            )
                    )
            )
    })
    @PutMapping("/museums/{id}")
    public ResponseEntity<MuseumResponseDto> edit(
            @Parameter(description = "Identificador del museo", example = "1")
            @PathVariable Long id,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Datos del museo",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = MuseumRequestDto.class),
                            examples = @ExampleObject(
                                    value = """
                                                {
                                                
                                                }
                                                
                                                """
                            )
                    )
            )
            @RequestBody MuseumRequestDto dto){
        return ResponseEntity.ok(MuseumResponseDto.of(museumService.edit(id, dto)));
    }
}