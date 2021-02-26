package ru.netology.manager;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.doReturn;
import static ru.netology.domain.Genre.ACTION;
import static ru.netology.domain.Genre.COMEDY;
import static ru.netology.domain.Genre.THRILLER;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.MovieItem;
import ru.netology.repository.MovieRepository;


@ExtendWith(MockitoExtension.class)
class MovieManagerWithMockitoTest {
    @Mock
    private MovieRepository repo;
    @InjectMocks
    private MovieManager manager;
    private final MovieItem first = new MovieItem(1, "Мертвые не потеют 1", ACTION);
    private final MovieItem second = new MovieItem(2, "Мертвые не потеют 2", COMEDY);
    private final MovieItem third = new MovieItem(3, "Мертвые не потеют 3", THRILLER);


    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
    }

    @Test
    void shouldGetSome() {
        MovieItem[] mocked = new MovieItem[] {first, second, third};
        doReturn(mocked).when(repo).findAll();

        int numberToShow = 2;

        var actual = manager.get(numberToShow);
        var expected = new MovieItem[]{third, second};

        assertArrayEquals(expected, actual);
    }
}