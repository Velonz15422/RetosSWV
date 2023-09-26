package co.edu.udem.isv.mascotas.mapper;

import java.util.List;
import java.util.Set;

public interface MapperBase<D, E> {

    E aEntidad(D dto);

    D aDto(E entidad);

    List<E> aEntidad(List<D> dtos);

    List<D> aDto(List<E> entidades);

    Set<E> aEntidad(Set<D> dtos);

    Set<D> aDto(Set<E> entidades);
}
