package br.edu.unisep.albumcup.domain.useCase.impl;

import br.edu.unisep.albumcup.data.repository.StickerRepository;
import br.edu.unisep.albumcup.domain.builder.StickerBuilder;
import br.edu.unisep.albumcup.domain.dto.StickersDto;
import br.edu.unisep.albumcup.domain.useCase.FindAllStickersUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindAllStickersUseCaseImpl implements FindAllStickersUseCase {

    private final StickerRepository repository;
    private final StickerBuilder stickerBuilder;
    @Override
    public List<StickersDto> execute() {
        var result = repository.findAll();
            return stickerBuilder.build(result);
    }
}
