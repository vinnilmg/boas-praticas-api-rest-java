package br.com.vinnilmg.adopet.api.repository;

import br.com.vinnilmg.adopet.api.model.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TutorRepository extends JpaRepository<Tutor, Long> {
    boolean existsByTelefoneOrEmail(String telefone, String email);
}
