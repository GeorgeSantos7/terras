package br.com.desbravadores.terras.plano.application.api;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "v1/plano")
public interface PlanoAPI {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    PlanoResponse criaPlano(@RequestBody @Valid PlanoRequest novoPlano);
}