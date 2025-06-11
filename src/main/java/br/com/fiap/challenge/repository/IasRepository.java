package br.com.fiap.challenge.repository;

import br.com.fiap.challenge.model.Ias;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IasRepository extends JpaRepository<Ias, UUID> {
}
