package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager();
    Product book1 = new Book(1, "Beautiful and cursed", 500, "Francis Scott Fitzgerald");
    Product book2 = new Book(2, "The night is tender", 400, "Francis Scott Fitzgerald");
    Product phone1 = new Smartphone(3, "Redmi Note", 15000, "Xiaomi");
    Product phone2 = new Smartphone(4, "Redmi Note2", 16000, "Xiaomi");

    @Test
    public void shouldAddAndFindAll() {
        ProductManager manager = new ProductManager();

        manager.add(book1);
        manager.add(book2);
        manager.add(phone1);
        manager.add(phone2);

        Product[] actual = manager.findAll();
        Product[] expected = {book1, book2, phone1, phone2};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddAndSearchByProducer() {
        ProductManager manager = new ProductManager();

        manager.add(book1);
        manager.add(book2);
        manager.add(phone1);
        manager.add(phone2);

        Product[] actual = manager.searchBy("Note");
        Product[] expected = {phone1, phone2};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddAndSearchByTitle() {
        ProductManager manager = new ProductManager();

        manager.add(book1);
        manager.add(book2);
        manager.add(phone1);
        manager.add(phone2);

        Product[] actual = manager.searchBy("The night is tender");
        Product[] expected = {book2};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void matches() {
        ProductManager manager = new ProductManager();

        manager.add(book1);
        manager.add(book2);
        manager.add(phone1);
        manager.add(phone2);

        Boolean actual = manager.matches(book2, "The");
        Boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        ProductManager manager = new ProductManager();

        manager.add(book1);
        manager.add(book2);
        manager.add(phone1);
        manager.add(phone2);

        Product[] actual = manager.removeById(3);
        Product[] expected = {book1, book2, phone2};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByProduct() {
        manager.add(book1);
        manager.add(book2);
        manager.add(phone1);
        manager.add(phone2);

        Product[] expected = {book1};
        Product[] actual = manager.searchBy("Beautiful and cursed");

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
    public void shouldFindBookTitle() {
        manager.add(book1);
        manager.add(book2);
        manager.add(phone1);
        manager.add(phone2);

        Product[] expected = {book1};
        Product[] actual = manager.searchBy("Beautiful and cursed");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindPhoneTitle() {
        manager.add(book1);
        manager.add(book2);
        manager.add(phone1);
        manager.add(phone2);

        Product[] expected = {phone2};
        Product[] actual = manager.searchBy("Redmi Note2");

        assertArrayEquals(expected, actual);
    }
}
