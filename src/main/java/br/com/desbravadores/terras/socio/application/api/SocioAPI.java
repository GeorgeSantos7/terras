package br.com.desbravadores.terras.socio.application.api;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping(value = "/public/v1/dbv")
public interface SocioAPI {
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	SocioResponse criaSocio(@RequestBody @Valid SocioRequest novoSocio);

	@GetMapping("/socios/{idSocio}")
	@ResponseStatus(HttpStatus.OK)
	SocioDetalhadoResponse detalhaSocioPorId(@PathVariable UUID idSocio);

	@GetMapping("/assinatura/{idSocio}")
	@ResponseStatus(code = HttpStatus.OK)
	AssinaturaResponse buscaAssinaturaDoSocioPorId(@PathVariable UUID idSocio);

}