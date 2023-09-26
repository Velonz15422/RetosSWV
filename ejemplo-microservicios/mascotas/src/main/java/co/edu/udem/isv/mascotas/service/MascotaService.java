package co.edu.udem.isv.mascotas.service;

import co.edu.udem.isv.mascotas.dto.MascotaDto;
import co.edu.udem.isv.mascotas.mapper.MascotaMapper;
import co.edu.udem.isv.mascotas.model.Mascota;
import co.edu.udem.isv.mascotas.repository.MascotasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
