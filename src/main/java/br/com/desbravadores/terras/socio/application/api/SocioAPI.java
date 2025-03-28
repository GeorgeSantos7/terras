package br.com.desbravadores.terras.socio.application.api;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value = "/public/v1/dbv")
public interface SocioAPI {
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	SocioResponse criaSocio(@RequestBody @Valid SocioRequest novoSocio);
}