package br.com.vinnilmg.adopet.api.validacoes.adocao;

import br.com.vinnilmg.adopet.api.dto.adocao.request.SolicitacaoAdocaoDto;
import br.com.vinnilmg.adopet.api.exception.ValidacaoException;
import br.com.vinnilmg.adopet.api.model.Adocao;
import br.com.vinnilmg.adopet.api.model.StatusAdocao;
import br.com.vinnilmg.adopet.api.model.Tutor;
import br.com.vinnilmg.adopet.api.repository.AdocaoRepository;
import br.com.vinnilmg.adopet.api.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ValidacaoTutorComAdocaoEmAndamento implements ValidacaoSolicitacaoAdocao {
    @Autowired
    private AdocaoRepository adocaoRepository;

    @Autowired
    private TutorRepository tutorRepository;

    public void validar(SolicitacaoAdocaoDto dto) {
        List<Adocao> adocoes = adocaoRepository.findAll();
        Tutor tutor = tutorRepository.getReferenceById(dto.idTutor());
        for (Adocao a : adocoes) {
            if (a.getTutor() == tutor && a.getStatus() == StatusAdocao.AGUARDANDO_AVALIACAO) {
                throw new ValidacaoException("Tutor já possui outra adoção aguardando avaliação!");
            }
        }
    }
}
