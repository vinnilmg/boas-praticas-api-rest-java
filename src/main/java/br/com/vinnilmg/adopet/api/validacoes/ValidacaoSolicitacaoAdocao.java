package br.com.vinnilmg.adopet.api.validacoes;

import br.com.vinnilmg.adopet.api.dto.SolicitacaoAdocaoDto;

public interface ValidacaoSolicitacaoAdocao {
    void validar(SolicitacaoAdocaoDto dto);
}
