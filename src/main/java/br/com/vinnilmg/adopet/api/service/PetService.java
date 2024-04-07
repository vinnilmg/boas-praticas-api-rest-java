package br.com.vinnilmg.adopet.api.service;

import br.com.vinnilmg.adopet.api.dto.abrigo.request.CadastroPetDto;
import br.com.vinnilmg.adopet.api.dto.pet.PetDto;
import br.com.vinnilmg.adopet.api.model.Abrigo;
import br.com.vinnilmg.adopet.api.model.Pet;
import br.com.vinnilmg.adopet.api.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {
    @Autowired
    private PetRepository repository;

    public List<PetDto> listarTodosDisponiveis() {
        return repository.findAllByAdotadoFalse()
                .stream()
                .map(PetDto::new)
                .toList();
    }

    public void cadastrarPet(Abrigo abrigo, CadastroPetDto dto) {
        repository.save(new Pet(dto, abrigo));
    }
}
