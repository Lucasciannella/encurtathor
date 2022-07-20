package br.com.encurtathor.encurtador.mapper;

import br.com.encurtathor.encurtador.dto.UserPostBody;
import br.com.encurtathor.encurtador.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class UserMapper {
    public static final UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    public abstract User toUser (UserPostBody userPostBody);
}