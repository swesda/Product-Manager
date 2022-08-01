package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

public class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    Book book1 = new Book(1, "Beautiful and cursed", 500, "Francis Scott Fitzgerald");
    Book book2 = new Book(2, "The night is tender", 400, "Francis Scott Fitzgerald");
    Smartphone phone1 = new Smartphone(3, "Redmi Note", 15000, "Xiaomi");
    Smartphone phone2 = new Smartphone(4, "Redmi Note2", 16000, "Xiaomi");

    @Test
    public void shouldSaveNewProductIfNot() {
        repository.save(book1);

        Product[] expected = {book1};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveNewProductIfIs() {
        repository.save(book1);
        repository.save(book2);
        repository.save(phone1);
        repository.save(phone2);

        Product[] expected = {book1, book2, phone1, phone2};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAll() {
        repository.save(book1);
        repository.save(phone1);

        Product[] expected = {book1, phone1};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllNone() {
        Product[] expected = {};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        repository.save(book1);
        repository.save(book2);
        repository.save(phone1);

        repository.removeById(2);
        Product[] expected = {book1, phone1};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldFindById() {
        repository.save(book1);
        repository.save(book2);
        repository.save(phone1);
        repository.save(phone2);

        Product expected = book2;
        Product actual = repository.findById(2);

        assertEquals(expected, actual);
    }
    @Test
    public void shouldFindByNotId() {
        repository.save(book1);
        repository.save(book2);
        repository.save(phone1);
        repository.save(phone2);

        Product expected = (null);
        Product actual = repository.findById(5);

        assertEquals(expected, actual);
    }
}
