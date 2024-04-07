package br.com.vinnilmg.adopet.api.service;

import br.com.vinnilmg.adopet.api.dto.abrigo.request.CadastroAbrigoDto;
import br.com.vinnilmg.adopet.api.dto.abrigo.response.AbrigoDto;
import br.com.vinnilmg.adopet.api.dto.pet.PetDto;
import br.com.vinnilmg.adopet.api.exception.ValidacaoException;
import br.com.vinnilmg.adopet.api.model.Abrigo;
import br.com.vinnilmg.adopet.api.repository.AbrigoRepository;
import br.com.vinnilmg.adopet.api.repository.PetRepository;
import br.com.vinnilmg.adopet.api.validacoes.abrigo.ValidacaoCadastroAbrigo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AbrigoService {
    @Autowired
    private AbrigoRepository repository;

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private List<ValidacaoCadastroAbrigo> validacoes;

    public List<AbrigoDto> listar() {
        return repository.findAll()
                .stream()
                .map(AbrigoDto::new)
                .toList();
    }

    public void cadastrar(CadastroAbrigoDto dto) {
        validacoes.forEach(v -> v.validar(dto));
        repository.save(new Abrigo(dto.nome(), dto.telefone(), dto.email()));
    }

    public List<PetDto> listarPetsDoAbrigo(String idOuNome) {
        Abrigo abrigo = carregarAbrigo(idOuNome);
        return petRepository.findByAbrigo(abrigo)
                .stream()
                .map(PetDto::new)
                .toList();
    }

    public Abrigo carregarAbrigo(String idOuNome) {
        Optional<Abrigo> abrigoOptional;
        try {
            Long id = Long.parseLong(idOuNome);
            abrigoOptional = repository.findById(id);
        } catch (NumberFormatException e) {
            abrigoOptional = repository.findByNome(idOuNome);
        }

        return abrigoOptional.orElseThrow(() -> new ValidacaoException("Abrigo não localizado."));
    }
}
