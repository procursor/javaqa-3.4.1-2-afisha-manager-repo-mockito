package ru.netology.manager;

import lombok.Getter;
import lombok.val;
import org.apache.commons.lang3.ArrayUtils;
import ru.netology.domain.MovieItem;

public class MovieManager {
    static final int DEFAULT_FEED_SIZE = 10;

    @Getter
    @val int FEED_SIZE;
    private MovieItem[] movies;

    MovieManager(int moviesNumber) {
        if (moviesNumber < 1) {
            FEED_SIZE = DEFAULT_FEED_SIZE;
        } else {
            FEED_SIZE = moviesNumber;
        }
    }

    MovieManager() {
        FEED_SIZE = DEFAULT_FEED_SIZE;
    }

    public void add(MovieItem item) {
        movies = ArrayUtils.add(movies, item);
    }

    public MovieItem[] getAll() {
        var items = ArrayUtils.clone(movies);
        ArrayUtils.reverse(items);
        return ArrayUtils.subarray(items, 0, FEED_SIZE);
    }
}
