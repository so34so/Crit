package com.ssafy.crit.boards.service.dto;

import com.ssafy.crit.boards.entity.board.Board;
import com.ssafy.crit.boards.entity.feeds.UploadFile;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * author : 강민승
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardResponseDto {
    private Long id;
    private String title;
    private String content;
    private int views;
    private String writer;
    private String classification;
    private LocalDateTime createTime;
    private LocalDateTime modifyTime;
    private List<String> liked;
    private List<Long> fileId;
    private List<String> imageFiles;


    @Builder
    public static BoardResponseDto toDto(Board board) {

        List<String> filenames = board.getUploadFiles().stream()
            .map(UploadFile::getStoreFilePath)
            .collect(Collectors.toList());

        List<String> likedName = board.getLikes().stream()
            .map(like -> like.getUser().getNickname())
            .collect(Collectors.toList());

        List<Long> fileId = board.getUploadFiles().stream()
            .map(UploadFile::getId)
            .collect(Collectors.toList());

        BoardResponseDto boardDto = new BoardResponseDto(
                board.getId(),
                board.getTitle(),
                board.getContent(),
                board.getViews(),
                board.getUser().getNickname(),
                board.getClassification().getCategory(),
                board.getCreatedDate(),
                board.getModifiedDate(),
                likedName,
                fileId,
                filenames);
        return boardDto;
    }

}