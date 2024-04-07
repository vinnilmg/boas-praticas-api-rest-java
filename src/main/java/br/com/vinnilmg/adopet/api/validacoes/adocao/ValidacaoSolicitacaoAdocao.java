package br.com.vinnilmg.adopet.api.validacoes.adocao;

import br.com.vinnilmg.adopet.api.dto.adocao.request.SolicitacaoAdocaoDto;

public interface ValidacaoSolicitacaoAdocao {
    void validar(SolicitacaoAdocaoDto dto);
}
