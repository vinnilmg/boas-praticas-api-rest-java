package br.com.vinnilmg.adopet.api.validacoes.adocao;

import br.com.vinnilmg.adopet.api.dto.adocao.request.SolicitacaoAdocaoDto;
import br.com.vinnilmg.adopet.api.exception.ValidacaoException;
import br.com.vinnilmg.adopet.api.model.Pet;
import br.com.vinnilmg.adopet.api.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacaoPetDisponivel implements ValidacaoSolicitacaoAdocao {
    @Autowired
    private PetRepository petRepository;

    public void validar(SolicitacaoAdocaoDto dto) {
        Pet pet = petRepository.getReferenceById(dto.idPet());
        if (pet.getAdotado()) {
            throw new ValidacaoException("Pet já foi adotado!");
        }
    }
}
