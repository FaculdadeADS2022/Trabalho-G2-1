package br.edu.unisep.albumcup.domain.dto;

import lombok.Data;

import java.time.LocalDate;
@Data
public class UpdateStickerDto {
    private String player;
    private String country;

    private Double weight;
    private Double height;

    private LocalDate birthday;
    private boolean legendary;
}
