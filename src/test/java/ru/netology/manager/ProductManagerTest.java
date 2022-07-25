package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

public class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Product first = new Product(1, "Flower", 1500);
    private Book second = new Book(2, "The night is tender", 400, "Francis Scott Fitzgerald");
    private Smartphone third = new Smartphone(3, "Redmi Note", 15000, "Xiaomi");

    @Test
    void shouldAdd() {
        manager.add(first);
        manager.add(second);
        manager.add(third);

        Product[] expected = {first, second, third};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByProduct() {
        manager.add(first);
        manager.add(third);

        Product [] expected = {first};
        Product [] actual = manager.searchBy("Flower");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByBook() {
        manager.add(first);
        manager.add(second);

        Product[] expected = {second};
        Product[] actual = manager.searchBy("The night is tender");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBySmartphone() {
        manager.add(first);
        manager.add(third);

        Product[] expected = {third};
        Product[] actual = manager.searchBy("Redmi Note");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByNone() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("Cherry");

        assertArrayEquals(expected, actual);
    }
}
