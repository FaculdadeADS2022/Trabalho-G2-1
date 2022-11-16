package br.edu.unisep.albumcup.domain.useCase;

import br.edu.unisep.albumcup.domain.dto.StickerByIDDto;
import br.edu.unisep.albumcup.domain.dto.StickersDto;

import java.util.List;

public interface FindOneByIDStickerUseCase {
    StickersDto execute(Integer id);
}
