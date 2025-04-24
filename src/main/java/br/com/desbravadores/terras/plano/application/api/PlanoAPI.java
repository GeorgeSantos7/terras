package br.com.desbravadores.terras.plano.application.api;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "v1/plano")
public interface PlanoAPI {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    PlanoResponse criaPlano(@RequestBody @Valid PlanoRequest novoPlano);

    @GetMapping(value = "/planos")
    @ResponseStatus(code = HttpStatus.OK)
    List<PlanosListResponse> buscaPlanos();
}