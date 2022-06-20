package br.com.encurtathor.encurtador.service;

import br.com.encurtathor.encurtador.dto.RedirectCreationRequest;
import br.com.encurtathor.encurtador.entity.Redirects;
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

    public Redirects getRedirect(String hash) {
        Redirects redirect = redirectsReposytory.findByHash(hash).orElseThrow(() -> new NotFoundException("Don't have hash, try make do it"));

        return redirect;
    }

    public Optional<Redirects> createRedirect(RedirectCreationRequest redirectCreationRequest) {
        if (redirectsReposytory.existsByHash(redirectCreationRequest.getHash())) {
            throw new BadRequestException("Hash Alredy exists");
        }
        Redirects redirect = Redirects.builder()
                .longUrl(redirectCreationRequest.getLongUrl())
                .hash(redirectCreationRequest.getHash())
                .dateCreated(LocalDate.now())
                .build();

        Redirects postRedirect = redirectsReposytory.save(redirect);

        return Optional.ofNullable(postRedirect);
    }
}