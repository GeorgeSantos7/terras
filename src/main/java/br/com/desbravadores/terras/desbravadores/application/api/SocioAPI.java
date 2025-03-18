package br.com.desbravadores.terras.desbravadores.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "v1/dbv")
public interface SocioAPI {
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	SocioResponse criaSocio(@RequestBody @Valid SocioRequest novoSocio);
}