package br.com.encurtathor.encurtador.service;

import br.com.encurtathor.encurtador.dto.ShortnerPostBody;
import br.com.encurtathor.encurtador.entity.Shortner;
import br.com.encurtathor.encurtador.exception.BadRequestException;
import br.com.encurtathor.encurtador.exception.NotFoundException;
import br.com.encurtathor.encurtador.repository.ShortnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class ShortnerService {

    private final ShortnerRepository redirectsReposytory;

    public Shortner getRedirect(String hash) {
        Shortner redirect = redirectsReposytory.findByHash(hash).orElseThrow(() -> new NotFoundException("Don't have hash, try make do it"));

        return redirect;
    }

    public Shortner createRedirect(ShortnerPostBody shortnerPostBody) {
        if (redirectsReposytory.existsByHash(shortnerPostBody.getHash())) {
            throw new BadRequestException("Hash Alredy exists");
        }
        Shortner shortner = Shortner.builder()
                .hash(shortnerPostBody.getHash())
                .longUrl(shortnerPostBody.getLongUrl())
                .dateCreated(LocalDate.now())
                .build();
        Shortner postRedirect = redirectsReposytory.save(shortner);

        return postRedirect;
    }
}