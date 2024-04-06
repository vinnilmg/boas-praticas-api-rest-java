package br.com.vinnilmg.adopet.api.repository;

import br.com.vinnilmg.adopet.api.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {

}
