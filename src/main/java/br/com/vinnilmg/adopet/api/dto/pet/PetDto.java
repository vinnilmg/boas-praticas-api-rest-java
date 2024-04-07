package br.com.vinnilmg.adopet.api.dto.pet;

import br.com.vinnilmg.adopet.api.model.Pet;
import br.com.vinnilmg.adopet.api.model.TipoPet;

public record PetDto(Long id, TipoPet tipo, String nome, String raca, Integer idade) {
    public PetDto(Pet pet) {
        this(pet.getId(), pet.getTipo(), pet.getNome(), pet.getRaca(), pet.getIdade());
    }
}
