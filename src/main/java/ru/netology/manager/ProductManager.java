package ru.netology.manager;

import ru.netology.domain.Product;
import ru.netology.repository.ProductRepository;

public class ProductManager {
    private ProductRepository repository = new ProductRepository();

    public ProductManager() {
    }

    public void add(Product product) {
        repository.add(product);
    }

    public Product[] findAll() {
        return repository.findAll();
    }

    public Product[] removeById(int id) {
        return repository.removeById(id);
    }

    public boolean matches(Product product, String search) {
        if (product.getTitle().contains(search)) {
            return true;
        } else {
            return false;
        }
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0];
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }
}