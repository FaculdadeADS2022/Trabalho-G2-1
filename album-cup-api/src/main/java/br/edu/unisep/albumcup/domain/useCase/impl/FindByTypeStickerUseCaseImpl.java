package br.edu.unisep.albumcup.domain.useCase.impl;

import br.edu.unisep.albumcup.data.repository.StickerRepository;
import br.edu.unisep.albumcup.domain.builder.StickerBuilder;
import br.edu.unisep.albumcup.domain.dto.StickersDto;
import br.edu.unisep.albumcup.domain.useCase.FindByTypeStickerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FindByTypeStickerUseCaseImpl implements FindByTypeStickerUseCase {
    private final StickerRepository repository;
    private final StickerBuilder stickerBuilder;
    @Override
    public List<StickersDto> execute(String country) {
        var result = repository.findByCountry(country);
        return stickerBuilder.build(result);
    }
}
