package br.com.vinnilmg.adopet.api.validacoes.abrigo;

import br.com.vinnilmg.adopet.api.dto.abrigo.request.CadastroAbrigoDto;

public interface ValidacaoCadastroAbrigo {
    void validar(CadastroAbrigoDto dto);
}
