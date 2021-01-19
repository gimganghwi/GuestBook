package com.gimganghwi.guestbook.service;

import com.gimganghwi.guestbook.dto.GuestbookDTO;
import com.gimganghwi.guestbook.dto.PageRequestDTO;
import com.gimganghwi.guestbook.dto.PageResultDTO;
import com.gimganghwi.guestbook.entity.Guestbook;

public interface GuestbookService {

    Long register(GuestbookDTO dto);

    GuestbookDTO read(Long gno);

    PageResultDTO<GuestbookDTO, Guestbook> getList(PageRequestDTO requestDTO);

    default Guestbook dtoToEntity(GuestbookDTO dto){
        Guestbook entity = Guestbook.builder()
        .gno(dto.getGno())
        .title(dto.getTitle())
        .content(dto.getContent())
        .writer(dto.getWriter())
        .build();

        return entity;
    }

    default GuestbookDTO entityToDTO(Guestbook entity){

        GuestbookDTO dto = GuestbookDTO.builder()
                .gno(entity.getGno())
                .title(entity.getTitle())
                .content(entity.getContent())
                .writer(entity.getWriter())
                .regDate(entity.getRegDate())
                .modDate(entity.getModDate())
                .build();

        return dto;
    }
}
