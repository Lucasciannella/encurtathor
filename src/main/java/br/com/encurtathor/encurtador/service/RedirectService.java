package br.com.encurtathor.encurtador.service;

import br.com.encurtathor.encurtador.dto.ShortnerPostBody;
import br.com.encurtathor.encurtador.entity.Shortner;
import br.com.encurtathor.encurtador.exception.BadRequestException;
import br.com.encurtathor.encurtador.exception.NotFoundException;
import br.com.encurtathor.encurtador.repository.RedirectsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RedirectService {

    private final RedirectsRepository redirectsReposytory;

    public Shortner getRedirect(String hash) {
        Shortner redirect = redirectsReposytory.findByHash(hash).orElseThrow(() -> new NotFoundException("Don't have hash, try make do it"));

        return redirect;
    }

    public Optional<Shortner> createRedirect(ShortnerPostBody shortnerPostBody) {
        if (redirectsReposytory.existsByHash(shortnerPostBody.getHash())) {
            throw new BadRequestException("Hash Alredy exists");
        }
        Shortner shortner = Shortner.builder()
                .hash(shortnerPostBody.getHash())
                .longUrl(shortnerPostBody.getLongUrl())
                .dateCreated(LocalDate.now())
                .build();
        Shortner postRedirect = redirectsReposytory.save(shortner);

        return Optional.ofNullable(postRedirect);
    }
}