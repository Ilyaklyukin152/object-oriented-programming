package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class ProductBasket {
    private final LinkedList<Product> productBasket = new LinkedList<>();

    public void addProduct(Product product) {
        productBasket.add(product);
    }

    public void removeProduct(String name) {
        ArrayList<Product> removed = new ArrayList<>();
        Iterator<Product> iterator = productBasket.iterator();

        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getProductName().equals(name)) {
                removed.add(product);
                iterator.remove();
            }
        }
        if (removed.isEmpty()) {
            System.out.println("Список удалённых продуктов пуст");
        } else {
            System.out.println("Удалённые продукты:" + removed);
        }
    }

    public int fullPriceBasket() {
        int fullPrice = 0;
        for (Product product : productBasket) {
            if (product != null) {
                fullPrice += product.getProductPrice();
            }
        }
        return fullPrice;
    }

    public void printContentBasket() {
        int special = 0;
        for (Product product : productBasket) {
            if (product != null) {
                System.out.println(product);
            }
            if (product != null && product.isSpecial()) {
                special++;
            }
        }
        if (fullPriceBasket() == 0) {
            System.out.println("В корзине пусто");
        } else {
            System.out.printf("Итого: %s рублей\nСпециальных товаров: %s\n", fullPriceBasket(), special);
        }
    }

    public boolean nameProductBasket(String productName) {
        for (Product product : productBasket) {
            if (product != null && product.getProductName().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    public void cleanBasket() {
        productBasket.clear();
    }
}
