package ru.netology.manager;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static ru.netology.domain.Genre.ACTION;
import static ru.netology.domain.Genre.COMEDY;
import static ru.netology.domain.Genre.THRILLER;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.MovieItem;
import ru.netology.manager.MovieManager;
import ru.netology.repository.MovieRepository;


class MovieManagerTest {
    private final MovieItem first = new MovieItem(1, "Мертвые не потеют 1", ACTION);
    private final MovieItem second = new MovieItem(2, "Мертвые не потеют 2", COMEDY);
    private final MovieItem third = new MovieItem(3, "Мертвые не потеют 3", THRILLER);

    private final MovieRepository repo = new MovieRepository();
    private final MovieManager manager = new MovieManager(repo);

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
    }

    @AfterEach
    void tearDown() {
        repo.removeAll();
    }

    @Test
    public void shouldRemoveIfExists() {
        int idToRemove = 1;

        manager.removeById(idToRemove);

        var actual = manager.get();
        var expected = new MovieItem[]{third, second};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotRemoveIfNotExists() {
        int idToRemove = 4;

        manager.removeById(idToRemove);

        var actual = manager.get(idToRemove);
        var expected = new MovieItem[]{third, second, first};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetAll() {
        int numberToShow = 0;

        var actual = manager.get(numberToShow);
        var expected = new MovieItem[]{third, second, first};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetSome() {
        int numberToShow = 2;

        var actual = manager.get(numberToShow);
        var expected = new MovieItem[]{third, second};

        assertArrayEquals(expected, actual);
    }
}