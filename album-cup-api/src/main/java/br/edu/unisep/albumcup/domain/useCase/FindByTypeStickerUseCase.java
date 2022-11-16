package br.edu.unisep.albumcup.domain.useCase;

import br.edu.unisep.albumcup.domain.dto.StickersDto;

import java.util.List;

public interface FindByTypeStickerUseCase {
    List<StickersDto> execute(String country);
}
