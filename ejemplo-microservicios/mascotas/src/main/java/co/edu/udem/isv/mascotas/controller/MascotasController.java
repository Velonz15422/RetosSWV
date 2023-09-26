package co.edu.udem.isv.mascotas.controller;

import co.edu.udem.isv.mascotas.dto.MascotaDto;
import co.edu.udem.isv.mascotas.service.MascotaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Log4j2
@RestController
@RequestMapping("/api/mascotas")
public class MascotasController {

    private final MascotaService mascotaService;

    public MascotasController(MascotaService mascotaService) {
        this.mascotaService = mascotaService;
    }

    @Operation(summary = "Listar todas las mascotas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Mascotas listadas exitosamente",
                    content = @Content(schema = @Schema(implementation = MascotaDto.class))),
            @ApiResponse(responseCode = "404", description = "Mascotas no encontradas")
    })
    @GetMapping
    public List<MascotaDto> listarMascotas() {
        log.info("Llamado a listar mascotas");
        return mascotaService.listarMascotas();
    }

    @Operation(summary = "Registrar una mascota")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Mascota registrada exitosamente",
                    content = @Content(schema = @Schema(implementation = MascotaDto.class))),
            @ApiResponse(responseCode = "409", description = "Mascota almacenada previamente")
    })
    @PostMapping
    public MascotaDto crearMascota(@RequestBody MascotaDto mascotaDto) {
        return this.mascotaService.crearMascota(mascotaDto);
    }

    @Operation(summary = "Listar mascota por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Mascota listada exitosamente",
                    content = @Content(schema = @Schema(implementation = MascotaDto.class))),
            @ApiResponse(responseCode = "404", description = "Mascota no encontrada")
    })
    @GetMapping("/{id}")
    public MascotaDto listarMascotaPorId(@PathVariable Long id) {
        log.info("Llamado a listar mascota por id: {}", id);
        return mascotaService.listarMascotaPorId(id);
    }

}
