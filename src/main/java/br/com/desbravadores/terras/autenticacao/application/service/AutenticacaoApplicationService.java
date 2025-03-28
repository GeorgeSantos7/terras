package br.com.desbravadores.terras.autenticacao.application.service;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import br.com.desbravadores.terras.autenticacao.domain.Token;


public interface AutenticacaoApplicationService {
    Token autentica(UsernamePasswordAuthenticationToken userCredentials);
    Token reativaToken(String tokenExpirado);
}
