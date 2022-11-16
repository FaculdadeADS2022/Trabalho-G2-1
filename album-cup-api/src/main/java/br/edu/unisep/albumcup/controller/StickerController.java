package br.edu.unisep.albumcup.controller;

import br.edu.unisep.albumcup.data.entity.Sticker;
import br.edu.unisep.albumcup.domain.dto.CreateStickerDto;
import br.edu.unisep.albumcup.domain.dto.StickersDto;
import br.edu.unisep.albumcup.domain.useCase.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sticker")
@RequiredArgsConstructor
public class StickerController {
    private final CreateStickerUseCase createStickerUseCase;
    private final FindAllStickersUseCase FindAllStickersUseCase;
    private final UpdateStickerUseCase updateStickerUseCase;
    private final DeleteStickerUseCase deleteStickerUseCase;
    private final FindByTypeStickerUseCase findByTypeStickerUseCase;
    private final FindOneByIDStickerUseCase findOneByIDStickerUseCase;

    @PostMapping()
    public ResponseEntity<?> save(@RequestBody CreateStickerDto stickerData) {
        createStickerUseCase.execute(stickerData);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping()
    public ResponseEntity<List<StickersDto>> findAll() {
        var result = FindAllStickersUseCase.execute();

        if (result.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{country}")
    public ResponseEntity<List<StickersDto>> findAllByCountry(@PathVariable String country){
        var result = findByTypeStickerUseCase.execute(country);

        if (result.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Sticker stickerData) {
       var result = updateStickerUseCase.execute(stickerData, id);
       if (result != null){
           return ResponseEntity.ok(result);
       }
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        deleteStickerUseCase.execute(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/one/{id}")
    public ResponseEntity<StickersDto> findOne(@PathVariable Integer id){
        var result = findOneByIDStickerUseCase.execute(id);

        if (result != null) {
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.noContent().build();
    }
}
