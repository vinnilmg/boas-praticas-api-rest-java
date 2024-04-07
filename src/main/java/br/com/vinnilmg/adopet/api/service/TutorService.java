package br.com.vinnilmg.adopet.api.service;

import br.com.vinnilmg.adopet.api.dto.tutor.AtualizacaoTutorDto;
import br.com.vinnilmg.adopet.api.dto.tutor.CadastroTutorDto;
import br.com.vinnilmg.adopet.api.exception.ValidacaoException;
import br.com.vinnilmg.adopet.api.model.Tutor;
import br.com.vinnilmg.adopet.api.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TutorService {
    @Autowired
    private TutorRepository repository;

    public void cadastrar(CadastroTutorDto dto) {
        boolean tutorJaExiste = repository.existsByTelefoneOrEmail(dto.telefone(), dto.email());

        if (tutorJaExiste) {
            throw new ValidacaoException("Dados já cadastrados para outro tutor!");
        }

        repository.save(new Tutor(dto.nome(), dto.telefone(), dto.email()));
    }

    public void atualizar(AtualizacaoTutorDto dto) {
        Tutor tutor = repository.getReferenceById(dto.id());
        tutor.atualizarDados(dto);
    }
}
