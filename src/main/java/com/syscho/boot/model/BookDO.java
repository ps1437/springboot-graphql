package com.syscho.boot.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "BOOKS")
public class BookDO {
    private int id;
    @Id
    private String title;
    private String author;
    private String genre;
    private int height;
    private String publisher;
}
