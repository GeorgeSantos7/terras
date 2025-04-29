package br.com.desbravadores.terras.socio.application.api;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping(value = "/public/v1/dbv")
public interface SocioAPI {
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	SocioResponse criaSocio(@RequestBody @Valid SocioRequest novoSocio);

	@GetMapping("/busca-socio-por-id/{idSocio}")
	@ResponseStatus(code = HttpStatus.OK)
	SocioDetalhadoResponse detalhaSocioPorId(@RequestHeader(name = "Authorization", required = true) String token,
											 @PathVariable UUID idSocio);

	@GetMapping("/socios")
	@ResponseStatus(code = HttpStatus.OK)
	List<SocioDetalhadoResponse> listaSocios();

	@PatchMapping("/edita-socio/{idSocio}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void alteraSocioPorId(@RequestHeader(name = "Authorization", required = true) String token,
			@PathVariable UUID idSocio, @RequestBody @Valid SocioAlteraRequest socio);


}