package ru.netology.repository;

import ru.netology.domain.Product;

public class ProductRepository {
    Product[] products = new Product[0];

    public ProductRepository() {
    }

    public Product[] getProducts() {
        return products;
    }

    public void add(Product product) {
        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = product;
        products = tmp;
    }

    public Product[] findAll() {
        return getProducts();
    }

    public Product[] removeById(int id) {
        int length = products.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[index] = product;
                index++;
            }
        }
        products = tmp;
        return products;
    }
}