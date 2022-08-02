package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    Product book1 = new Book(1, "Beautiful and cursed", 500, "Francis Scott Fitzgerald");
    Product book2 = new Book(2, "The night is tender", 400, "Francis Scott Fitzgerald");
    Product phone1 = new Smartphone(3, "Redmi Note", 15000, "Xiaomi");
    Product phone2 = new Smartphone(4, "Redmi Note2", 16000, "Xiaomi");

    @Test
    public void addAndGetProducts() {
        ProductRepository repository = new ProductRepository();

        repository.add(book1);
        repository.add(book2);
        repository.add(phone1);
        repository.add(phone2);

        Product[] actual = repository.getProducts();
        Product[] expected = {book1, book2, phone1, phone2};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void addAndGetProductsIfEmpty() {
        ProductRepository repository = new ProductRepository();

        Product[] actual = repository.getProducts();
        Product[] expected = {};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void findAll() {
        ProductRepository repository = new ProductRepository();

        repository.add(book1);
        repository.add(book2);
        repository.add(phone1);
        repository.add(phone2);

        Product[] actual = repository.findAll();
        Product[] expected = {book1, book2, phone1, phone2};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void findAllIfOneProduct() {
        ProductRepository repository = new ProductRepository();

        repository.add(book2);

        Product[] actual = repository.findAll();
        Product[] expected = {book2};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void removeById() {
        ProductRepository repository = new ProductRepository();

        repository.add(book1);
        repository.add(book2);
        repository.add(phone1);
        repository.add(phone2);

        Product[] actual = repository.removeById(3);
        Product[] expected = {book1, book2, phone2};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void removeByIdIfOneProduct() {
        ProductRepository repository = new ProductRepository();
        repository.add(book1);

        Product[] actual = repository.removeById(1);
        Product[] expected = {};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllNone() {
        Product[] expected = {};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }
}
