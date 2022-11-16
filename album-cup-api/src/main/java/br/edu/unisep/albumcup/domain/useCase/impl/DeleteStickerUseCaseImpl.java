package br.edu.unisep.albumcup.domain.useCase.impl;

import br.edu.unisep.albumcup.data.repository.StickerRepository;
import br.edu.unisep.albumcup.domain.useCase.DeleteStickerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteStickerUseCaseImpl implements DeleteStickerUseCase {

    private final StickerRepository repository;

    public void execute(Integer id) {
        repository.deleteById(id);
    }
}
