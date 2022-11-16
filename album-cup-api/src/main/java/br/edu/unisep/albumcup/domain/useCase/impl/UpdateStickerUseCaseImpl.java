package br.edu.unisep.albumcup.domain.useCase.impl;

import br.edu.unisep.albumcup.data.entity.Sticker;
import br.edu.unisep.albumcup.data.repository.StickerRepository;
import br.edu.unisep.albumcup.domain.builder.StickerBuilder;
import br.edu.unisep.albumcup.domain.dto.StickersDto;
import br.edu.unisep.albumcup.domain.useCase.UpdateStickerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateStickerUseCaseImpl implements UpdateStickerUseCase {

    private final StickerRepository repository;
    private final StickerBuilder stickerBuilder;

    public StickersDto execute(Sticker sticker, Integer id) {

        //Busca o sticker para ser alterado pelo ID recebido por parâmetro.
        var stickerUpdate = repository.findByID(id);

        //Atribui os novos valores para o sticker encontrado pelo ID.
        if (sticker.getBirthday() != null) {
            stickerUpdate.setBirthday(sticker.getBirthday());
        }
        if (sticker.getHeight() != null) {
            stickerUpdate.setHeight(sticker.getHeight());
        }
        if (sticker.getWeight() != null) {
            stickerUpdate.setPlayer(sticker.getPlayer());
        }
        if (sticker.getCountry() != null) {
            stickerUpdate.setCountry(sticker.getCountry());
        }
        if (sticker.getWeight() != null) {
            stickerUpdate.setWeight(sticker.getWeight());
        }

        stickerUpdate.setLegendary(sticker.isLegendary());

        //Monta o DTO para ser salvo.
        stickerBuilder.build(stickerUpdate);

        //Salva o Sticker com os novos valores.
        repository.save(stickerUpdate);

        return stickerBuilder.build(stickerUpdate);
    }
}
