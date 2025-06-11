package br.com.fiap.challenge.DTO;

import br.com.fiap.challenge.model.Ias;

import java.util.UUID;

public record IasResponseDTO(UUID id, String nome, String tipo, String descricao) {
    public IasResponseDTO(Ias ias) {
        this(ias.getId(), ias.getNome(), ias.getTipo(), ias.getDescricao());
    }
}
