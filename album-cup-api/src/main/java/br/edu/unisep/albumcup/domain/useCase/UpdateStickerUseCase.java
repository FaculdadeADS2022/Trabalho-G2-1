package br.edu.unisep.albumcup.domain.useCase;

import br.edu.unisep.albumcup.data.entity.Sticker;
import br.edu.unisep.albumcup.domain.dto.StickersDto;

public interface UpdateStickerUseCase {
    StickersDto execute(Sticker stickerData, Integer id);
}
