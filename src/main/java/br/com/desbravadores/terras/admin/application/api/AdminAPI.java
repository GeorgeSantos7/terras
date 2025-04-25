package br.com.desbravadores.terras.admin.application.api;

import br.com.desbravadores.terras.plano.application.api.PlanosListResponse;
import br.com.desbravadores.terras.socio.application.api.SocioDetalhadoResponse;
import br.com.desbravadores.terras.socio.application.api.SocioRequest;
import br.com.desbravadores.terras.socio.application.api.SocioResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/admin")
public interface AdminAPI {
    @PostMapping("/socio")
    @ResponseStatus(HttpStatus.CREATED)
    SocioResponse adminCriaSocio(@RequestBody @Valid SocioRequest socioRequest);

    @GetMapping("/socio/{idSocio}")
    @ResponseStatus(HttpStatus.OK)
    SocioDetalhadoResponse adminBuscaSocioPorId(@PathVariable UUID idSocio);

    @GetMapping("/busca-socios")
    @ResponseStatus(code = HttpStatus.OK)
    List<SocioDetalhadoResponse> listaSocios();

    @GetMapping(value = "/planos")
    @ResponseStatus(code = HttpStatus.OK)
    List<PlanosListResponse> buscaPlanos();
}