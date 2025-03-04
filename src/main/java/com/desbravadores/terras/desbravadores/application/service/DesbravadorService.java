package com.desbravadores.terras.desbravadores.application.service;

import com.desbravadores.terras.desbravadores.application.api.DesbravadorRequest;
import com.desbravadores.terras.desbravadores.application.api.DesbravadorResponse;

public interface DesbravadorService {

	DesbravadorResponse criaNovoDesbravador(DesbravadorRequest novoDesbravador);

}
