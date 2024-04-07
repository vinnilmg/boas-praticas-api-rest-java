package br.com.vinnilmg.adopet.api.dto.abrigo.response;

import br.com.vinnilmg.adopet.api.model.Abrigo;

public record AbrigoDto(
        String nome,
        String telefone,
        String email
) {
    public AbrigoDto(Abrigo abrigo) {
        this(abrigo.getNome(), abrigo.getTelefone(), abrigo.getEmail());
    }
}
