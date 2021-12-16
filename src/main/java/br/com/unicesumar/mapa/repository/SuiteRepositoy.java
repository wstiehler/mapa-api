package br.com.unicesumar.mapa.repository;

import br.com.unicesumar.mapa.model.Suite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuiteRepositoy extends JpaRepository<Suite, Long> {

    Suite findByType(String suiteType);
}
