package br.edu.unisep.albumcup.domain.builder.impl;

import br.edu.unisep.albumcup.data.entity.Sticker;
import br.edu.unisep.albumcup.domain.builder.StickerBuilder;
import br.edu.unisep.albumcup.domain.dto.CreateStickerDto;
import br.edu.unisep.albumcup.domain.dto.StickersDto;
import br.edu.unisep.albumcup.domain.dto.UpdateStickerDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StickerBuilderImpl implements StickerBuilder {

    @Override
    public Sticker build(CreateStickerDto stickerData) {
        var sticker = new Sticker();
        sticker.setPlayer(stickerData.getPlayer());
        sticker.setCountry(stickerData.getCountry());
        sticker.setHeight(stickerData.getHeight());
        sticker.setWeight(stickerData.getWeight());
        sticker.setBirthday(stickerData.getBirthday());
        sticker.setLegendary(stickerData.isLegendary());

        return sticker;
    }

    @Override
    public StickersDto build(Sticker sticker) {
        var dto = new StickersDto();
        dto.setId(sticker.getId());
        dto.setPlayer(sticker.getPlayer());
        dto.setCountry(sticker.getCountry());
        dto.setHeight(sticker.getHeight());
        dto.setWeight(sticker.getWeight());
        dto.setBirthday(sticker.getBirthday());
        dto.setLegendary(sticker.isLegendary());

        return dto;
    }

    @Override
    public List<StickersDto> build(List<Sticker> stickers) {
        return stickers.stream().map(this::build).toList();
    }

    @Override
    public UpdateStickerDto build(UpdateStickerDto sticker) {
        var dto = new UpdateStickerDto();
        dto.setPlayer(sticker.getPlayer());
        dto.setCountry(sticker.getCountry());
        dto.setHeight(sticker.getHeight());
        dto.setWeight(sticker.getWeight());
        dto.setBirthday(sticker.getBirthday());
        dto.setLegendary(sticker.isLegendary());

        return dto;
    }

}
