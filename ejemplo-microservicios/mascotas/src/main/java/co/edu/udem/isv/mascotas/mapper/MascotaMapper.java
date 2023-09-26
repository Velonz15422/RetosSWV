package co.edu.udem.isv.mascotas.mapper;

import co.edu.udem.isv.mascotas.dto.MascotaDto;
import co.edu.udem.isv.mascotas.model.Mascota;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MascotaMapper extends MapperBase<MascotaDto, Mascota> {

}
