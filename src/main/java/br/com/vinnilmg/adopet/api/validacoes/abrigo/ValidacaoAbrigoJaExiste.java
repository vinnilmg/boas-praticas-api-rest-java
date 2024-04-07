package br.com.vinnilmg.adopet.api.validacoes.abrigo;

import br.com.vinnilmg.adopet.api.dto.abrigo.request.CadastroAbrigoDto;
import br.com.vinnilmg.adopet.api.exception.ValidacaoException;
import br.com.vinnilmg.adopet.api.repository.AbrigoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacaoAbrigoJaExiste implements ValidacaoCadastroAbrigo {
    @Autowired
    private AbrigoRepository repository;

    public void validar(CadastroAbrigoDto dto) {
        boolean abrigoExiste = repository.existsByNomeOrTelefoneOrEmail(dto.nome(), dto.telefone(), dto.email());
        if (abrigoExiste) {
            throw new ValidacaoException("Dados já cadastrados para outro abrigo!");
        }
    }
}
