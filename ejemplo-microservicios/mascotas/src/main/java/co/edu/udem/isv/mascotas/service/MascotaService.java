package co.edu.udem.isv.mascotas.service;

import co.edu.udem.isv.mascotas.dto.MascotaDto;
import co.edu.udem.isv.mascotas.exception.DatosNoEncontradosException;
import co.edu.udem.isv.mascotas.mapper.MascotaMapper;
import co.edu.udem.isv.mascotas.model.Mascota;
import co.edu.udem.isv.mascotas.repository.MascotasRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MascotaService {

    private final MascotasRepository mascotasRepository;
    private final MascotaMapper mascotaMapper;


    public MascotaService(MascotasRepository mascotasRepository, MascotaMapper mascotaMapper) {
        this.mascotasRepository = mascotasRepository;
        this.mascotaMapper = mascotaMapper;
    }

    public List<MascotaDto> listarMascotas() {
        return this.mascotaMapper.aDto(mascotasRepository.findAll());
    }

    public MascotaDto crearMascota(MascotaDto mascotaDto) {

        return mascotaMapper.aDto(
                mascotasRepository.save(
                        mascotaMapper.aEntidad(mascotaDto)));
    }

    public MascotaDto listarMascotaPorId(Long id) {
        Optional<Mascota> resultado = mascotasRepository.findById(id);
        if(resultado.isPresent()){
            return mascotaMapper.aDto(resultado.get());
        }
        throw new DatosNoEncontradosException(String.format("No se encuentra la mascota con id:  %d", id));
    }
}
