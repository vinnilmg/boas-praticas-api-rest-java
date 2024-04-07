package br.com.vinnilmg.adopet.api.controller;

import br.com.vinnilmg.adopet.api.dto.pet.PetDto;
import br.com.vinnilmg.adopet.api.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {
    @Autowired
    private PetService petService;

    @GetMapping
    public ResponseEntity<List<PetDto>> listarTodosDisponiveis() {
        List<PetDto> petsDisponiveis = petService.listarTodosDisponiveis();
        return ResponseEntity.ok(petsDisponiveis);
    }
}
