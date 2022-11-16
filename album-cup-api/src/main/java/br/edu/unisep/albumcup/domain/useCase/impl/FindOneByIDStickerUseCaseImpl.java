package br.edu.unisep.albumcup.domain.useCase.impl;

import br.edu.unisep.albumcup.data.repository.StickerRepository;
import br.edu.unisep.albumcup.domain.builder.StickerBuilder;
import br.edu.unisep.albumcup.domain.dto.StickersDto;
import br.edu.unisep.albumcup.domain.useCase.FindOneByIDStickerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindOneByIDStickerUseCaseImpl implements FindOneByIDStickerUseCase {
    private final StickerRepository repository;
    private final StickerBuilder stickerBuilder;

    @Override
    public StickersDto execute(Integer id) {
        var result = repository.findByID(id);
        if (result != null) {
            return stickerBuilder.build(result);
        }
        return null;
    }
}
