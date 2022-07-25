package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

public class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Product first = new Product(1, "Flower", 1500);
    private Book second = new Book(2, "The night is tender", 400, "Francis Scott Fitzgerald");
    private Smartphone third = new Smartphone(3, "Redmi Note", 15000, "Xiaomi");

    @Test
    void shouldSaveNewProductIfNot() {
        repository.save(first);

        Product[] expected = {first};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSaveNewProductIfIs() {
        repository.save(first);
        repository.save(second);
        repository.save(third);

        Product[] expected = {first, second, third};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAll() {
        repository.save(first);
        repository.save(third);

        Product[] expected = {first, third};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAllNone() {
        Product[] expected = {};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveById() {
        repository.save(first);
        repository.save(second);
        repository.save(third);

        repository.removeById(2);
        Product[] expected = {first, third};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }
}
