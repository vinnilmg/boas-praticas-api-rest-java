package br.com.vinnilmg.adopet.api.repository;

import br.com.vinnilmg.adopet.api.model.Adocao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdocaoRepository extends JpaRepository<Adocao, Long> {

}
