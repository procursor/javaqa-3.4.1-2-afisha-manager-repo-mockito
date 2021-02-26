package ru.netology.domain;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MovieItem {
    private final int id;
    private final String title;
    private final Genre genre;
}
