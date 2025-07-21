package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;


public class ProductBasket {
    private final Map<String, List<Product>> productBasket = new HashMap<>();

    public void addProduct(Product product) {
        productBasket.computeIfAbsent(product.getProductName(), p -> new ArrayList<>()).add(product);
    }

    public void removeProduct(String name) {
        List<Product> removed = productBasket.remove(name);
        if (removed != null) {
            System.out.println("Удалённые продукты:" + removed);
        } else {
            System.out.println("Список удалённых продуктов пуст");
        }

    }

    public int fullPriceBasket() {
        return productBasket.values().stream()
                .flatMap(Collection::stream)
                .mapToInt(Product::getProductPrice)
                .sum();
    }

    public void printContentBasket() {
        System.out.println("\nПечать содержимого корзины:");
        if (productBasket.isEmpty()) {
            System.out.println("В корзине пусто");
            return;
        }

        productBasket.values().stream()
                .flatMap(Collection::stream)
                .forEach(System.out::println);

        System.out.printf("Итого: %s рублей\nСпециальных товаров: %s\n\n", fullPriceBasket(), getSpecialCount());
    }

    private int getSpecialCount() {
        return (int) productBasket.values().stream()
                .flatMap(Collection::stream)
                .filter(Product::isSpecial)
                .count();
    }


    public boolean nameProductBasket(String productName) {
        for (List<Product> productList : productBasket.values()) {
            for (Product product : productList) {
                if (product.getProductName().equals(productName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void cleanBasket() {
        productBasket.clear();
    }
}
