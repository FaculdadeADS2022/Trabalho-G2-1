package br.edu.unisep.albumcup.domain.builder;

import br.edu.unisep.albumcup.data.entity.Sticker;
import br.edu.unisep.albumcup.domain.dto.CreateStickerDto;
import br.edu.unisep.albumcup.domain.dto.StickersDto;
import br.edu.unisep.albumcup.domain.dto.UpdateStickerDto;

import java.util.List;

public interface StickerBuilder {
    Sticker build(CreateStickerDto dto);
    StickersDto build(Sticker sticker);
    List<StickersDto> build(List<Sticker> sticker);
    UpdateStickerDto build(UpdateStickerDto sticker);

}
