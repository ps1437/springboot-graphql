package com.syscho.boot.vo;

import com.syscho.boot.model.BookDO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class BookVO {
    private int id;
    private String title;
    private String author;
    private String genre;
    private int height;
    private String publisher;

    public BookVO(BookDO bookDO) {
        this.id = bookDO.getId();
        this.title = bookDO.getTitle();
        this.author = bookDO.getAuthor();
        this.genre = bookDO.getGenre();
        this.height = bookDO.getHeight();
        this.publisher = bookDO.getPublisher();
    }
}
