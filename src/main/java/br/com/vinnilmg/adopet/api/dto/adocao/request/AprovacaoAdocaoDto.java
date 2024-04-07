package br.com.vinnilmg.adopet.api.dto.adocao.request;

import jakarta.validation.constraints.NotNull;

public record AprovacaoAdocaoDto(@NotNull Long idAdocao) {
}
