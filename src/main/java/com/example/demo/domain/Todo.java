package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class Todo {
    private int id;
    private String title;
    private String body;
    private boolean finished;
}
