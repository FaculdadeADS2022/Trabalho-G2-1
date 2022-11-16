package br.edu.unisep.albumcup.domain.useCase;

import br.edu.unisep.albumcup.domain.dto.CreateStickerDto;

public interface CreateStickerUseCase {
    void execute(CreateStickerDto stickerData);
}
