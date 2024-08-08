package com.example.notice_board.dto;

import org.springframework.lang.NonNull;

public class PostDto {

    @NonNull
    private String title;

    @NonNull
    private String writer;

    @NonNull
    private String content;

    @NonNull
    private String password;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
