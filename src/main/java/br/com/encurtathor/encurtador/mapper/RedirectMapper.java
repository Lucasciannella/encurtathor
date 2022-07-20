package br.com.encurtathor.encurtador.mapper;

import br.com.encurtathor.encurtador.dto.ShortnerPostBody;
import br.com.encurtathor.encurtador.entity.Shortner;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class RedirectMapper {
    public static final RedirectMapper INSTANCE = Mappers.getMapper(RedirectMapper.class);

    public abstract Shortner toShortner(ShortnerPostBody shortnerPostBody);


}
