package br.com.encurtathor.encurtador.service;

import br.com.encurtathor.encurtador.dto.UserPostBody;
import br.com.encurtathor.encurtador.entity.User;
import br.com.encurtathor.encurtador.exception.BadRequestException;
import br.com.encurtathor.encurtador.mapper.UserMapper;
import br.com.encurtathor.encurtador.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User findByIdOrThrowBadRequestException(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("User do not Exist, try it"));
    }

    public Optional<User> createUser(UserPostBody userPostBody) {
        return Optional.ofNullable(userRepository.save(UserMapper.INSTANCE.toUser(userPostBody)));
    }
}