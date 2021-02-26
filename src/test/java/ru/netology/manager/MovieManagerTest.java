package ru.netology.manager;

import java.util.Arrays;
import org.junit.jupiter.api.*;
import ru.netology.domain.MovieItem;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.netology.domain.Genre.*;
import static ru.netology.manager.MovieManager.DEFAULT_FEED_SIZE;


class MovieManagerTest {
    private final MovieItem first = new MovieItem(1, "Мертвые не потеют 1", ACTION);
    private final MovieItem second = new MovieItem(2, "Мертвые не потеют 2", COMEDY);
    private final MovieItem third = new MovieItem(3, "Мертвые не потеют 3", THRILLER);

    /*
    Manager should get to the actual feed all the movies added in reverse order
     */
    @Test
    void shouldGetAllByDefault() {
        MovieManager manager = new MovieManager();
        manager.add(first);
        manager.add(second);
        manager.add(third);

        MovieItem[] actual = manager.getAll();
        MovieItem[] expected = {third, second, first};

        assertArrayEquals(expected, actual);

        System.out.println("MovieManagerTest.getAllByDefault");
        System.out.println(Arrays.toString(actual));
    }

    /*
    Manager should get to the feed only last two movies added in reverse order
     */
    @Test
    void shouldGetAllWithParam() {
        MovieManager manager = new MovieManager(2);
        manager.add(first);
        manager.add(second);
        manager.add(third);

        MovieItem[] actual = manager.getAll();
        MovieItem[] expected = {third, second};

        assertArrayEquals(expected, actual);

        System.out.println("MovieManagerTest.getAllWithParam");
        System.out.println(Arrays.toString(actual));
    }

    /*
    Basic Constructor sanity check
     */
    @Test
    void shouldCreateWithDefaultFeedSize() {
        MovieManager man = new MovieManager(0);
        assertEquals(DEFAULT_FEED_SIZE, man.getFEED_SIZE());
    }
}