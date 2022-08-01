package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

public class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    Book book1 = new Book(1, "Beautiful and cursed", 500, "Francis Scott Fitzgerald");
    Book book2 = new Book(2, "The night is tender", 400, "Francis Scott Fitzgerald");
    Smartphone phone1 = new Smartphone(3, "Redmi Note", 15000, "Xiaomi");
    Smartphone phone2 = new Smartphone(4, "Redmi Note2", 16000, "Xiaomi");

    @Test
    public void shouldAdd() {
        manager.add(book1);
        manager.add(book2);
        manager.add(phone1);
        manager.add(phone2);

        Product[] expected = {book1, book2, phone1, phone2};
        Product[] actual = manager.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByProduct() {
        manager.add(book1);
        manager.add(book2);
        manager.add(phone1);
        manager.add(phone2);

        Product [] expected = {book1};
        Product [] actual = manager.searchBy("Beautiful and cursed");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByBook() {
        manager.add(book1);
        manager.add(book2);

        Product[] expected = {book2};
        Product[] actual = manager.searchBy("The night is tender");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBySmartphone() {
        manager.add(book2);
        manager.add(phone1);

        Product[] expected = {phone1};
        Product[] actual = manager.searchBy("Redmi Note");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByNone() {
        manager.add(book1);
        manager.add(book2);
        manager.add(phone1);
        manager.add(phone2);

        Product[] expected = {};
        Product[] actual = manager.searchBy("Cherry");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindById() {
        repository.save(book1);
        repository.save(book2);
        repository.save(phone1);
        repository.save(phone2);

        Product expected = phone1;
        Product actual = manager.findById(3);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindBookAuthor() {
        repository.save(book1);
        repository.save(book2);
        repository.save(phone1);
        repository.save(phone2);

        Product[] expected = {book1,book2};
        Product[] actual = manager.searchBy("Francis Scott Fitzgerald");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindBookTitle() {
        repository.save(book1);
        repository.save(book2);
        repository.save(phone1);
        repository.save(phone2);

        Product[] expected = {book1};
        Product[] actual = manager.searchBy("Beautiful and cursed");

        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldFindPhoneManufacturer() {
        repository.save(book1);
        repository.save(book2);
        repository.save(phone1);
        repository.save(phone2);

        Product[] expected = {phone1, phone2};
        Product[] actual = manager.searchBy("Xiaomi");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindPhoneTitle() {
        repository.save(book1);
        repository.save(book2);
        repository.save(phone1);
        repository.save(phone2);

        Product[] expected = {phone2};
        Product[] actual = manager.searchBy("Redmi Note2");

        assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldRemoveById() {
        repository.save(book1);
        repository.save(book2);
        repository.save(phone1);
        repository.save(phone2);

        repository.removeById(3);
        repository.removeById(1);

        Product[] expected = {book2, phone2};
        Product[] actual = manager.findAll();

        assertArrayEquals(expected, actual);
    }

}
